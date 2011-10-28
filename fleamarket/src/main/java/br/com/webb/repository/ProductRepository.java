package br.com.webb.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.webb.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

	List<Product> findByName(String name);
	Page<Product> findByName(String name, Pageable pageable);
	
	List<Product> findByNameLike(String name);
	Page<Product> findByNameLike(String name, Pageable pageable);
	
}
