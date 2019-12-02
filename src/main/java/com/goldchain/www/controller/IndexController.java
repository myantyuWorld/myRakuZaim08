package com.goldchain.www.controller;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.ibatis.io.ResolverUtil.IsA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.goldchain.www.api.APIResponseHandler;
import com.goldchain.www.bean.MoneyBean;
import com.goldchain.www.domain.ZaimApiService;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.OAuthProvider;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import oauth.signpost.exception.OAuthNotAuthorizedException;

@Controller
@RequestMapping("rakuzaim08")
public class IndexController {
	
	@RequestMapping("/pages/index")
	public String index() {
		return "rakuzaim08/pages/index/index";
	}
//	@Autowired
//	ZaimInfo zaiminfo;
	
//	@Autowired
//    OAuthConsumer consumer;
//
//    @Autowired
//    OAuthProvider provider;
//    
//    @Autowired
//    ZaimApiService zaimApiService;
//    
//    /***
//     * トップ画面
//     * @return
//     * @throws OAuthCommunicationException 
//     * @throws OAuthExpectationFailedException 
//     * @throws OAuthNotAuthorizedException 
//     * @throws OAuthMessageSignerException 
//     */
//	@RequestMapping("/index")
//	private String index() throws OAuthMessageSignerException, OAuthNotAuthorizedException, OAuthExpectationFailedException, OAuthCommunicationException {
//		 // 認証用URL生成
//        String URL = provider.retrieveRequestToken(consumer, "http://localhost:18083/pages/index/authenticated");
//        return "redirect:" + URL;
//	}
//	
//	/***
//	 * ZaimOAuth認証を行うようのリクエストマッピング
//	 * @return
//	 * @throws Exception
//	 */
//	@RequestMapping("/oauth")
//	private String oauth() throws Exception	{
//		 // 認証用URL生成
//        String URL = provider.retrieveRequestToken(consumer, "http://localhost:18083/pages/index/authenticated");
//        return "redirect:" + URL;
//	}
//	
//	/**
//     * zaimで認証後のコールバックでのアクセス
//     * @param oauthToken zaimより返却
//     * @param oauthVerifier zaimより返却
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping("/authenticated")
//    public String authenticated(@RequestParam(value = "oauth_token") String oauthToken,
//            @RequestParam(value = "oauth_verifier") String oauthVerifier, Model model)
//            throws Exception {
//
//        // accessTokenとaccessTokenSecretを生成する
//        provider.retrieveAccessToken(consumer, oauthVerifier);
//
//        // トークンを取得（これを保存しておくと再認証しなくていい
//        Map<String, String> tokenDictionary  = setZaimAccessToken(consumer);
//        
//        // 保存していたトークンをセット
//        if (tokenDictionary != null) {
//        	consumer.setTokenWithSecret(tokenDictionary.get("token"), tokenDictionary.get("tokenSecret"));
//        }
//     
//        // HttpClient準備
//        CloseableHttpClient httpclient = HttpClients.createDefault();
//        ResponseHandler<String> responseHandler = new APIResponseHandler();
//
//        // リクエストに署名する
//        HttpGet httpget = new HttpGet("https://api.zaim.net/v2/home/user/verify");
//        consumer.sign(httpget);
//
//        // 取得
//        String responseBody = httpclient.execute(httpget, responseHandler);
//        model.addAttribute("zaimUserVerify", responseBody);
//
////        // リクエストに署名する
////        httpget = new HttpGet("https://api.zaim.net/v2/home/money");
////        consumer.sign(httpget);
////
////        // 取得
////        responseBody = httpclient.execute(httpget, responseHandler);
//        MoneyBean bean = zaimApiService.getMoney(consumer);
//        
//        
//        httpget = new HttpGet("https://api.zaim.net/v2/home/money?start_date=2019-05-25");
//        consumer.sign(httpget);
//
//        // 取得
//        responseBody = httpclient.execute(httpget, responseHandler);
//        
//        httpget = new HttpGet("https://api.zaim.net/v2/home/category");
//        consumer.sign(httpget);
//
//        // 取得
//        responseBody = httpclient.execute(httpget, responseHandler);
//        return "pages/index/index";
//    }
//
//    /***
//     * 
//     * @param consumer
//     * 		consumer
//     */
//	private Map<String, String> setZaimAccessToken(OAuthConsumer consumer) {
//		Map<String, String> tokenDictionary = new HashMap<>();
//		tokenDictionary.put("token", consumer.getToken());
//		tokenDictionary.put("tokenSecret", consumer.getTokenSecret());
//		
//		return tokenDictionary;
//	}
	
}
