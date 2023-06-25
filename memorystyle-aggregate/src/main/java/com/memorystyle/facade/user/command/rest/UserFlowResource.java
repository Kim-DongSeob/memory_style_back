package com.memorystyle.facade.user.command.rest;

import com.memorystyle.domian.user.sdo.BookmarkCdo;
import com.memorystyle.domian.user.sdo.UserCdo;
import com.memorystyle.facade.user.command.command.RegisterBookmarkCommand;
import com.memorystyle.facade.user.command.command.RegisterUserCommand;
import com.memorystyle.service.UserService;
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

  @PostMapping("/register/command")
  public void registerUser(@RequestBody RegisterUserCommand command) {
    UserCdo userCdo = command.getUserCdo();
    userService.registerUser(userCdo);
  }
}
