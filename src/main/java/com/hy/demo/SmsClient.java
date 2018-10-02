package com.hy.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SmsClient {
	@Autowired
	private JmsMessagingTemplate jmsMessagiingTemplage;
	@RequestMapping("/sendMap")
	@ResponseBody
	public String sendMap(String mobile,String name){
		Map map = new HashMap();
		map.put("mobile", mobile);
		map.put("name", name);
		jmsMessagiingTemplage.convertAndSend("hy_map",map);
		return "success";
	}
}
