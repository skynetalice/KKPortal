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

/**
 * This event is fired when the size of a content module changes
 * @author Jes Andersen
 */
public class ModuleResizeEvent extends GwtEvent<ModuleResizeHandler> {

  /**
   * Handler type.
   */
  private static Type<ModuleResizeHandler> TYPE;

  /**
   * Fires a open event on all registered handlers in the handler manager.If no
   * such handlers exist, this method will do nothing.
   * 
   * @param <T> the target type
   * @param source the source of the handlers
   * @param target the target
   */
  public static <T> void fire(HasModuleResizeHandlers source) {
    if (TYPE != null) {
      ModuleResizeEvent event = new ModuleResizeEvent();
      source.fireEvent(event);
    }
  }

  /**
   * Gets the type associated with this event.
   * 
   * @return returns the handler type
   */
  public static Type<ModuleResizeHandler> getType() {
    if (TYPE == null) {
      TYPE = new Type<ModuleResizeHandler>();
    }
    return TYPE;
  }

  protected ModuleResizeEvent() {
  }

  @SuppressWarnings("unchecked")
  @Override
  public final Type<ModuleResizeHandler> getAssociatedType() {
    return (Type) TYPE;
  }

  // Because of type erasure, our static type is
  // wild carded, yet the "real" type should use our I param.

  @Override
  protected void dispatch(ModuleResizeHandler handler) {
    handler.onModuleResize(this);
  }
}
