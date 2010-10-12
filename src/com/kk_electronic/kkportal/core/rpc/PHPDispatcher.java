package com.kk_electronic.kkportal.core.rpc;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.kk_electronic.kkportal.core.util.JsonValueHelper;


public class PHPDispatcher implements Dispatcher {

	private final SimpleEncoder encoder;

	@Inject
	public PHPDispatcher(SimpleEncoder encoder) {
		this.encoder = encoder;
	}
	
	@Override
	public <T> void execute(final AsyncCallback<T> callback,
			final Class<?>[] returnValueType,
			Class<? extends RemoteService> serverinterface, String method,
			Object... params) {
		String url = "http://1.2.3.4/php" + serverinterface.getName() + "/" + method + ".php";
		RequestBuilder builder = new RequestBuilder(RequestBuilder.POST,url);
		String data = JsonValueHelper.makeJSONValue(params).toString();
		try {
			builder.sendRequest(data,new RequestCallback() {
				
				@Override
				public void onResponseReceived(com.google.gwt.http.client.Request request,
						Response response) {
					T result = encoder.decodeResult(returnValueType, response.getText());
					callback.onSuccess(result);
				}
				
				@Override
				public void onError(com.google.gwt.http.client.Request request,
						Throwable exception) {
					callback.onFailure(exception);
				}
			});
		} catch (RequestException e) {
			callback.onFailure(e);
		}
	}
}
