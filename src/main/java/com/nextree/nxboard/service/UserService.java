package com.nextree.nxboard.service;

import com.nextree.nxboard.domian.user.entity.User;
import com.nextree.nxboard.domian.user.sdo.BookmarkCdo;
import com.nextree.nxboard.domian.user.sdo.UserCdo;
import com.nextree.nxboard.domian.user.vo.Follow;
import com.nextree.nxboard.domian.user.vo.UserMetadata;
import com.nextree.nxboard.repo.mongo.UserMongoStore;
import com.nextree.nxboard.util.Util;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserService {
  //
  private final UserMongoStore store;

  public UserService(UserMongoStore store) {
    this.store = store;
  }

  public void registerBookmark(BookmarkCdo bookmarkCdo) {
    String userId = bookmarkCdo.getUserId();
    User user = store.retrieveByUserId(userId);
    List<String> bookmarks = user.getBookmarks();
    bookmarks.add(bookmarkCdo.getBoardId());
    user.setBookmarks(bookmarks);
    store.registerBookmark(user);
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
//    UserMetadata userMetadata = new UserMetadata(userId, userName, password, signUpTime);

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
}
