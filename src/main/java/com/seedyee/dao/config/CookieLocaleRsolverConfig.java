package com.seedyee.dao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

/**
 * @author lcl
 * @createDate 2016年11月17日下午3:15:46
 *
 */
@Configuration
public class CookieLocaleRsolverConfig {
	
	@Bean(name = "cookieLocaleResolver")
	public CookieLocaleResolver getCookieLocaleResolver() {
		CookieLocaleResolver resolver = new CookieLocaleResolver();
		return resolver;
		
	}
}
