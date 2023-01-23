package com.nextree.nxboard.facade.user.query.rest;

import com.nextree.nxboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/nx-board/user")
public class UserSeekResource {

  @Autowired
  private final UserService userService;

  public UserSeekResource(UserService userService) {
    this.userService = userService;
  }
}
