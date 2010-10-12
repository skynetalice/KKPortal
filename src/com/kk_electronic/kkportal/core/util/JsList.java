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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.google.gwt.core.client.JavaScriptObject;


public class JsList<E> extends JavaScriptObject /* implements List<E> */{

	protected JsList() {}
		
//	@Override
	public final native boolean add(E element) /*-{
		this.push(element);
		return true;
	}-*/;
	
//	@Override
	public final native void add(int index, E element) /*-{
		this.splice(index,0,element);
	}-*/;

//	@Override
	public final boolean addAll(Collection<? extends E> collection) {
		if(collection.size() == 0) return false;
		for(E element:collection){
			add(element);
		}
		return true;
	}

//	@Override
	public final boolean addAll(int index, Collection<? extends E> collection) {
		if (collection.isEmpty()) return false;
		for(E element:collection){
			add(index, element);
			index++;
		}
		return true;
	}

//	@Override
	public final native void clear() /*-{
		this.length = 0;
	}-*/;

//	@Override
	public final boolean contains(Object o) {
		return indexOf(o) != -1;
	}

//	@Override
	public final boolean containsAll(Collection<?> c) {
		for(Object e:c){
			if(contains(e) == false){
				return false;
			}
		}
		return true;
	}

//	@Override
	public final native E get(int index) /*-{
		return this[index];
	}-*/;
	
//	@Override
	public final int indexOf(Object o) {
		for(int i=0,c=size();i<c;i++){
			if(get(i) == o){
				return i;
			}
		}
		return -1;
	}

//	@Override
	public final boolean isEmpty() {
		return size() == 0;
	}

//	@Override
	public final Iterator<E> iterator() {
		return listIterator();
	}

//	@Override
	public final int lastIndexOf(Object o) {
		for(int i=size();i>=0;i--){
			if(get(i) == o){
				return i;
			}
		}
		return -1;
	}
	
//	@Override
	public final ListIterator<E> listIterator() {
		return new JsListInterator<E>(this);
	}

//	@Override
	public final ListIterator<E> listIterator(int index) {
		return new JsListInterator<E>(this, index);
	}

//	@Override
	public final boolean remove(Object o) {
		int i = indexOf(o);
		if(i == -1)	return false;
		removeByIndex(i);
		return true;
	}
	
	private final native void removeByIndex(int i) /*-{
		this.splice(i,1);
	}-*/;

//	@Override
	public final E remove(int index) {
		E e = get(index);
		removeByIndex(index);
		return e;
	}

//	@Override
	public final boolean removeAll(Collection<?> c) {
		boolean retval = false;
		for(Object e:c){
			if(remove(e)) retval = true;
		}
		return retval;
	}

//	@Override
	public final boolean retainAll(Collection<?> c) {
		boolean retval = false;
		ListIterator<E> iterator = listIterator();
		for(E e=iterator.next();iterator.hasNext();e=iterator.next()){
			if(! c.contains(e)){
				iterator.remove();
				retval = true;
			}
		}
		return retval;
	}

//	@Override
	public final native E set(int index, E element) /*-{
		var retval = this[index];
		this[index] = element;
		return retval;
	}-*/;

//	@Override
	public final native int size() /*-{
		return this.length;
	}-*/;
	
//	@Override
	public final native JsList<E> subList(int fromIndex, int toIndex) /*-{
		return this.slice(fromIndex,toIndex);
	}-*/;

//	@Override
	public final Object[] toArray() {
		Object[] objects = new Object[size()];
		for(int i=0,c=size();i<c;i++){
			objects[i] = get(i);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
//	@Override
	public final <T> T[] toArray(T[] a) {
		return (T[]) toArray();
	}
	
	public final List<E> toList(){
		List<E> retval = new ArrayList<E>();
		for(int i=0,l=size();i<l;i++){
			retval.add(get(i));
		}
		return retval;
	}
	
	@SuppressWarnings("unused")
	private final static Integer convert(int i){
		return i;
	}
}
