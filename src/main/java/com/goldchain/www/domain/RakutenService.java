package com.goldchain.www.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.goldchain.www.bean.RakutenCategory;
import com.goldchain.www.bean.RakutenProperty;
import com.goldchain.www.bean.RecipeCategory;
import com.goldchain.www.mapper.RakutenCategoryMapper;

@Service
public class RakutenService {

	private static final Logger logger = LoggerFactory.getLogger(RakutenService.class);

	@Autowired
	RakutenProperty rakutenProperty;
	@Autowired
	RakutenCategoryMapper rakutenCategoryMapper;

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
	 * 
	 * @return
	 * @throws IOException
	 */
	public int rakutenCategoryImport() throws IOException {
		RakutenCategory category = this.getCategories();
		int orgRecipeCount = 0;
		int tmpRecipeCount = 0;

		orgRecipeCount = category.getResult().getSmall().size();
		// cateoryの大・中・小をINSERTする
		tmpRecipeCount += insertRecipeCategory(category.getResult().getLarge(), 1);
		tmpRecipeCount += insertRecipeCategory(category.getResult().getMedium(), 2);
		tmpRecipeCount += insertRecipeCategory(category.getResult().getSmall(), 3);

		logger.info("INSERT COUNT -- " + String.valueOf(tmpRecipeCount));
		if (orgRecipeCount == tmpRecipeCount) {
			logger.info("楽天レシピカテゴリAPI結果とINSERT結果の総数が異なります");
		}
		return tmpRecipeCount;
	}

	private int insertRecipeCategory(List<RecipeCategory> list, int categoryShubetsu) {
		int tmpRecipeCount = 0;
		for (RecipeCategory category : list) {
			switch (categoryShubetsu) {
			case 1:
				if (this.rakutenCategoryMapper.insertRakutenCategoryLarge(category) > 0) {
					tmpRecipeCount++;
				}
				break;
			case 2:
				if (this.rakutenCategoryMapper.insertRakutenCategoryMedium(category) > 0) {
					tmpRecipeCount++;
				}
				break;
			case 3:
				if (this.rakutenCategoryMapper.insertRakutenCategorySmall(category) > 0) {
					tmpRecipeCount++;
				}
				break;
			default:
				break;
			}
		}
		return tmpRecipeCount;
	}

	/***
	 * 楽天レシピカテゴリ一覧をJSON変換した結果で返す
	 * 
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
