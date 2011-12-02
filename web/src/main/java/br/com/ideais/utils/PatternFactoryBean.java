package br.com.ideais.utils;

import java.util.regex.Pattern;

import org.springframework.beans.factory.config.AbstractFactoryBean;

public class PatternFactoryBean extends AbstractFactoryBean<Pattern> {
	
	private String regex;
	
	public void setRegex(String regex) {
		this.regex = regex;
	}

	@Override
	protected Pattern createInstance() throws Exception {
		return Pattern.compile(regex);
	}

	@Override
	public Class<Pattern> getObjectType() {
		return Pattern.class;
	}

}