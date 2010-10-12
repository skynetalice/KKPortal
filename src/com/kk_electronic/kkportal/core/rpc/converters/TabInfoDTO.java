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

import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.kk_electronic.kkportal.core.services.ModuleService.TabInfo;

public class TabInfoDTO implements TabInfo,JsonConvertable {

	private int id;
	private String name;

	public TabInfoDTO(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public TabInfoDTO(JSONObject object) {
		this(
			(int) object.get("id").isNumber().doubleValue(),
			object.get("name").isString().stringValue()
			);
	}

	public JSONObject toJsonObject(){
		JSONObject jo = new JSONObject();
		jo.put("id", new JSONNumber(id));
		jo.put("name", new JSONString(name));
		return jo;
	}
	
	@Override
	public int getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}

}
