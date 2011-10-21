package br.com.webb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.webb.model.Supplier;

@Repository
public interface SupplierRepository extends MongoRepository<Supplier, String> {

}
