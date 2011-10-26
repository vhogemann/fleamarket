package br.com.webb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.webb.model.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {

}
