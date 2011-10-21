package br.com.webb.util;

import groovy.lang.Binding;
import groovy.ui.Console;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InteractiveConsole {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:console-context.xml");
		Binding binding = context.getBean(Binding.class);
		Console console = new Console(binding);
		console.run();
	}

}
