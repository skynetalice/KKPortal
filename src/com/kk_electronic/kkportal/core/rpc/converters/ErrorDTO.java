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
import com.kk_electronic.kkportal.core.rpc.RpcError;

public class ErrorDTO implements RpcError {
	private String message;
	private Object data;
	private int code;

	
	public ErrorDTO(String message, Object data, int code) {
		this.message = message;
		this.data = data;
		this.code = code;
	}

	public ErrorDTO(JSONObject object){
		this(
			object.get("message").isString().stringValue(),
			object.containsKey("data")?object.get("data"):null,
			(int)object.get("code").isNumber().doubleValue()
		);
	}
	
	@Override
	public int getCode() {
		return this.code;
	}

	@Override
	public Object getData() {
		return this.data;
	}

	@Override
	public String getMessage() {
		return this.message;
	}

}