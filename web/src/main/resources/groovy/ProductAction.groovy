package br.com.webb.web.action

import org.springframework.beans.factory.annotation.Autowire

import br.com.webb.model.Product
import br.com.webb.repository.ProductRepository

class ProductAction {

	@Autowire
	ProductRepository productRepository
	
	def products
	
	Product product
	
	String execute(){
		
		this.products = productRepository.findAll()
		
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
