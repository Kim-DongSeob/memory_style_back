package com.memory.memoryStyle.facade.user.command.command;

import com.memory.memoryStyle.domian.user.sdo.BookmarkCdo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterBookmarkCommand {
  //
  private BookmarkCdo bookmarkCdo;
}
