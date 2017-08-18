package com.ucai.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ucai.aop.WebAop;
import com.ucai.pojo.UserTest;

public class LoginInteceptor implements HandlerInterceptor
{
	private Logger logger = LoggerFactory.getLogger(LoginInteceptor.class);

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res,
			Object arg2) throws Exception {
		
		logger.info("LoginInteceptor----");
		//判断是否登录
		UserTest ut =  (UserTest) req.getSession().getAttribute("user");
		String path = req.getRequestURI();
		if (path.contains("login"))
		{
			return true;
		}
		if (null == ut)
		{
			res.sendRedirect("logon.html");
			return false;
		}
		
		
		return true;
	}

}
