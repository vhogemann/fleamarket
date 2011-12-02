package br.com.ideais.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.ideais.model.Request;
import br.com.ideais.model.order.RequestState;

@Repository
public interface RequestRepository extends MongoRepository<Request, String> {

	List<Request> findByStatusState(RequestState state);
	Page<Request> findByStatusState(RequestState state, Pageable pageable);
	
	List<Request> findByOrderObjectId(String objectId);
	List<Request> findByQuotesObjectId(String objectId);
	
}
