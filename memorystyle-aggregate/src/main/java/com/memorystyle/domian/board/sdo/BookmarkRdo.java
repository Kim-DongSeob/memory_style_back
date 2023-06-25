package com.memorystyle.domian.board.sdo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BookmarkRdo {
  //
  private String title;
  private String content;
  private String registrationTime;
  private String modificationTime;
  private int bookmarkCount;
  private int viewCount;
}
