package com.memorystyle.repo.mongo.doc;

import com.memorystyle.domian.user.entity.User;
import com.memorystyle.domian.user.vo.Follow;
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
  private String id;
  private String userEmail;
  private String userName;
  private String password;
  private String signUpTime;
  private String description;
//private UserMetadata userMetadata;
  private List<Follow> followers;
  private List<Follow> following;
  private List<String> bookmarks;

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
