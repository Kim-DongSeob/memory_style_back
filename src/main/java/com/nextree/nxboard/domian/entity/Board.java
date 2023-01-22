package com.nextree.nxboard.domian.entity;

import com.nextree.nxboard.domian.vo.User;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
public class Board {
  //
  private String id;
  private String userId;
  private String title;
  private String content;
  private String registrationTime;
  private String modificationTime;
  private int likeCount;
  private int viewCount;
}
