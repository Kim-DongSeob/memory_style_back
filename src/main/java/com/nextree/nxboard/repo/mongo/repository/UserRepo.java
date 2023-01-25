package com.nextree.nxboard.repo.mongo.repository;

import com.nextree.nxboard.repo.mongo.doc.UserDoc;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<UserDoc, String> {

  UserDoc findByUserId(String userId);

  UserDoc findByUserIdAndPassword(String userId, String password);
}
