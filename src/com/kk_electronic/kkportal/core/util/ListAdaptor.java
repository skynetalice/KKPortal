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
/**
 * This class is a workaround for the limitation that a JavaScriptObject cannot implement
 * the List<E> interface. 
 * @author Jes Andersen
 *
 * @param <E>
 */
public class ListAdaptor<E> implements List<E>{

	private final JsList<E> wrapped;

	public ListAdaptor(JsList<E> wrapped){
		this.wrapped = wrapped;
	}
	
	@Override
	public boolean add(E e) {
		return wrapped.add(e);
	}

	@Override
	public void add(int index, E element) {
		wrapped.add(index,element);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		return wrapped.addAll(c);
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		return wrapped.addAll(index, c);
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
	public E get(int index) {
		return wrapped.get(index);
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
	public Iterator<E> iterator() {
		return wrapped.iterator();
	}

	@Override
	public int lastIndexOf(Object o) {
		return wrapped.lastIndexOf(o);
	}

	@Override
	public ListIterator<E> listIterator() {
		return wrapped.listIterator();
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		return wrapped.listIterator(index);
	}

	@Override
	public boolean remove(Object o) {
		return wrapped.remove(o);
	}

	@Override
	public E remove(int index) {
		return wrapped.remove(index);
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
	public E set(int index, E element) {
		return wrapped.set(index, element);
	}

	@Override
	public int size() {
		return wrapped.size();
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		return new ListAdaptor<E>(wrapped.subList(fromIndex, toIndex));
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
