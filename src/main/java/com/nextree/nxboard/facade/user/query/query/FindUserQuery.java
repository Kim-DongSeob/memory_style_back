package com.nextree.nxboard.facade.user.query.query;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FindUserQuery {
  //
  private String userId;
  private String password;
}
