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
package com.kk_electronic.kkportal.debug;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.kk_electronic.kkportal.core.services.JsTable;
import com.kk_electronic.kkportal.core.util.JsList;


public class DynaTable extends Composite{
	CellTable<JsList<String>> c = new CellTable<JsList<String>>();
	
	public DynaTable(JsTable table) {
		initWidget(c);
		addColumns(table.getHeaders());
		c.setRowData(0, table.getData().toList());
	}
	
	public static class IndexedTextColumn extends TextColumn<JsList<String>>{

		private final int index;

		public IndexedTextColumn(int index) {
			this.index = index;
		}
		
		@Override
		public String getValue(JsList<String> object) {
			return object.get(index);
		}
		
	}
	
	public void addColumns(JsList<String> headernames){
		for(int i=0,l=headernames.size();i<l;i++){
			c.addColumn(new IndexedTextColumn(i), headernames.get(i));
		}
	}
}
