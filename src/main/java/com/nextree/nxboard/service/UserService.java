package com.nextree.nxboard.service;

import com.nextree.nxboard.domian.board.entity.Board;
import com.nextree.nxboard.domian.user.entity.User;
import com.nextree.nxboard.domian.user.sdo.BookmarkCdo;
import com.nextree.nxboard.domian.user.sdo.UserCdo;
import com.nextree.nxboard.repo.mongo.BoardMongoStore;
import com.nextree.nxboard.repo.mongo.UserMongoStore;
import com.nextree.nxboard.util.Util;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserService {
  //
  private final UserMongoStore store;
  private final BoardMongoStore boardStore;

  public UserService(UserMongoStore store, BoardMongoStore boardStore) {
    this.store = store;
    this.boardStore = boardStore;
  }

  public void registerBookmark(BookmarkCdo bookmarkCdo) {
    String userId = bookmarkCdo.getUserId();
    String boardId = bookmarkCdo.getBoardId();

    User user = store.retrieveByUserId(userId);
    Board board = boardStore.retrieveById(boardId);
    List<String> bookmarks = user.getBookmarks();
    if (bookmarks.contains(boardId)) {
      bookmarks.remove(boardId);
      user.setBookmarks(bookmarks);
      store.deleteBookmark(user);

      board.setBookmarkCount(board.getBookmarkCount() - 1);
      boardStore.saveBoard(board);
    } else {
      bookmarks.add(boardId);
      user.setBookmarks(bookmarks);
      store.registerBookmark(user);

      board.setBookmarkCount(board.getBookmarkCount() + 1);
      boardStore.saveBoard(board);
    }
  }

  public void registerUser(UserCdo userCdo) {
    if (userCdo == null) {
      throw new NullPointerException("userCdo : null");
    }
    String userId = userCdo.getUserId();
    if (store.retrieveByUserId(userId) != null) {
      throw new NullPointerException("Already existed");
    }
    String userName = userCdo.getUserName();
    String password = userCdo.getPassword();
    String signUpTime = Util.genDate();
    User user = new User();
    user.setId(Util.genId());
    user.setUserId(userId);
    user.setUserName(userName);
    user.setPassword(password);
    user.setSignUpTime(signUpTime);
    user.setFollowers(Collections.emptyList());
    user.setFollowing(Collections.emptyList());
    user.setBookmarks(Collections.emptyList());
    store.registerUser(user);
  }

  public User findUser(String userId, String password) {
    return store.retrieveByUserIdAndPassword(userId, password);
  }
}
