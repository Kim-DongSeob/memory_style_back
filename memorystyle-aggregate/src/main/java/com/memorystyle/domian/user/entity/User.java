package com.memorystyle.domian.user.entity;

import com.memorystyle.domian.user.vo.Follow;
import com.memorystyle.domian.vo.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends Entity {
//  private UserMetadata userMetadata;
  private String userEmail;
  private String userName;
  private String password;
  private String signUpTime;
  private String description;
  private List<Follow> followers;
  private List<Follow> following;
  private List<String> bookmarks;
}
