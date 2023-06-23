package com.memory.memoryStyle.facade.user.query.query;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FindLoginUserQuery {
  //
  private String userEmail;
  private String password;
}
