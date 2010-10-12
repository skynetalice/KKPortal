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
package com.kk_electronic.kkportal.core.security;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.kk_electronic.kkportal.core.rpc.Request;

/**
 * 
 * @author Jes Andersen
 */
public class Digest implements SecurityMethod {

	private final Hasher hasher;
	private final String username;
	private final String secret;

	@Inject
	public Digest(Hasher hasher) {
		this.hasher = hasher;
		this.username = "jes";
		this.secret = hasher.hash(username + ':' + "1234");
	}
	
	@Override
	public void sign(Request request, AsyncCallback<Request> asyncCallback) {
		String requestSignature = request.getSignature();
		GWT.log("DIGEST-Signing: " + requestSignature);
		String digestinput = secret+':'+requestSignature;
		request.setParams(new Object[]{
				hasher.hash(digestinput),
				username,
				request.getParams()
		});
		asyncCallback.onSuccess(request);
	}
}
