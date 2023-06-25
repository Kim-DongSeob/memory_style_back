package com.memorystyle.facade.board.command.rest;

import com.memorystyle.domian.board.sdo.BoardCdo;
import com.memorystyle.domian.board.sdo.BoardUdo;
import com.memorystyle.facade.board.command.command.ModifyBoardCommand;
import com.memorystyle.facade.board.command.command.RegisterBoardCommand;
import com.memorystyle.facade.board.command.command.RemoveBoardCommand;
import com.memorystyle.service.BoardService;
import com.memorystyle.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/nx-board/board")
public class BoardFlowResource {

  @Autowired
  public BoardService boardService;
  public UserService userService;

  @PostMapping("/register/command")
  public void createBoard(@RequestBody RegisterBoardCommand command) {
    BoardCdo boardCdo = command.getBoardCdo();
    if (boardCdo == null || boardCdo.getTitle() == null || boardCdo.getContent() == null) {
      throw new NullPointerException("There is empty value");
    }
    boardService.createBoard(boardCdo);
  }

  @PostMapping("/delete/command")
  public void deleteBoard(@RequestBody RemoveBoardCommand command) {
    String boardId = command.getBoardId();
    boardService.deleteById(boardId);
  }

  @PostMapping("/modify/command")
  public void modifyBoard(@RequestBody ModifyBoardCommand command) {
    BoardUdo boardUdo = command.getBoardUdo();
    boardService.modifyBoard(boardUdo);
  }

//  @PostMapping("/increase/bookmark/command")
//  public void bookmarkBoard(@RequestBody LikeBoardCommand command) {
//    Board board = boardService.findById(command.getBoardId());
//    User user = userService.
//    board.setLikeCount(board.getLikeCount() + 1);
//  }
}
