package com.nextree.nxboard.domian.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {
  //
  String userId;
  String userName;
  int follower;
  int following;
  String signUpTime;
}
