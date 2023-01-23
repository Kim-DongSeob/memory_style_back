package com.nextree.nxboard.repo.mongo.repository;

import com.nextree.nxboard.repo.mongo.doc.BoardDoc;
import com.nextree.nxboard.repo.mongo.doc.UserDoc;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepo extends MongoRepository<UserDoc, String> {
  void registerBookmark(String boardId);

  Optional<UserDoc> findById(String userId);
}
