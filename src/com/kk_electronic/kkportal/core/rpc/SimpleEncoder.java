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
package com.kk_electronic.kkportal.core.rpc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayMixed;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.kk_electronic.kkportal.core.rpc.converters.ModuleInfoDTO;
import com.kk_electronic.kkportal.core.rpc.converters.ResponseDTO;
import com.kk_electronic.kkportal.core.rpc.converters.TabInfoDTO;
import com.kk_electronic.kkportal.core.services.ModuleService.ModuleInfo;
import com.kk_electronic.kkportal.core.services.ModuleService.TabInfo;
import com.kk_electronic.kkportal.core.util.JsonValueHelper;

public class SimpleEncoder implements FrameEncoder {
	static class JsonRpcRequest extends JavaScriptObject {
		protected JsonRpcRequest() {
		};

		public final native void setMethod(String method) /*-{
			this.method = method
		}-*/;

		public final native void setId(int id) /*-{
			this.id = id
		}-*/;

		public final native void setParams(JsArrayMixed params) /*-{
			this.params = params
		}-*/;
	}

	public static class JsonRpcError extends JavaScriptObject implements
			RpcError {
		protected JsonRpcError() {
		}

		public final native int getCode() /*-{
			return this.code
		}-*/;

		public final native String getMessage() /*-{
			return this.message
		}-*/;

		public final native Object getData() /*-{
			return this.data
		}-*/;
	}

	public String encode(List<Request> requests) {
		JsArray<JavaScriptObject> array = JsArray.createArray().cast();
		for (Request request : requests) {
			JsonRpcRequest o = JavaScriptObject.createObject().cast();
			o.setId(request.getId());
			o.setMethod(request.getFeatureName() + "." + request.getMethod());
			JsArrayMixed jsParams = JsonValueHelper.makeJSONArray(
					request.getParams()).isArray().getJavaScriptObject().cast();
			o.setParams(jsParams);
			array.push(o);
		}
		return new JSONArray(array).toString();
	}

	private static interface ObjectHelper {
		Object convert(JSONObject a);
	}

	public List<Response> decode(String data) {
		JSONValue parsed = JSONParser.parseLenient(data);
		return decodeResult(new Class<?>[] { List.class, Response.class },
				parsed);
	}

	@SuppressWarnings("unchecked")
	private static <T> List<T> convert(JSONArray a, ObjectHelper objectHelper) {
		List<Object> list = new ArrayList<Object>();
		for (int index = 0, length = a.size(); index < length; index++) {
			list.add(convert(a.get(index), objectHelper));
		}
		return (List<T>) list;
	}

	private static Object convert(JSONObject a, ObjectHelper objectHelper) {
		if (objectHelper != null)
			return objectHelper.convert(a);
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		for (String key : a.keySet()) {
			hashMap.put(key, convert(a.get(key), objectHelper));
		}
		return hashMap;
	}

	private static Object convert(JSONValue y, ObjectHelper objectHelper) {
		if (y.isArray() != null)
			return convert(y.isArray(), objectHelper);
		if (y.isObject() != null)
			return convert(y.isObject(), objectHelper);
		if (y.isBoolean() != null)
			return y.isBoolean().booleanValue();
		if (y.isString() != null)
			return y.isString().stringValue();
		if (y.isNumber() != null)
			return y.isNumber().doubleValue();
		if (y.isNull() != null)
			return null;
		throw new RuntimeException("Could not convert");
	}

	@Override
	public <T> T decodeResult(Class<?>[] resultSubTypes, Object result) {
		if (result instanceof JSONValue) {
			return decodeFromJson(Arrays.asList(resultSubTypes),
					(JSONValue) result);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	private <T> T decodeFromJson(List<Class<?>> resultSubTypes,
			JSONValue jsonvalue) {
		if (jsonvalue == null || jsonvalue.isNull() != null)
			return null;
		Class<?> target = resultSubTypes.get(0);
		if (target == List.class) {
			List<T> list = new ArrayList<T>();
			JSONArray ja = jsonvalue.isArray();
			for (int i = 0, l = ja.size(); i < l; i++) {
				list.add((T) decodeFromJson(resultSubTypes.subList(1,
						resultSubTypes.size()), ja.get(i)));
			}
			return (T) list;
		}
		if (target == Map.class) {
			if (resultSubTypes.get(1) == String.class) {
				Map<String, Object> map = new HashMap<String, Object>();
				JSONObject jo = jsonvalue.isObject();
				for (String key : jo.keySet()) {
					map.put(key, decodeFromJson(resultSubTypes.subList(2,
							resultSubTypes.size()), jo.get(key)));
				}
				return (T) map;
			}
		}
		if (target == Response.class) {
			JSONObject jo = jsonvalue.isObject();
			return (T) new ResponseDTO(jo);
		}
		if (target == String.class) {
			return (T) jsonvalue.isString().stringValue();
		}
		if (target == TabInfo.class) {
			return (T) new TabInfoDTO(jsonvalue.isObject());
		}
		if (target == ModuleInfo.class) {
			return (T) new ModuleInfoDTO(jsonvalue.isObject());
		}
		if (target == Object.class) {
			return (T) jsonvalue;
		}
		GWT.log("DECODING-Can't convert type " + target.getName());
		return null;
	}
}
