package com.nextree.nxboard.facade.user.command.rest;

import com.nextree.nxboard.domian.sdo.BookmarkCdo;
import com.nextree.nxboard.domian.vo.BoardId;
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
  private final UserService userService;

  public UserFlowResource(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/register/bookmark/command")
  public void registerBookmark(@RequestBody RegisterBookmarkCommand command) {
    BookmarkCdo bookmarkCdo = command.getBookmarkCdo();
    userService.registerBookmark(bookmarkCdo);
  }
}
