/*
 * Copyright 2010 kk-electronic a/s. 
 * 
 * This file is part of KKPortal.
 *
 * KKPortal is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * KKPortal is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with KKPortal.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package com.kk_electronic.gwt.rebind;

import java.io.PrintWriter;
import java.util.HashMap;

import com.google.gwt.core.ext.Generator;
import com.google.gwt.core.ext.GeneratorContext;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.NotFoundException;
import com.google.gwt.core.ext.typeinfo.TypeOracle;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.user.rebind.ClassSourceFileComposerFactory;
import com.google.gwt.user.rebind.SourceWriter;
import com.kk_electronic.kkportal.core.reflection.ClassMap;

public class ClassMapGenerator extends Generator {

	private String packageName;
	private String className;
	private TypeOracle typeOracle;
	private JClassType classType;
	private JClassType keyType;
	private JClassType valueType;
	private TreeLogger logger;
	
	@Override
	public String generate(TreeLogger logger, GeneratorContext context,
			String typeName) throws UnableToCompleteException {
		this.logger = logger;
		try {
	    	typeOracle = context.getTypeOracle();
	    	classType = typeOracle.getType(typeName);
	    	packageName = classType.getPackage().getName();
	    	className = classType.getSimpleSourceName() + "Impl";
	    	classType.getAnnotation(GinModules.class);
	    	generateClass(logger, context);
		} catch (NotFoundException e) {
			logger.log(TreeLogger.ERROR, "Exception during ClassMap creation.", e);
			throw new UnableToCompleteException();
		}
		return packageName + "." + className;
	}

	private void generateClass(TreeLogger logger, GeneratorContext context) throws UnableToCompleteException, NotFoundException {
		PrintWriter printWriter = context.tryCreate(logger, packageName, className);
		
		if (printWriter == null){
			return;
		}
		
		ClassSourceFileComposerFactory composer = new ClassSourceFileComposerFactory(packageName,className);

		composer.addImport(HashMap.class.getCanonicalName());
		
		composer.addImplementedInterface(classType.getQualifiedSourceName());
		JClassType target = typeOracle.getType(ClassMap.class.getCanonicalName());
		for (JClassType interfaze:classType.getImplementedInterfaces()){
			if(interfaze.getErasedType().equals(target.getErasedType())){
				JClassType[] genericTypes = interfaze.isParameterized().getTypeArgs();
				keyType = genericTypes[0];
				valueType = genericTypes[1];
			}
		}
		
//		if (!"java.lang.String".equals(keyType.getQualifiedSourceName())){
//			logger.log(TreeLogger.ERROR, "keyType must be a String for now");
//			throw new UnableToCompleteException();
//		}
		
		composer.addImport(keyType.getQualifiedSourceName());
		composer.addImport(valueType.getQualifiedSourceName());

		SourceWriter sourceWriter = composer.createSourceWriter(context,printWriter);
		
		writeMethods(sourceWriter);
		writeData(sourceWriter);
		
		sourceWriter.outdent();
		sourceWriter.println("}");
		
		context.commit(logger, printWriter);
	}
		
	private void writeData(SourceWriter sw) throws UnableToCompleteException {
		sw.println();
		sw.println("{");
		sw.indent();
		for(JClassType classType:valueType.getSubtypes()){
			String key = getKeyFromClass(classType);
			sw.println("map.put("+key+","+classType.getQualifiedSourceName()+".class);");
			sw.println("reversemap.put("+classType.getQualifiedSourceName()+".class, "+key+");");
		}
		sw.outdent();
		sw.println("}");
	}

	private void writeMethods(SourceWriter sw) {
		sw.print("private static HashMap<"+keyType.getName()+", Class<? extends "+valueType.getName()+">> map");
		sw.println("= new HashMap<"+keyType.getName()+", Class<? extends "+valueType.getName()+">>();");
		sw.print("private static HashMap<Class<? extends "+valueType.getName()+">,"+keyType.getName()+"> reversemap");
		sw.println("= new HashMap<Class<? extends "+valueType.getName()+">,"+keyType.getName()+">();");
		sw.println();
		sw.println("@Override");
		sw.println("public Class<? extends "+valueType.getName()+"> getClassFromKey("+keyType.getName()+" name) {");
		sw.println("	return map.get(name);");
		sw.println("}");
		sw.println();
		sw.println("@Override");
		sw.println("public "+keyType.getName()+" getKeyFromClass(Class<? extends "+valueType.getName()+"> clazz) {");
		sw.println("	return reversemap.get(clazz);");
		sw.println("}");
	}

	private String getKeyFromClass(JClassType j) throws UnableToCompleteException{
		MapKey x = j.getAnnotation(MapKey.class);
		if(x != null){
			return x.value();
		}
		if( "java.lang.String".equals(keyType.getQualifiedSourceName()) ){
			return "\"" + escape(j.getName()) + "\"";
		}
		if( "java.lang.Integer".equals(keyType.getQualifiedSourceName()) ){
			return String.valueOf(j.getName().hashCode());
		}
		logger.log(TreeLogger.ERROR, "keyType can only be autogenerated for Integers and Strings - supply @MapKey annotation");
		throw new UnableToCompleteException();
	}
}