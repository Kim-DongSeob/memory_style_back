package com.nextree.nxboard.repo;

import com.nextree.nxboard.domian.user.entity.User;

public interface UserStore {
  //
  void registerBookmark(User user);

  void deleteBookmark(User user);

  User retrieveByUserId(String userId);

  void registerUser(User user);

  User retrieveByUserIdAndPassword(String userId, String password);
}
