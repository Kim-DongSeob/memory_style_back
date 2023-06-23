package com.nextree.memoryStyle.facade.user.command.command;

import com.nextree.memoryStyle.domian.user.sdo.UserCdo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserCommand {
  //
  private UserCdo userCdo;
}
