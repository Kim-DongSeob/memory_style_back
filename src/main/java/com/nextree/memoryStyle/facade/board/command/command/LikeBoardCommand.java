package com.nextree.memoryStyle.facade.board.command.command;

import lombok.Getter;

@Getter
public class LikeBoardCommand {
  //
  private String userId;
  private String boardId;
}
