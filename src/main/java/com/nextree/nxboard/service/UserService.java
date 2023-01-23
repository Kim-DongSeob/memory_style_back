package com.nextree.nxboard.service;

import com.nextree.nxboard.domian.entity.User;
import com.nextree.nxboard.domian.sdo.BookmarkCdo;
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
    String boardId = bookmarkCdo.getBoardId();
    User user = store.retrieveById(bookmarkCdo.getUserId());

//     리스트에 어케 넣지??
//    user.setBookmarks(boardId);
//    store.registerBookmark(boardId);
  }
}
