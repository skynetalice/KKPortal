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
package com.kk_electronic.kkportal.debug.modules;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Widget;

public class ScrollBar extends Widget {

	public ScrollBar() {
		
		setElement(Document.get().createDivElement());

		Element child = Document.get().createDivElement();
		child.setInnerHTML("&nbsp;");
		child.getStyle().setHeight(200, Unit.PCT);
		
		getElement().appendChild(child);
		getElement().getStyle().setPadding(0, Unit.PX);
		getElement().getStyle().setMargin(0, Unit.PX);
		getElement().getStyle().setHeight(100, Unit.PCT);
		getElement().getStyle().setOverflow(Overflow.AUTO);
	}
}
