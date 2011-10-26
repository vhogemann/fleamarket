package br.com.webb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.webb.model.Request;

@Repository
public interface RequestRepository extends MongoRepository<Request, String> {

}
