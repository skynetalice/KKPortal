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
import java.util.ListIterator;

import com.google.gwt.core.client.JavaScriptObject;

public class JsListListInterator<E> implements ListIterator<List<E>> {

	int index;
	JsList<JsList<E>> list;
	
	public JsListListInterator(JsList<JsList<E>> list,int index) {
		this.list = list;
		this.index = index - 1;
	}
	
	public JsListListInterator(JsList<JsList<E>> jsList){
		this(jsList, 0);
	}
	
	@Override
	public void add(List<E> e) {
		list.add(index, convert(e));
	}

	@Override
	public boolean hasNext() {
		return index < list.size();
	}

	@Override
	public boolean hasPrevious() {
		return index >= 0;
	}

	@Override
	public List<E> next() {
		index++;
		return new ListAdaptor<E>(list.get(index));
	}

	@Override
	public int nextIndex() {
		return index + 1;
	}

	@Override
	public List<E> previous() {
		List<E> e = new ListAdaptor<E>(list.get(index));
		index--;
		return e;
	}

	@Override
	public int previousIndex() {
		return index - 1;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void set(List<E> e) {
		list.set(index, convert(e));
	}
	
	private JsList<E> convert(List<E> target){
		JsList<E> retval = JavaScriptObject.createArray().cast();
		for(E element: target){
			retval.add(element);
		}
		return retval;
	}
}
