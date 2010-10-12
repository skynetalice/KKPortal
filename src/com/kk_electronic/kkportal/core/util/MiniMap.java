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
package com.kk_electronic.kkportal.core.util;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

/**
 * Lightweight Map using javascript objects.
 * 
 * @author Jes Andersen
 *
 * @param <V>
 */
public class MiniMap<V> extends JavaScriptObject {
	/**
	 * {@link JavaScriptObject} cannot be created directly. <br>
	 * MiniMap m = {@link JavaScriptObject#createObject()}.{@link JavaScriptObject#cast() cast()}
	 */
	protected MiniMap() {
	};

	public final native JsArrayString keys() /*-{
		keys = [];
		for(var key in this){
			keys.push(key)
		}
		return keys
	}-*/;

	public final native V get(String key) /*-{
		return this[key]
	}-*/;
}
