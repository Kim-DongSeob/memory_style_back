package com.nextree.memoryStyle.domian.board.sdo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BoardUdo {
  private String boardId;
  private String userId;
  private String title;
  private String content;
}
