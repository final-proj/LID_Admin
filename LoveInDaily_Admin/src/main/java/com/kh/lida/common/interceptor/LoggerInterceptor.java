package com.kh.lida.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoggerInterceptor extends HandlerInterceptorAdapter {

Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 일반적으로 logger의 기능을 명시하면 레벨에 관련없이 무조건 수행한다.
		// 하지만, debug 모드가 아닐 경우 debug와 관련된 log는 수행할 필요가 없기 때문에 if문으로 확인하여 debug모드 일때만 수행하도록 조건 처리함으로써 log를 남길때 시간을 절약할 수 있다.
		if(logger.isDebugEnabled()) {
			logger.debug("========START========");
			logger.debug(request.getRequestURI());
			logger.debug("---------------------");
		}
		return super.preHandle(request, response, handler); // 를 통해서 실제 처리할 기능이 연결되기 때문에 수정하지 않는다. 따라서 결과는 반드시 true만 나온다.
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if(logger.isDebugEnabled()) {
			logger.debug("========VIEW========");
		}
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("========END========\n");
		}
		super.afterCompletion(request, response, handler, ex);
	}
	
}
