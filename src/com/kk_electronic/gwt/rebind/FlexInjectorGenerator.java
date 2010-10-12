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
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.core.ext.Generator;
import com.google.gwt.core.ext.GeneratorContext;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.JMethod;
import com.google.gwt.core.ext.typeinfo.JType;
import com.google.gwt.core.ext.typeinfo.NotFoundException;
import com.google.gwt.core.ext.typeinfo.TypeOracle;
import com.google.gwt.inject.client.GinModule;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.rebind.ClassSourceFileComposerFactory;
import com.google.gwt.user.rebind.SourceWriter;
import com.kk_electronic.kkportal.core.inject.ConstructFromLiteral;
import com.kk_electronic.kkportal.core.inject.FlexInjector;

public class FlexInjectorGenerator extends Generator {

	private String packageName;
	private String className;
	private TypeOracle typeOracle;
	private TreeLogger logger;
	private GinModules modules;
	private JClassType classType;
	
	@Override
	public String generate(TreeLogger logger, GeneratorContext context,
			String typeName) throws UnableToCompleteException {
		this.logger = logger;
	    try {
	    	typeOracle = context.getTypeOracle();
	    	classType = typeOracle.getType(typeName);
	    	packageName = classType.getPackage().getName();
	    	className = classType.getSimpleSourceName() + "Impl";
	    	modules = classType.getAnnotation(GinModules.class);
	    	generateClass(logger, context);
		} catch (NotFoundException e) {
			logger.log(TreeLogger.ERROR, "Exception during ModuleRegistry creation.", e);
			throw new UnableToCompleteException();
		}
		return packageName + "." + className;
	}

	private void generateClass(TreeLogger logger, GeneratorContext context) throws UnableToCompleteException {
		PrintWriter printWriter = context.tryCreate(logger, packageName, className);
		
		if (printWriter == null){
			return;
		}
		
		ClassSourceFileComposerFactory composer = new ClassSourceFileComposerFactory(packageName,className);
		composer.addImport(GWT.class.getCanonicalName());
		composer.addImport(RunAsyncCallback.class.getCanonicalName());
		composer.addImport(Ginjector.class.getCanonicalName());
		composer.addImport(GinModules.class.getCanonicalName());
		composer.addImport(AsyncCallback.class.getCanonicalName());
		composer.addImport(FlexInjector.class.getCanonicalName());
		composer.addImport(Map.class.getCanonicalName());
		composer.addImport(HashMap.class.getCanonicalName());
		
		composer.addImplementedInterface(classType.getQualifiedSourceName());

		SourceWriter sourceWriter = composer.createSourceWriter(context,printWriter);
		writeStatic(sourceWriter);
		writeGateways(sourceWriter);
//		writeCreate(sourceWriter);
		writeConstructor(sourceWriter);
		sourceWriter.outdent();
		sourceWriter.println("}");
		
		context.commit(logger, printWriter);
	}
	
	private void writeFragment(SourceWriter sw,JClassType j){
		sw.println("fragmentMap.put(" + j.getQualifiedSourceName() + ".class, new FlexInjector() {");
		sw.indent();
		sw.println("@Override");
		sw.println("public <E> void create(Class<? extends E> type, AsyncCallback<E> callback) {");
		sw.indentln("callback.onSuccess((E)injector.create$"+j.getQualifiedSourceName().replace('.', '$')+"());");
		sw.println("}");
		sw.outdent();
		sw.println("});");
	}

	private void writeGateways(SourceWriter sw) throws UnableToCompleteException{
		for(String key : getClasses().keySet()){
			if(key == null) continue;
			sw.println("private final class fragment$"+key+" implements FlexInjector {");
			sw.indent();
			sw.println();
			sw.println("@Override");
			sw.println("public <T> void create(final Class<? extends T> type, final AsyncCallback<T> callback) {");
			sw.indent();
			sw.println("GWT.runAsync(new RunAsyncCallback() {");
			sw.indent();
			sw.println("@Override");
			sw.println("public void onSuccess() {");
			for(JClassType j : getClasses().get(key)){
				writeFragment(sw, j);
			}
			sw.indent();
			sw.println(className+".this.create(type, callback);");
			sw.outdent();
			sw.println("}");
			sw.println("public void onFailure(Throwable reason) {");
			sw.indent();
			for(JClassType j : getClasses().get(key)){
				sw.println("fragmentMap.remove("+j.getQualifiedSourceName()+".class);");
			}
			sw.println("callback.onFailure(reason);");
			sw.outdent();
			sw.println("}");
			sw.outdent();
			sw.println("});");
			sw.outdent();
			sw.println("}");
			sw.outdent();
			sw.println("}");
		}
	}

	
	private void writeConstructor(SourceWriter sw) throws UnableToCompleteException {
		sw.println();
		sw.println("@SuppressWarnings(\"unchecked\")");
		sw.println("public "+className+"() {");
		sw.indent();
		sw.println("FlexInjector fragment;");
		for(String key : getClasses().keySet()){
			if(key != null){
				sw.println("fragment = new fragment$"+key+"();");
				for(JClassType j : getClasses().get(key)){
					sw.println("fragmentMap.put(" + j.getQualifiedSourceName() + ".class, fragment);");
				}
			} else {
				for(JClassType j : getClasses().get(key)){
					writeFragment(sw, j);
				}				
			}
		}
		sw.outdent();
		sw.println("}");
	}

