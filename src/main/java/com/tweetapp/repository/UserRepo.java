package com.tweetapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.tweetapp.model.UserT;
@Repository
public interface UserRepo extends MongoRepository<UserT, String>{
	@Query(value = "{ 'email':?0 }")
	Optional<UserT> findByEmail(String uid);
	
	@Query(value="{ 'email': { '$in': [ /^?0/ ] } }")
	List<UserT> getUsernameMatching(String match);

	
}
	
