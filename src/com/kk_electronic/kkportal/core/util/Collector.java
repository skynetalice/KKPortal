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

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * This class is work in progress. Do not use for now
 * @author Jes Andersen
 */

@Deprecated
public class Collector{
	ArrayList<?> list = new ArrayList<Object>();
	
	AsyncCallback<?> getNext(){
		return null;
	}
	
	void runWhenDone(AsyncCallback<?> callback){
		
	}
	
	void runWhenDone(Command onSucess,Command onError){
		
	}
	
	void runWhenDone(Command onSucess){
		
	}
}
