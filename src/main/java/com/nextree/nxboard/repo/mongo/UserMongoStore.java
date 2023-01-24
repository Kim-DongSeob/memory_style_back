package com.nextree.nxboard.repo.mongo;

import com.nextree.nxboard.domian.entity.User;
import com.nextree.nxboard.domian.sdo.BookmarkCdo;
import com.nextree.nxboard.repo.UserStore;
import com.nextree.nxboard.repo.mongo.doc.UserDoc;
import com.nextree.nxboard.repo.mongo.repository.UserRepo;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserMongoStore implements UserStore {
  //
  private final UserRepo userRepo;

  public UserMongoStore(UserRepo userRepo) {
    this.userRepo = userRepo;
  }

  @Override
  public void registerBookmark(User user) {
    UserDoc userDoc = new UserDoc(user);
    userRepo.save(userDoc);
  }

  @Override
  public User retrieveById(String userId) {
    Optional<UserDoc> userDoc = userRepo.findByUserId(userId);
    return userDoc.orElseThrow(null).toEntity();
  }
}
