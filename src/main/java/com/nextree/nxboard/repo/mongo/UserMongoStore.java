package com.nextree.nxboard.repo.mongo;

import com.nextree.nxboard.domian.user.entity.User;
import com.nextree.nxboard.repo.UserStore;
import com.nextree.nxboard.repo.mongo.doc.UserDoc;
import com.nextree.nxboard.repo.mongo.repository.UserRepo;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
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
  public void deleteBookmark(User user) {
    UserDoc userDoc = new UserDoc(user);
    userRepo.save(userDoc);
  }

  @Override
  public User retrieveByUserId(String userId) {
    Optional<UserDoc> userDoc = userRepo.findByUserId(userId);
    return userDoc.map(UserDoc::toEntity).orElse(null);
//    return userDoc.toEntity();
  }

  @Override
  public User retrieveById(String id) {
    Optional<UserDoc> userDoc = userRepo.findById(id);
    return userDoc.map(UserDoc::toEntity).orElse(null);
  }

  @Override
  public void registerUser(User user) {
    UserDoc userDoc = new UserDoc(user);
    userRepo.save(userDoc);
  }

  @Override
  public User retrieveByUserIdAndPassword(String userId, String password) {
    Optional<UserDoc> userDoc = userRepo.findByUserIdAndPassword(userId, password);
    return userDoc.map(UserDoc::toEntity).orElse(null);
  }
}
