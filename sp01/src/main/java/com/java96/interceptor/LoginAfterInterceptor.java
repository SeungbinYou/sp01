package com.java96.interceptor;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.java96.dto.MemberDTO;

public class LoginAfterInterceptor extends HandlerInterceptorAdapter {

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		if(request.getMethod().equals("GET")) {
			return;
		}
		
		String auto = request.getParameter("auto");
		
		System.out.println("AUTO:" + auto);
		
		Map<String,Object> map = modelAndView.getModel();
		
		System.out.println("==============================");
		System.out.println("MAP.........................");
		System.out.println(map);
		
		if(map.get("memberDTO") != null ) {
			
			System.out.println("set session Data...................");
			
			//use session
			request.getSession().setAttribute("memberDTO", map.get("memberDTO"));
			
			if(auto.equals("on")) {
				//use cookie
				MemberDTO dto = (MemberDTO)map.get("memberDTO");
				Cookie loginCookie = new Cookie("login",dto.getUid() );
				loginCookie.setMaxAge(60*60*24);
				response.addCookie(loginCookie);
			}
			
		}
		
	}	
}
