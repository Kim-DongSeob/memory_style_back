package com.nextree.nxboard.repo.mongo.doc;

import com.nextree.nxboard.domian.entity.User;
import com.nextree.nxboard.domian.entity.User;
import com.nextree.nxboard.domian.vo.BoardId;
import com.nextree.nxboard.domian.vo.Follow;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.stream.Collectors;

@Document("USER")
@Getter
@Setter
@NoArgsConstructor
public class UserDoc {
  String userId;
  String userName;
  String password;
  List<Follow> followers;
  List<Follow> following;
  String signUpTime;
  List<BoardId> bookmarks;

  public UserDoc(User user) {
    super();
    BeanUtils.copyProperties(user, this);
  }

  public User toEntity() {
    User user = new User();
    BeanUtils.copyProperties(this, user);
    return user;
  }

  public static List<User> toEntities(List<UserDoc> userDocs) {
    return userDocs.stream().map(UserDoc::toEntity).collect(Collectors.toList());
  }
}
