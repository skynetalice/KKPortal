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

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONNull;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;
import com.kk_electronic.kkportal.core.rpc.converters.JsonConvertable;

/**
 * Static helper class to help the creation of json values from arbitrary java objects
 * 
 * it converts Map and Arrays to the appropriate json Object and Arrays
 * 
 * @author Jes Andersen
 */
public class JsonValueHelper {
	
	public static JSONValue makeJSONValue(Object o) {
		if (o instanceof JavaScriptObject) {
			return new JSONObject((JavaScriptObject) o);
		} else if (o instanceof JsonConvertable) {
			return ((JsonConvertable)o).toJsonObject();
		} else if (o instanceof String) {
			return new JSONString((String) o);
		} else if (o instanceof Double) {
			return new JSONNumber((Double) o);
		} else if (o instanceof Integer) {
			return new JSONNumber(Double.valueOf((Integer) o));
		} else if (o == null) {
			return JSONNull.getInstance();
		} else if (o instanceof Collection<?>) {
			return makeJSONArray(((Collection<?>) o).toArray());
		} else if (o instanceof Map<?, ?>) {
			return makeJSONObject((Map<?, ?>) o);
		} else if (o instanceof Object[]) {
			return makeJSONArray((Object[]) o);
		} else {
			GWT.log("Unable to serialize Request", new Exception());
			return null;
		}
	}

	public static JSONObject makeJSONObject(Map<?, ?> map) {
		JSONObject jo = new JSONObject();
		for (Entry<?, ?> entry : map.entrySet()) {
			Object key = entry.getKey();
			assert (key instanceof String);
			jo.put((String) key, makeJSONValue(entry.getValue()));
		}
		return jo;
	}

	public static JSONArray makeJSONArray(Object[] params) {
		JSONArray ja = new JSONArray();
		for (int i = 0; i < params.length; i++) {
			ja.set(i, makeJSONValue(params[i]));
		}
		return ja;
	}
	
	public static String toCompactJson(Object o){
		StringBuilder sb = new StringBuilder();
		try {
			toJson(o, sb, ",", ":");
		} catch (Exception e) {
			GWT.log("JSONVALUEHELPER-Exception during construction of compact json",e);
			return "";
		}
		return sb.toString();
	}
	
	public static native Object test() /*-{
		return [];
	}-*/;
	
	private static native JavaScriptObject initTypeMap() /*-{
		return {
			"boolean": @com.kk_electronic.kkportal.core.util.JsonValueHelper::toJson(ZLjava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;),
			"number": @com.kk_electronic.kkportal.core.util.JsonValueHelper::toJson(DLjava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;),
			"string": @com.kk_electronic.kkportal.core.util.JsonValueHelper::toJson(Ljava/lang/String;Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;),
			"object": @com.kk_electronic.kkportal.core.util.JsonValueHelper::toJson(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;),
		}
	}-*/;
	
	@SuppressWarnings("unused")
	private static JavaScriptObject typemap = initTypeMap(); 

	private static native void toJson(JavaScriptObject o,StringBuilder sb,String arraysep,String kvsep) /*-{
		if (o instanceof Array || o instanceof $wnd.Array ){
			sb.@java.lang.StringBuilder::append(Ljava/lang/String;)("[");
			for (var i=0;i<o.length;i++) {
				if(i != 0) sb.@java.lang.StringBuilder::append(Ljava/lang/String;)(arraysep);
				var f = @com.kk_electronic.kkportal.core.util.JsonValueHelper::typemap[typeof o[i]];
				f(o[i],sb,arraysep,kvsep);	
			}
			sb.@java.lang.StringBuilder::append(Ljava/lang/String;)("]");
		} else {
			sb.@java.lang.StringBuilder::append(Ljava/lang/String;)("{");
			var sep = "";
			var keys = [];
			var i = 0;
			for (key in o) {
				if (o.hasOwnProperty(key)) {
					keys[i++] = key;
				}
			}
			keys.sort();
			for(var j=0;j<keys.length;j++){
				if(j != 0) sb.@java.lang.StringBuilder::append(Ljava/lang/String;)(arraysep);
				sb.@java.lang.StringBuilder::append(Ljava/lang/String;)(@com.google.gwt.core.client.JsonUtils::escapeValue(Ljava/lang/String;)(keys[j]));
				sb.@java.lang.StringBuilder::append(Ljava/lang/String;)(kvsep);
				var f = @com.kk_electronic.kkportal.core.util.JsonValueHelper::typemap[typeof o[keys[j]]];
				f(o[keys[j]],sb,arraysep,kvsep);
			}
			sb.@java.lang.StringBuilder::append(Ljava/lang/String;)("}");
		}
	}-*/;
	
	public static void toJson(String s,StringBuilder sb,String arraysep,String kvsep) {
		sb.append(JsonUtils.escapeValue(s));
	}

	public native static void toJson(double d,StringBuilder sb,String arraysep,String kvsep) /*-{
		sb.@java.lang.StringBuilder::append(Ljava/lang/String;)(d + "");
	}-*/;
	
	public static void toJson(Collection<?> c,StringBuilder sb,String arraysep,String kvsep) {
		sb.append('[');
		for (Iterator<?> iterator = c.iterator(); iterator.hasNext();) {
			toJson(iterator.next(),sb,arraysep,kvsep);
			if(iterator.hasNext()) sb.append(arraysep);
		}
		sb.append(']');
	}

	public static void toJson(Map<?,?> m,StringBuilder sb,String arraysep,String kvsep) {
		Set<?> k = m.keySet();
		for (Iterator<?> iterator = k.iterator(); iterator.hasNext();) {
			Object e = iterator.next();
			sb.append(JsonUtils.escapeValue((String) e));
			sb.append(kvsep);
			toJson(m.get(e),sb,arraysep,kvsep);
		}
	}

	public static void toJson(Object[] c,StringBuilder sb,String arraysep,String kvsep) {
		sb.append('[');
		for (int i=0,l=c.length;i<l;i++) {
			if(i != 0){
				sb.append(arraysep);
			}
			toJson(c[i],sb,arraysep,kvsep);
			
		}
		sb.append(']');
	}
	
	public static void toJson(boolean b,StringBuilder sb,String arraysep,String kvsep) {
		if(b){
			sb.append("true");
		} else {
			sb.append("false");
		}
	}

	public static void toJson(Object o,StringBuilder sb,String arraysep,String kvsep) {
		if (o instanceof JavaScriptObject) {
			toJson((JavaScriptObject)o, sb, arraysep, kvsep);
		} else if (o instanceof String) {
			toJson((String)o,sb,arraysep,kvsep);
		} else if (o instanceof JsonConvertable) {
			toJson(((JsonConvertable)o).toJsonObject().getJavaScriptObject(),sb,arraysep,kvsep);
		} else if (o instanceof Boolean) {
			toJson((Boolean)o,sb,arraysep,kvsep);
		} else if (o instanceof Double) {
			toJson((Double)o,sb,arraysep,kvsep);
		} else if (o instanceof Integer) {
			toJson(((Integer)o).doubleValue(),sb,arraysep,kvsep);
		} else if (o == null) {
			sb.append("null");
		} else if (o instanceof Collection<?>) {
			toJson((Collection<?>) o, sb, arraysep, kvsep);
		} else if (o instanceof Map<?, ?>) {
			toJson((Map<?,?>) o, sb, arraysep, kvsep);
		} else if (o instanceof Object[]) {
			toJson((Object[])o, sb, arraysep, kvsep);
		} else {
			GWT.log("Unable to serialize Request", new Exception());
		}
	}
}