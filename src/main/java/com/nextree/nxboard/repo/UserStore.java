package com.nextree.nxboard.repo;

import com.nextree.nxboard.domian.entity.User;

public interface UserStore {
  //
  void registerBookmark(String boardId);

  User retrieveById(String userId);
}
