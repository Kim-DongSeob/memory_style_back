package com.nextree.memoryStyle.repo.mongo;

import com.nextree.memoryStyle.domian.user.entity.User;
import com.nextree.memoryStyle.repo.UserStore;
import com.nextree.memoryStyle.repo.mongo.doc.UserDoc;
import com.nextree.memoryStyle.repo.mongo.repository.UserRepo;
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
  public void deleteBookmark(User user) {
    UserDoc userDoc = new UserDoc(user);
    userRepo.save(userDoc);
  }

  @Override
  public User retrieveByUserEmail(String userEmail) {
    Optional<UserDoc> userDoc = userRepo.findByUserEmail(userEmail);
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
  public User retrieveByUserEmailAndPassword(String userEmail, String password) {
    Optional<UserDoc> userDoc = userRepo.findByUserEmailAndPassword(userEmail, password);
    return userDoc.map(UserDoc::toEntity).orElse(null);
  }
}
