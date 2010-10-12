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

import com.google.gwt.user.client.rpc.IsSerializable;
import com.kk_electronic.kkportal.core.util.JsonValueHelper;

public final class Request implements IsSerializable {
	
	private final String featureName;
	private final String method;
	private Object[] params;
	private Integer id;

	public String getFeatureName() {
		return featureName;
	}

	public String getMethod() {
		return method;
	}

	public Object[] getParams() {
		return params;
	}

	public Integer getId() {
		return id;
	}

	public Request(
			String featureName, String method,
			Object... params) {
				this.featureName = featureName;
				this.method = method;
				this.setParams(params);
	}

	public String getSignature(){
		StringBuilder sb = new StringBuilder();
		sb.append(getId());
		sb.append(',');
		sb.append(getFeatureName());
		sb.append('.');
		sb.append(getMethod());
		sb.append(',');
		sb.append(JsonValueHelper.toCompactJson(getParams()));
		return sb.toString();
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setParams(Object[] params) {
		this.params = params;
	}
}
