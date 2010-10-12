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
package com.kk_electronic.kkportal.core.model;

import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.ListDataProvider;
import com.kk_electronic.kkportal.core.services.ModuleService.TabInfo;

public class Tab extends ListDataProvider<Column> {

	public Tab(TabInfo tabInfo) {

	}

	@Override
	public void addDataDisplay(HasData<Column> display) {
		super.addDataDisplay(display);
	}
}
