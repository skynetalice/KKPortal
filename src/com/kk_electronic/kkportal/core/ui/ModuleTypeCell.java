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
package com.kk_electronic.kkportal.core.ui;

import java.util.Arrays;

import com.google.gwt.cell.client.Cell;
import com.google.gwt.cell.client.CompositeCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.cell.client.HasCell;
import com.google.gwt.cell.client.TextCell;
import com.kk_electronic.kkportal.core.services.ModuleTypeInfo;

public class ModuleTypeCell extends CompositeCell<ModuleTypeInfo>{

	@SuppressWarnings("unchecked")
	private static HasCell<ModuleTypeInfo, ?> cells[] = new HasCell[]{
		new HasCell<ModuleTypeInfo, String>() {

			@Override
			public Cell<String> getCell() {
				return new TextCell();
			}

			@Override
			public FieldUpdater<ModuleTypeInfo, String> getFieldUpdater() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getValue(ModuleTypeInfo object) {
				return object.getTitle();
			}
		}
	}; 
	
	public ModuleTypeCell() {
		super(Arrays.asList(cells));
	}
}
