/*
 * Copyright 2010 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.gwt.sample.expenses.client.place;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.place.shared.PlaceChangeEvent;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.HasConstrainedValue;

/**
 * <p>
 * <span style="color:red">Experimental API: This class is still under rapid
 * development, and is very likely to be deleted. Use it at your own risk.
 * </span>
 * </p>
 * Drives a {@link ValueChangeHandler} populated with {@link ProxyListPlace}
 * instances, keeping it in sync with the {@link PlaceController}'s notion of
 * the current place, and firing place change events as selections are made.
 */
public class ProxyListPlacePicker implements ValueChangeHandler<ProxyListPlace>,
    PlaceChangeEvent.Handler {

  private HasConstrainedValue<ProxyListPlace> view;

  private final PlaceController placeController;
  private final ProxyPlaceToListPlace proxyPlaceToListPlace;

  public ProxyListPlacePicker(PlaceController placeController,
      ProxyPlaceToListPlace proxyPlaceToListPlace) {
    this.placeController = placeController;
    this.proxyPlaceToListPlace = proxyPlaceToListPlace;
  }

  public void onPlaceChange(PlaceChangeEvent event) {
    view.setValue(proxyPlaceToListPlace.proxyListPlaceFor(event.getNewPlace()),
        false);
  }

  public void onValueChange(ValueChangeEvent<ProxyListPlace> event) {
    placeController.goTo(event.getValue());
  }

  public HandlerRegistration register(EventBus eventBus,
      HasConstrainedValue<ProxyListPlace> view) {

    this.view = view;

    final HandlerRegistration placeRegistration = eventBus.addHandler(
        PlaceChangeEvent.TYPE, this);

    final HandlerRegistration viewRegistration = view.addValueChangeHandler(this);

    return new HandlerRegistration() {
      public void removeHandler() {
        placeRegistration.removeHandler();
        viewRegistration.removeHandler();
        ProxyListPlacePicker.this.view = null;
      }
    };
  }
}