	private void writeStatic(SourceWriter sw) throws UnableToCompleteException {
		modules.toString();
		sw.print("@GinModules(");
		for (Class<? extends GinModule> s:modules.value()){
			sw.print(s.getCanonicalName());
			sw.print(".class");
		}
		sw.println(")");
		sw.println("static interface Injector extends Ginjector {");
		sw.indent();
		Set<JType> set = new HashSet<JType>();
		for(Vector<JClassType> group : getClasses().values()){
			set.addAll(group);
		}
		for(JMethod method:classType.getMethods()){
			set.add(method.getReturnType());
		}
		for(JType j : set){
			sw.println(j.getQualifiedSourceName() + " create$" + j.getQualifiedSourceName().replace('.', '$') + "();");
		}
//		for(Vector<JClassType> group : getClasses().values()){
//			for(JClassType j : group){
//				sw.println(j.getQualifiedSourceName() + " create$" + j.getQualifiedSourceName().replace('.', '$') + "();");
//			}
//		}
		sw.outdent();
		sw.println("}");
		sw.println();
		sw.println("private final Injector injector = GWT.create(Injector.class);");
		sw.println("private Map<Class<?>, FlexInjector> fragmentMap = new HashMap<Class<?>, FlexInjector>();");
		sw.println();
		sw.println("@Override");
		sw.println("public <T> void create(Class<? extends T> type, AsyncCallback<T> callback) {"	);		
		sw.println("	FlexInjector x = fragmentMap.get(type);");
		sw.println("	if (x != null){");
		sw.println("		x.create(type, callback);");
		sw.println("	} else {");
//		sw.println("		callback.onFailure(new ClassNotFoundException());");
		sw.println("		callback.onFailure(null);");
		sw.println("		GWT.log(\"Class Creation of \" + type + \" failed\");");
		sw.println("	}");
		sw.println("}");
	}
	
	private Map<String, Vector<JClassType>> groups;
	
	private void addClass(JClassType j){
		assert(this.groups != null);
		String key = getKeyFromClass(j);
		Vector<JClassType> vector = groups.get(key);
		if(vector == null){
			vector = new Vector<JClassType>();
		}
		vector.add(j);
		groups.put(key, vector);
	}
	
	private String getKeyFromClass(JClassType j){
		ModuleGroup x = j.getAnnotation(ModuleGroup.class);
		if(x != null){
			return x.value().replaceAll("[- ]", "");
		}
		return null;
	}
	
	private Map<String, Vector<JClassType>> getClasses() throws UnableToCompleteException{
		if (this.groups != null){
			return this.groups;
		}
		
		this.groups = new HashMap<String, Vector<JClassType>>();
		
		try {
			typeOracle.getType(ConstructFromLiteral.class.getCanonicalName());
		} catch (NotFoundException error) {
			logger.log(TreeLogger.ERROR, "Can't find marker interface", error);
			throw new UnableToCompleteException();
		}
		
		
		for(JClassType j : typeOracle.getTypes()){
			ConstructFromLiteral a = j.getAnnotation(ConstructFromLiteral.class);
			if(a != null){
				if(a.includeConcreteClasses() && (j.isClass() != null && !j.isAbstract())){
					addClass(j);
				}
				if(a.includeInterfaces() && (j.isInterface() != null)){
					addClass(j);
				}
				if (a.recursive()) {
					for (JClassType e : j.getSubtypes()) {
						if (a.includeConcreteClasses() && (e.isClass() != null && !e.isAbstract())) {
							addClass(e);
						}
						if (a.includeInterfaces() && (e.isInterface() != null)) {
							addClass(e);
						}
					}
				}
			}
		}
		return groups;
	}
}