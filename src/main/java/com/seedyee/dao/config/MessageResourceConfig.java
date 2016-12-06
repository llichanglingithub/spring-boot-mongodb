package com.seedyee.dao.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * @author lcl
 * @createDate 2016年11月17日上午10:25:56
 *
 */
@Configuration
public class MessageResourceConfig {
	
	@Value(value = "${spring.messages.basename}")
	private String messageBaseName;

	@Bean(name = "messageSource")
	public ResourceBundleMessageSource getMessageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename(messageBaseName);
		//Set<String> basenameSet = messageSource.getBasenameSet();
		return messageSource;
	}
}
