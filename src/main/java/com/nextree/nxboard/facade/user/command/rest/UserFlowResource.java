package com.nextree.nxboard.facade.user.command.rest;

import com.nextree.nxboard.domian.user.sdo.BookmarkCdo;
import com.nextree.nxboard.facade.user.command.command.RegisterBookmarkCommand;
import com.nextree.nxboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/nx-board/user")
public class UserFlowResource {

  @Autowired
  public UserService userService;

  @PostMapping("/register/bookmark/command")
  public void registerBookmark(@RequestBody RegisterBookmarkCommand command) {
    BookmarkCdo bookmarkCdo = command.getBookmarkCdo();
    userService.registerBookmark(bookmarkCdo);
  }
}
