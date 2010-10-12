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

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.google.gwt.core.client.JavaScriptObject;

public class ListListAdaptor<E> implements List<List<E>>{

	private final JsList<JsList<E>> wrapped;

	public ListListAdaptor(JsList<JsList<E>> wrapped){
		this(wrapped,0);
	}
	
	public ListListAdaptor(JsList<JsList<E>> wrapped,int nestinglevel) {
		this.wrapped = wrapped;
	}
	
	@Override
	public boolean add(List<E> e) {
		return wrapped.add(convert(e));
	}

	@Override
	public void add(int index, List<E> element) {
		wrapped.add(index,convert(element));
	}

	@Override
	public boolean addAll(Collection<? extends List<E>> c) {
		if (c.size() == 0) return false;
		for(List<E> element:c){
			add(element);
		}
		return true;
	}

	@Override
	public boolean addAll(int index, Collection<? extends List<E>> c) {
		if (c.size() == 0) return false;
		for(List<E> element:c){
			add(index,element);
		}
		return true;
	}

	@Override
	public void clear() {
		wrapped.clear();
	}

	@Override
	public boolean contains(Object o) {
		return wrapped.contains(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return wrapped.containsAll(c);
	}

	@Override
	public List<E> get(int index) {
		return new ListAdaptor<E>(wrapped.get(index));
	}

	@Override
	public int indexOf(Object o) {
		return wrapped.indexOf(o);
	}

	@Override
	public boolean isEmpty() {
		return wrapped.isEmpty();
	}

	@Override
	public Iterator<List<E>> iterator() {
		return null;
	}

	@Override
	public int lastIndexOf(Object o) {
		return wrapped.lastIndexOf(o);
	}

	@Override
	public ListIterator<List<E>> listIterator() {
		return null;
	}

	@Override
	public ListIterator<List<E>> listIterator(int index) {
		return null;
	}

	@Override
	public boolean remove(Object o) {
		return wrapped.remove(o);
	}

	@Override
	public List<E> remove(int index) {
		return new ListAdaptor<E>(wrapped.remove(index));
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return wrapped.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return wrapped.retainAll(c);
	}

	@Override
	public List<E> set(int index, List<E> element) {
		return new ListAdaptor<E>(wrapped.set(index, convert(element)));
	}
	
	private JsList<E> convert(List<E> target){
		JsList<E> retval = JavaScriptObject.createArray().cast();
		for(E element: target){
			retval.add(element);
		}
		return retval;
	}

	@Override
	public int size() {
		return wrapped.size();
	}

	@Override
	public List<List<E>> subList(int fromIndex, int toIndex) {
		return new ListListAdaptor<E>(wrapped.subList(fromIndex, toIndex));
	}

	@Override
	public Object[] toArray() {
		return wrapped.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return wrapped.toArray(a);
	}

}
