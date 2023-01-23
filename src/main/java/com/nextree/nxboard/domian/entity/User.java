package com.nextree.nxboard.domian.entity;

import com.nextree.nxboard.domian.vo.Follow;
import com.nextree.nxboard.domian.vo.UserMetadata;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class User {
  UserMetadata userMetadata;
  List<Follow> followers;
  List<Follow> following;
  String signUpTime;
  List<String> bookmarks;
}
