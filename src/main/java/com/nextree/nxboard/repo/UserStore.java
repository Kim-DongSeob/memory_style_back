package com.nextree.nxboard.repo;

import com.nextree.nxboard.domian.user.entity.User;

public interface UserStore {
  //
  void registerBookmark(User user);

  void deleteBookmark(User user);

  User retrieveByUserEmail(String userEmail);

  User retrieveById(String id);

  void registerUser(User user);

  User retrieveByUserEmailAndPassword(String userEmail, String password);
}
