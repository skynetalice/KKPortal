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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import com.google.gwt.core.ext.Generator;
import com.google.gwt.core.ext.GeneratorContext;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.NotFoundException;
import com.google.gwt.core.ext.typeinfo.TypeOracle;
import com.google.gwt.user.rebind.ClassSourceFileComposerFactory;
import com.google.gwt.user.rebind.SourceWriter;

public class VersionGenerator extends Generator {

	private String packageName;
	private String className;
	private TypeOracle typeOracle;
	
	@Override
	public String generate(TreeLogger logger, GeneratorContext context,
			String typeName) throws UnableToCompleteException {
	    try {
	    	typeOracle = context.getTypeOracle();
	    	JClassType classType = typeOracle.getType(typeName);
	    	packageName = classType.getPackage().getName();
	    	className = classType.getSimpleSourceName() + "Impl";
	    	generateClass(logger, context);
		} catch (NotFoundException e) {
			logger.log(TreeLogger.ERROR, "Exception during ModuleRegistry creation.", e);
			throw new UnableToCompleteException();
		}
		return packageName + "." + className;
	}

	private void generateClass(TreeLogger logger, GeneratorContext context) {
		PrintWriter printWriter = context.tryCreate(logger, packageName, className);
		
		if (printWriter == null){
			return;
		}
		
		ClassSourceFileComposerFactory composer = new ClassSourceFileComposerFactory(packageName,className);
		
		composer.addImplementedInterface(Version.class.getCanonicalName());
		
		SourceWriter sourceWriter = composer.createSourceWriter(context,printWriter);
		
		writeGetSHA1(sourceWriter);
		writeGetTag(sourceWriter);
		
		sourceWriter.outdent();
		sourceWriter.println("}");
		
		context.commit(logger, printWriter);
	}
	
	private void writeGetSHA1(SourceWriter sourceWriter) {
		sourceWriter.println("public String getSHA1(){");
		sourceWriter.indent();
		sourceWriter.print("return \"");
		String result = executeCommand("git rev-parse HEAD");
		if (result != null){
			sourceWriter.print(escape(result));
		}
		sourceWriter.println("\";");
		sourceWriter.outdent();
		sourceWriter.println("}");
	}

	private void writeGetTag(SourceWriter sourceWriter) {
		sourceWriter.println("public String getTag(){");
		sourceWriter.indent();
		sourceWriter.print("return \"");
		String result = executeCommand("git describe --tags --always HEAD");
		if (result != null){
			sourceWriter.print(escape(result));
		}
		sourceWriter.println("\";");
		sourceWriter.outdent();
		sourceWriter.println("}");		
	}
	
	private String executeCommand(String command){
		Process child;
		try {
			child = Runtime.getRuntime().exec(command);
			BufferedReader r = new BufferedReader(new InputStreamReader(child.getInputStream()));
			return r.readLine();
		} catch (IOException e) {
			return e.toString();
		}
	}
}