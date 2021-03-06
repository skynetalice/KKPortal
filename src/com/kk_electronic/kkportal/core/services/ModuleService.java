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
package com.kk_electronic.kkportal.core.services;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.kk_electronic.kkportal.core.rpc.RemoteService;
import com.kk_electronic.kkportal.core.security.User;

public interface ModuleService extends RemoteService {
	public interface ModuleInfo  {
		public int getId();
		public int getHeight();
		public void setHeight(int height);
		public int getType();
		public void setType(int code);
	}

	public interface TabInfo {
		public int getId();
		public String getName();
	}
	
	void getTabs(User user,AsyncCallback<List<TabInfo>> asyncCallback);
	
	void getModuleTypeInfo(List<Integer> ids,AsyncCallback<List<ModuleTypeInfo>> callback);
	
	void getModule(int moduleID,AsyncCallback<ModuleInfo> callback);
	
	void getModules(Integer tabid,AsyncCallback<List<List<ModuleInfo>>> callback);
	void setModules(int tabid,List<List<ModuleInfo>> modules,AsyncCallback<?> callback);

	void getTabInfos(User user, AsyncCallback<List<TabInfo>> tabscallback);

	void addModule(int tabid, int typeId,AsyncCallback<?> callback);
}
