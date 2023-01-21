package com.nextree.nxboard.domian.sdo;

import com.nextree.nxboard.domian.vo.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class BoardCdo {
  private User user;
  private String title;
  private String content;
}
