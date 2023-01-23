package com.nextree.nxboard.repo.mongo;

import com.nextree.nxboard.domian.sdo.BookmarkCdo;
import com.nextree.nxboard.repo.UserStore;
import com.nextree.nxboard.repo.mongo.repository.UserRepo;
import org.springframework.stereotype.Repository;

@Repository
public class UserMongoStore implements UserStore {
  //
  private final UserRepo userRepo;

  public UserMongoStore(UserRepo userRepo) {
    this.userRepo = userRepo;
  }

  @Override
  public void registerBookmark(BookmarkCdo bookmarkCdo) {
    userRepo.registerBookmark(bookmarkCdo);
  }
}
