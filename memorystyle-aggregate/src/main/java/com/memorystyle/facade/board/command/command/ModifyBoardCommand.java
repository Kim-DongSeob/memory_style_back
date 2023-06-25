package com.memorystyle.facade.board.command.command;

import com.memorystyle.domian.board.sdo.BoardUdo;
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
