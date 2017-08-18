package com.ucai.aop;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class WebAop {

	private Logger logger = LoggerFactory.getLogger(WebAop.class);

	/**
	 * 切入点 只对springboot包下面的方法进行切入
	 */
	@Pointcut("execution(public * com.ucai.springboot..*.*(..))")
	public void pointCut() {
	}

	/**
	 * 执行之前进行切入
	 * @param jp
	 */
	@Before("pointCut()")
	public void doBefore(JoinPoint jp) {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();

		HttpServletRequest request = attr.getRequest();
		// 记录下请求内容
		logger.info("URL : " + request.getRequestURL().toString());
		logger.info("HTTP_METHOD : " + request.getMethod());
		logger.info("IP : " + request.getRemoteAddr());
		logger.info("CLASS_METHOD : "
				+ jp.getSignature().getDeclaringTypeName() + "."
				+ jp.getSignature().getName());
		logger.info("ARGS : " + Arrays.toString(jp.getArgs()));
	}
}
