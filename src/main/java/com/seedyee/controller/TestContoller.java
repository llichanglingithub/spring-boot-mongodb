package com.seedyee.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.MessageSourceAutoConfiguration;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.env.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

/**
 * @author lcl
 * @createDate 2016年11月15日下午2:10:47
 *
 */
@RestController
public class TestContoller {
	
	@Autowired
	private MessageSource messageSource;
	
	
	@Autowired
	private CookieLocaleResolver cookieLocaleResolver;
	
	private MessageSourceAutoConfiguration m;
//	@RequestMapping(value = "/error/test", method = RequestMethod.POST)
//	public Object errorTest(@RequestParam(name = "string", required = true) String string) {
//		if (string.equals("1")) {
//			return ErrorEnum.ACCOUNT_EXITED.getCode() + "" + ErrorEnum.ACCOUNT_EXITED.getMessage();
//		}
//		return ErrorEnum.ACCOUNT_PASSWOED_ERROR.getCode() + "" + ErrorEnum.ACCOUNT_PASSWOED_ERROR.getMessage();
//	}
	
	@RequestMapping(value = "/international/test")
	public Object internationalTest(HttpServletRequest request, HttpServletResponse response ,@RequestParam(name = "language")String language, @RequestParam(name = "country")String country) {
		Locale locale = new Locale(language, country);
		//cookieLocaleResolver.setDefaultLocale(locale);
		//cookieLocaleResolver.setLocale(request, response, locale);
		//LocaleContextHolder localeContextHolder = null;
		//LocaleContext localeContext = new SimpleLocaleContext(locale);
		//Locale locale2 = LocaleContextHolder.getLocale();
		// new Object[]{0}
		String returnMessage = null;
//		returnMessage = messageSource.getMessage("error.unavailable.password", null, locale);
		returnMessage = messageSource.getMessage("welcome", null, locale);
		
		//returnMessage = messageSource.getMessage("welcome", null, "没有读取到", locale);
		return returnMessage;
	}
	@RequestMapping(value = "/international/test2")
	public Object mongoTemplateTest(HttpServletRequest request) {
		String returnMessage = null;
		Locale locale = LocaleContextHolder.getLocale();
		returnMessage = messageSource.getMessage("welcome", null, locale);
		return returnMessage;
	}
}
