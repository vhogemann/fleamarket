package br.com.webb.web.action

import org.springframework.beans.factory.annotation.Autowire

import br.com.webb.model.Product
import br.com.webb.repository.ProductRepository

class ProductAction {

	@Autowire
	ProductRepository productRepository
	
	def entities
	
	Product product
	
	String list(){
		
		entities = productRepository.findAll()
		
		"success"
	}
	
	String create(){
		"success"
	}
	
	String update(){
		"success"
	}
	
	String delete(){
		"success"
	}
	
}
