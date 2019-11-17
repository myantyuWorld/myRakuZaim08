package com.goldchain.www.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.goldchain.www.bean.RakutenCategory;
import com.goldchain.www.bean.RakutenProperty;

@Service
public class RakutenService {

	private static final Logger logger = LoggerFactory.getLogger(RakutenService.class);

	@Autowired
	RakutenProperty rakutenProperty;
	
	private URL url = null;
	
	private HttpURLConnection urlConnection = null;
	private InputStream in = null;
	private BufferedReader reader = null;
	private RakutenCategory category = null;


	/***
	 * 初期設定
	 * 
	 * @param model
	 */
	public void init(Model model) {
		logger.info("call init()");
	}


	/***
	 * 楽天レシピカテゴリをDB登録する
	 * @return
	 * @throws IOException
	 */
	public int rakutenCategoryImport() throws IOException {
		RakutenCategory category = this.getCategories();
		
		return 0;
	}
	
	/***
	 * 楽天レシピカテゴリ一覧をJSON変換した結果で返す
	 * @return
	 * @throws IOException
	 */
	public RakutenCategory getCategories() throws IOException {
		String strUrlRakutenRecipeCategory = this.rakutenProperty.getRakutenApiCategoryUrl()
				+ this.rakutenProperty.getRakutenApplicationId();
		
		logger.info("call getCategories()");
		url = new URL(strUrlRakutenRecipeCategory);
		logger.info(strUrlRakutenRecipeCategory);
		urlConnection = (HttpURLConnection) url.openConnection();
		urlConnection.setRequestMethod("GET");
		urlConnection.connect();
		
		int status = urlConnection.getResponseCode();
		logger.info(String.valueOf(status));
		if (status == HttpURLConnection.HTTP_OK) {
			in = urlConnection.getInputStream();
			reader = new BufferedReader(new InputStreamReader(in, "utf-8"));
			StringBuilder output = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				output.append(line);
			}
			System.out.println(output.toString());
			logger.info(output.toString());
			
			ObjectMapper mapper = new ObjectMapper();
			// rakuten レシピAPIの処理結果を変換する
			category = mapper.readValue(output.toString(), RakutenCategory.class);
			if (category == null) {
				new IOException();
			}
		}
		return category;
	}
}
