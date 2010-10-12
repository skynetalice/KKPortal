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
package com.kk_electronic.kkportal.core.event;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;

public class INotificationEvent extends GwtEvent<INotificationHandler> {

	/**
	 * Handler type.
	 */
	private static Type<INotificationHandler> TYPE;
	private final String filename;
	private final String inotiytype;

	/**
	 * Fires a open event on all registered handlers in the handler manager.If
	 * no such handlers exist, this method will do nothing.
	 * 
	 * @param <T>
	 *            the target type
	 * @param source
	 *            the source of the handlers
	 * @param target
	 *            the target
	 */
	public static <T> void fire(HasHandlers source,String filename,String type) {
		if (TYPE != null) {
			INotificationEvent event = new INotificationEvent(filename,type);
			source.fireEvent(event);
		}
	}

	public String getFilename() {
		return filename;
	}

	public String getInotiytype() {
		return inotiytype;
	}

	/**
	 * Gets the type associated with this event.
	 * 
	 * @return returns the handler type
	 */
	public static Type<INotificationHandler> getType() {
		if (TYPE == null) {
			TYPE = new Type<INotificationHandler>();
		}
		return TYPE;
	}

	protected INotificationEvent(String filename, String type) {
		this.filename = filename;
		inotiytype = type;
	}

	@SuppressWarnings("unchecked")
	@Override
	public final Type<INotificationHandler> getAssociatedType() {
		return (Type) TYPE;
	}

	// Because of type erasure, our static type is
	// wild carded, yet the "real" type should use our I param.

	@Override
	protected void dispatch(INotificationHandler handler) {
		handler.onINotification(this);
	}
}
