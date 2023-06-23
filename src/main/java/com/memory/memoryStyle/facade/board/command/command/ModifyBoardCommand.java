package com.memory.memoryStyle.facade.board.command.command;

import com.memory.memoryStyle.domian.board.sdo.BoardUdo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ModifyBoardCommand {
  //
  private BoardUdo boardUdo;
}
