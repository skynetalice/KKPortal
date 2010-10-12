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
package com.kk_electronic.kkportal.core.reflection;

import com.google.gwt.core.client.GWT;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.kk_electronic.kkportal.core.WebPageInjectConfig;
import com.kk_electronic.kkportal.core.inject.ClassNotFoundException;
import com.kk_electronic.kkportal.core.inject.FlexInjector;

public class Injection {
	
	private Injection(){
		
	}
	
	@GinModules(WebPageInjectConfig.class)
	public static interface ApplicationInjector extends FlexInjector{};

	public static final ApplicationInjector injector = 	GWT.create(ApplicationInjector.class);;
	
	public static ApplicationInjector getInjector() {
		return injector;
	}
	
	public static class PeekCall<T> implements AsyncCallback<T>{
		private T result;

		@Override
		public void onFailure(Throwable caught) {}

		@Override
		public void onSuccess(T result) {
			this.result = result;
		}

		public T getResult() {
			return result;
		}
	}
	
	public static <T> T create(Class<T> type) throws ClassNotFoundException{
		PeekCall<T> peekCall = new PeekCall<T>();
		injector.create(type,peekCall);
		if(peekCall.getResult() == null){
			throw new ClassNotFoundException();
		}
		return peekCall.getResult();
	}
	
	public static <T> void create(Class<T> type, AsyncCallback<T> callback){
		injector.create(type, callback);
	}
}
