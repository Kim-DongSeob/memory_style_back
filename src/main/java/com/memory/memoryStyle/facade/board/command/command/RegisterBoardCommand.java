package com.memory.memoryStyle.facade.board.command.command;

import com.memory.memoryStyle.domian.board.sdo.BoardCdo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterBoardCommand {
  //
  private BoardCdo boardCdo;
}