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
package com.kk_electronic.kkportal.core.rpc.converters;

import com.google.gwt.json.client.JSONObject;
import com.kk_electronic.kkportal.core.rpc.Response;
import com.kk_electronic.kkportal.core.rpc.RpcError;

public class ResponseDTO implements Response {

	private final Integer id;
	private final Object result;
	private final String method;
	private final Object params;
	public String getMethod() {
		return method;
	}

	public Object getParams() {
		return params;
	}

	private final RpcError error;

	public ResponseDTO(Integer id, Object result, RpcError error,String Method,Object Params) {
		this.id = id;
		this.result = result;
		this.error = error;
		method = Method;
		params = Params;
	}

	public ResponseDTO(JSONObject object) {
		this(object.containsKey("id") ? (int) object.get("id").isNumber()
				.doubleValue() : null, object.containsKey("result") ? object
				.get("result") : null,
				object.containsKey("error") ? new ErrorDTO(object.get("error")
						.isObject()) : null,
				object.containsKey("method") ? object.get("method").isString().stringValue() : null,
				object.containsKey("params") ? object.get("params") : null
		);
	}

	@Override
	public RpcError getError() {
		return error;
	}

	@Override
	public int getId() {
		return id;
	}
	
	public boolean isNotification(){
		return method != null;
	}

	public boolean isResponse(){
		return id != null;
	}

	@Override
	public Object getResult() {
		return result;
	}

	@Override
	public boolean hasError() {
		return error != null;
	}

}