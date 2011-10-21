package br.com.webb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.webb.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

}
