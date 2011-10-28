package br.com.webb.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.webb.model.Request;
import br.com.webb.model.order.RequestState;

@Repository
public interface RequestRepository extends MongoRepository<Request, String> {

	List<Request> findByStatusState(RequestState state);
	Page<Request> findByStatusState(RequestState state, Pageable pageable);
	
}
