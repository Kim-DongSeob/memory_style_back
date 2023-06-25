package com.memorystyle.facade.user.command.command;

import com.memorystyle.domian.user.sdo.BookmarkCdo;
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
