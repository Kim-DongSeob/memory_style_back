package com.nextree.nxboard.domian.board.entity;

import com.nextree.nxboard.domian.vo.Entity;
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
  private int likeCount;
  private int viewCount;
}
