package com.nextree.nxboard.domian.user.entity;

import com.nextree.nxboard.domian.user.vo.Follow;
import com.nextree.nxboard.domian.user.vo.UserMetadata;
import com.nextree.nxboard.domian.vo.Entity;
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
  private String userId;
  private String userName;
  private String password;
  private String signUpTime;
  private List<Follow> followers;
  private List<Follow> following;
  private List<String> bookmarks;
}
