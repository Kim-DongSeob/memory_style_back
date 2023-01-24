package com.nextree.nxboard.repo;

import com.nextree.nxboard.domian.entity.User;

public interface UserStore {
  //
  void registerBookmark(User user);

  User retrieveById(String userId);
}
