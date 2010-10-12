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
import com.kk_electronic.kkportal.core.services.ModuleService.ModuleInfo;

public class ModuleInfoDTO implements ModuleInfo, JsonConvertable {

	private int height;
	private int type;
	private int id;

	public ModuleInfoDTO(int height, int type, int id) {
		this.height = height;
		this.type = type;
		this.id = id;
	}
	
	public ModuleInfoDTO(JSONObject object){
		this(
				(int) object.get("height").isNumber().doubleValue(),
				(int) object.get("type").isNumber().doubleValue(),
				(int) object.get("id").isNumber().doubleValue()
				);
	}
	
	public JSONObject toJsonObject(){
		JSONObject jo = new JSONObject();
		jo.put("height", new JSONNumber(height));
		jo.put("type", new JSONNumber(type));
		jo.put("id", new JSONNumber(id));
		return jo;
	}

	@Override
	public int getType() {
		return this.type;
	}

	@Override
	public int getHeight() {
		return this.height;
	}

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public void setType(int type) {
		this.type = type;
	}

	@Override
	public void setHeight(int height) {
		this.height = height;
	}

}
