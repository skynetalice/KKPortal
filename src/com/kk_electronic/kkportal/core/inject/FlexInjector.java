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
package com.kk_electronic.kkportal.core.inject;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.kk_electronic.gwt.rebind.FlexInjectorGenerator;

/**
 * <p>
 * The flexinjector enables creation of classes using class litterals. All
 * dependencies of said class is created automatically as well.
 * </p>
 * <p>
 * Since this effectively disables some dead code elimination it is an
 * requirement that the class is marked with {@link ConstructFromLiteral}
 * </p>
 * @author Jes Andersen
 * @see FlexInjectorGenerator
 */
public interface FlexInjector {
	/**
	 * <p>Asynchronously return an instance of the requested type.</p>
	 * 
	 * <p> {@link AsyncCallback#onSuccess(Object)} is either called with an valid instance or {@link AsyncCallback#onFailure(Throwable)} is called is case the code could not be loaded</p>
	 * @param type requested class literal 
	 * @param callback return value callback
	 */
	public <T> void create(Class<? extends T> type, AsyncCallback<T> callback);
}
