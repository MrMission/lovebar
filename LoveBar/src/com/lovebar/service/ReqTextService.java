package com.lovebar.service;

public class ReqTextService {
	
	public static final int GET_URL_ID = 1;
	public static final int GET_PIC_TEXT_ID = 2;

	public static String getContentById(int id) {
		
		switch(id) {
		case GET_URL_ID:
			return "<a href=\"http://blog.csdn.net/lyq8479\">柳峰的博客</a> [开心] /难过 /::(";
		case GET_PIC_TEXT_ID:
			return "";
		}
		return "";
	}

}


