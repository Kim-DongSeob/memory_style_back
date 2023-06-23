package com.nextree.memoryStyle.repo.mongo.repository;

import com.nextree.memoryStyle.repo.mongo.doc.UserDoc;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepo extends MongoRepository<UserDoc, String> {

  Optional<UserDoc> findByUserEmail(String userEmail);

  Optional<UserDoc> findByUserEmailAndPassword(String userEmail, String password);
}
