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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

/**
 * This is an addition to the JsArray classes providede by GWT.
 * 
 * using object and the javascript in operator we can make a
 * lightweight map from strings to JavaScript objects
 * 
 * TODO: still need some optimisation.
 *  
 * @author Jes Andersen
 *
 * @param <V>
 * @deprecated see {@link MiniMap} instead
 */

@Deprecated
public class JsMap<V> extends JavaScriptObject {
	protected JsMap() {
	}

	public final void clear() {
		for(String key:keySet()){
			remove(key);
		}
	}

	public final native boolean containsKey(Object key) /*-{ return this[key] != undefined }-*/;

	public final boolean containsValue(Object value) {
		for(String key:keySet()){
			V ivalue = get(key);
			if(ivalue != null && ivalue.equals(value)){
				return true;
			}
		}
		return false;
	}

	private final class JsMapEntry implements Entry<String, V>{
		
		private final String key;

		public JsMapEntry(String key) {
			this.key = key;
		}
		
		@Override
		public String getKey() {
			return key;
		}

		@Override
		public V getValue() {
			return get(key);
		}

		@Override
		public V setValue(V value) {
			return put(key, value);
		}
		
	}
	
	public final Set<java.util.Map.Entry<String, V>> entrySet() {
		Set<Entry<String, V>> retval = new HashSet<Entry<String,V>>();
		for(String key:keySet()){
			Entry<String, V> e = new JsMapEntry(key);
			retval.add(e );
		}
		return retval ;
	}

	public final native V get(Object key) /*-{ return this[key]}-*/;

	public final boolean isEmpty() {
		return size() == 0;
	}

	private final native JsArrayString getKeys() /*-{
		var a = [];
		for (var k in this){
			a.push(k);
		}
		return a;
	}-*/;

	public final Set<String> keySet() {
		JsArrayString jsKeys = getKeys();
		HashSet<String> javaKeys = new HashSet<String>();
		for(int i=0;i<jsKeys.length();i++){
			javaKeys.add(jsKeys.get(i));
		}
		return javaKeys;
	}

	public final native V put(String key, V value) /*-{
		var a = this[key];
		this[key] = value;
		return a;
	}-*/;

	public final void putAll(Map<? extends String, ? extends V> m) {
		for (Entry<? extends String, ? extends V> entry : m.entrySet()) {
			put(entry.getKey(), entry.getValue());
		}
	}

	public final native V remove(Object key) /*-{
		delete this[key]
	}-*/;

	public final int size() {
		return keySet().size();
	}

	public final Collection<V> values() {
		Collection<V> collection = new ArrayList<V>();
		for(String key:keySet()){
			collection.add(get(key));
		}
		return collection;
	}
}
