package com.goldchain.www.domain;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ullink.slack.simpleslackapi.SlackChannel;
import com.ullink.slack.simpleslackapi.SlackSession;
import com.ullink.slack.simpleslackapi.impl.SlackSessionFactory;

@Service
public class SlackBaseService {
	
	/***
	 * test method
	 * @return
	 */
	public boolean helloWorldToSlackBot() {
		// BotのAPI Tokenを設定
		try {
			SlackSession session = SlackSessionFactory.createWebSocketSlackSession("xoxb-777951121232-796562998182-PjNtz31AX1YLKkGvp1c2wgMu");
			session.connect();

			SlackChannel channel = session.findChannelByName("rakuzaim");
			String message = "Hello World!";
			session.sendMessage(channel, message);

			session.disconnect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
}
