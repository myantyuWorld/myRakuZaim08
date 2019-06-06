package com.goldchain.www.domain;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Service;

import com.goldchain.www.api.APIResponseHandler;
import com.goldchain.www.bean.MoneyBean;
import com.goldchain.www.bean.ZaimBean;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

@Service
public class ZaimApiService extends ZaimBaseService {

	public MoneyBean getMoney(OAuthConsumer consumer) throws OAuthMessageSignerException,
			OAuthExpectationFailedException, OAuthCommunicationException, ClientProtocolException, IOException {
		// リクエストに署名する
		CloseableHttpClient httpclient = HttpClients.createDefault();
		ResponseHandler<String> responseHandler = new APIResponseHandler();
		
		HttpGet httpget = new HttpGet("https://api.zaim.net/v2/home/money");
		consumer.sign(httpget);
		// http request
		String responseBody = httpclient.execute(httpget, responseHandler);
		
		return this.jsonByZaimBean(responseBody);
	}
}
