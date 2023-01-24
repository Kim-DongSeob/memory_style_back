package com.nextree.nxboard.facade.user.command.command;

import com.nextree.nxboard.domian.user.sdo.BookmarkCdo;
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
  BookmarkCdo bookmarkCdo;
}
