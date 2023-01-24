package com.nextree.nxboard.service;

import com.nextree.nxboard.domian.user.entity.User;
import com.nextree.nxboard.domian.user.sdo.BookmarkCdo;
import com.nextree.nxboard.repo.mongo.UserMongoStore;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
  //
  private final UserMongoStore store;

  public UserService(UserMongoStore store) {
    this.store = store;
  }

  public void registerBookmark(BookmarkCdo bookmarkCdo) {
    String boardId = bookmarkCdo.getBoardId();
    User user = store.retrieveById(boardId);
    List<String> bookmarks = user.getBookmarks();
    bookmarks.add(boardId);
    user.setBookmarks(bookmarks);
    store.registerBookmark(user);
  }
}
