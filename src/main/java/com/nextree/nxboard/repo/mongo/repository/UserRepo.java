package com.nextree.nxboard.repo.mongo.repository;

import com.nextree.nxboard.domian.sdo.BookmarkCdo;
import com.nextree.nxboard.repo.mongo.doc.BoardDoc;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<BoardDoc, String> {
  void registerBookmark(BookmarkCdo bookmarkCdo);
}
