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
package com.kk_electronic.kkportal.core.util;

import java.util.List;

import com.google.gwt.layout.client.Layout.AnimationCallback;
import com.google.gwt.layout.client.Layout.Layer;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.UIObject;

public class FadeIn implements AnimationCallback{

	private final List<? extends UIObject> uiObjects;

	public FadeIn(List<? extends UIObject> uiObjects) {
		this.uiObjects = uiObjects;
	}
	
	@Override
	public void onAnimationComplete() {
		for(UIObject uiObject: uiObjects){
			DOM.setStyleAttribute(uiObject.getElement(), "opacity", "1.0");
		}
	}

	@Override
	public void onLayout(Layer layer, double progress) {
		for(UIObject uiObject: uiObjects){
			DOM.setStyleAttribute(uiObject.getElement(), "opacity", String.valueOf(progress));
		}
	}
}
