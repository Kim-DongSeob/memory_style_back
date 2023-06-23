package com.nextree.memoryStyle.facade.user.command.rest;

import com.nextree.memoryStyle.domian.user.sdo.BookmarkCdo;
import com.nextree.memoryStyle.domian.user.sdo.UserCdo;
import com.nextree.memoryStyle.facade.user.command.command.RegisterBookmarkCommand;
import com.nextree.memoryStyle.facade.user.command.command.RegisterUserCommand;
import com.nextree.memoryStyle.service.UserService;
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
