package com.nextree.nxboard.facade.user.query.rest;

import com.nextree.nxboard.domian.user.entity.User;
import com.nextree.nxboard.facade.user.query.query.FindUserQuery;
import com.nextree.nxboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/nx-board/user")
public class UserSeekResource {

  @Autowired
  public UserService userService;

  public UserSeekResource(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/find/query")
  public User findUser(@RequestBody FindUserQuery query) {
    String userId = query.getUserId();
    String password = query.getPassword();
    User user = userService.findUser(userId, password);
    user.setPassword(null);
    return user;
  }
}
