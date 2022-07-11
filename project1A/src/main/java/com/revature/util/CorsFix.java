package com.revature.util;

import javax.servlet.http.HttpServletResponse;

public class CorsFix {
	public static void addCorsHeader(String requestURI, HttpServletResponse resp) {
		resp.addHeader("Access-Control-Allow-Origin", "http://127.0.0.1:5500");
		resp.addHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE");
		resp.addHeader("Access-Control-Allow-Credentials", "true");
		resp.addHeader("Access-Control-Allow-Headers", "Content-Type, Accept");
		resp.addHeader("Access-Control-Expose-Headers", "Content-Type, Accept");
	}
}
