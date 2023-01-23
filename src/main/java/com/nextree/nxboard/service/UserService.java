package com.nextree.nxboard.service;

import com.nextree.nxboard.domian.sdo.BookmarkCdo;
import com.nextree.nxboard.domian.vo.BoardId;
import com.nextree.nxboard.domian.vo.UserMetadata;
import com.nextree.nxboard.repo.mongo.UserMongoStore;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  //
  private final UserMongoStore store;

  public UserService(UserMongoStore store) {
    this.store = store;
  }

  public void registerBookmark(BookmarkCdo bookmarkCdo) {
    store.registerBookmark(bookmarkCdo);
  }
}
