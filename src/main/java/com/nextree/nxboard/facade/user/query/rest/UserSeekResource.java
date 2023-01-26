package com.nextree.nxboard.facade.user.query.rest;

import com.nextree.nxboard.domian.board.entity.Board;
import com.nextree.nxboard.domian.user.entity.User;
import com.nextree.nxboard.facade.user.query.query.FindBookmarksQuery;
import com.nextree.nxboard.facade.user.query.query.FindUserQuery;
import com.nextree.nxboard.service.BoardService;
import com.nextree.nxboard.service.UserService;
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

  @PostMapping("/find/query")
  public User findUser(@RequestBody FindUserQuery query) {
    String userId = query.getUserId();
    String password = query.getPassword();
    User user = userService.findUser(userId, password);
    user.setPassword(null);
    return user;
  }

  @PostMapping("/find/bookmarks/query")
  public List<Board> findBookmarks(@RequestBody FindBookmarksQuery query) {
    String userId = query.getUserId();
    User user = userService.findByUserId(userId);
    List<String> userBookmarks = user.getBookmarks(); // 유저가 좋아요한 목룍
    if (userBookmarks == null) {
      return null;
    }
    List<Board> boards = userBookmarks.stream().map(boardId -> boardService.findById(boardId)).collect(Collectors.toList());
    return boards;
  }
}
