package com.memory.memoryStyle.domian.board.entity;

import com.memory.memoryStyle.domian.vo.Entity;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
public class Board extends Entity {
  //
  private String userId;
  private String title;
  private String content;
  private String registrationTime;
  private String modificationTime;
  private int bookmarkCount;
  private int viewCount;
}
