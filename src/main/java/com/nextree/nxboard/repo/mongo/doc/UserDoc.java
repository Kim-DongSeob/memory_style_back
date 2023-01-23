package com.nextree.nxboard.repo.mongo.doc;

import com.nextree.nxboard.domian.vo.BoardId;
import com.nextree.nxboard.domian.vo.Follow;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

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
}
