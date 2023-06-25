package com.memorystyle.domian.user.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserMetadata {
  //
  private String userId;
  private String userName;
  private String password;
  private String signUpTime;
}
