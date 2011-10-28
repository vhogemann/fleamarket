package br.com.webb;

import java.sql.SQLException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) throws SQLException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:importer-context.xml");
		
		Importer importer = context.getBean(Importer.class);
		
		importer.run();
		
	}
}
