package com.credibanco.facturaelectronica.http;

import org.apache.camel.component.http.HttpClientConfigurer;
import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.params.HttpConnectionParams;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ApacheHttpClientConfigurer {
	
	@Bean(name = "httpConfigurer")
	public HttpClientConfigurer noRetryHttpConfigurer() {
	
		return new HttpClientConfigurer() {

			@Override
			public void configureHttpClient(HttpClient client) {
				client.getParams().setParameter("http.method.retry-handler", new DefaultHttpMethodRetryHandler(0, false));
				client.getParams().setParameter(HttpConnectionParams.CONNECTION_TIMEOUT, 20000);
			}
	  };
	
	}

}
