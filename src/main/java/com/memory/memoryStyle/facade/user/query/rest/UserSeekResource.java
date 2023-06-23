package com.memory.memoryStyle.facade.user.query.rest;

import com.memory.memoryStyle.domian.board.entity.Board;
import com.memory.memoryStyle.domian.user.entity.User;
import com.memory.memoryStyle.domian.user.sdo.UserRdo;
import com.memory.memoryStyle.facade.user.query.query.FindBookmarksQuery;
import com.memory.memoryStyle.facade.user.query.query.FindLoginUserQuery;
import com.memory.memoryStyle.facade.user.query.query.FindUserQuery;
import com.memory.memoryStyle.service.BoardService;
import com.memory.memoryStyle.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/nx-board/user")
public class UserSeekResource {

  @Autowired
  public UserService userService;
  public BoardService boardService;

  public UserSeekResource(UserService userService, BoardService boardService) {
    this.userService = userService;
    this.boardService = boardService;
  }

  @PostMapping("/find/login/query")
  public UserRdo findLoginUser(@RequestBody FindLoginUserQuery query) {
    String userId = query.getUserEmail();
    String password = query.getPassword();
    User user = userService.findUserToLogin(userId, password);
    UserRdo userRdo = new UserRdo();
    userRdo.setId(user.getId());
    userRdo.setUserEmail(user.getUserEmail());
    userRdo.setUserName(user.getUserName());
    userRdo.setSignUpTime(user.getSignUpTime());
    userRdo.setDescription(user.getDescription());
    userRdo.setFollowers(user.getFollowers());
    userRdo.setFollowing(user.getFollowing());
    userRdo.setBookmarks(user.getBookmarks());
    return userRdo;
  }

  @PostMapping("/find/bookmarks/query")
  public List<Board> findBookmarks(@RequestBody FindBookmarksQuery query) {
    String userId = query.getUserId();
    User user = userService.findById(userId);
    List<String> userBookmarks = user.getBookmarks(); // 유저가 좋아요한 목룍
    if (userBookmarks == null) {
      return null;
    }
    List<Board> boards = userBookmarks.stream().map(boardId -> boardService.findById(boardId)).collect(Collectors.toList());
    return boards;
  }

  @PostMapping("/find/user/query")
  public UserRdo findUser(@RequestBody FindUserQuery query) {
    String id = query.getId();
    User user = userService.findById(id);
    UserRdo userRdo = new UserRdo();
    userRdo.setId(user.getId());
    userRdo.setUserEmail(user.getUserEmail());
    userRdo.setUserName(user.getUserName());
    userRdo.setDescription(user.getDescription());
    userRdo.setFollowers(user.getFollowers());
    userRdo.setFollowing(user.getFollowing());
    userRdo.setBookmarks(user.getBookmarks());
    return userRdo;
  }
}
