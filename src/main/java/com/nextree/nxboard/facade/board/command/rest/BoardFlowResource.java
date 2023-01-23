package com.nextree.nxboard.facade.board.command.rest;

import com.nextree.nxboard.domian.sdo.BoardCdo;
import com.nextree.nxboard.facade.board.command.command.RegisterBoardCommand;
import com.nextree.nxboard.facade.board.command.command.RemoveBoardCommand;
import com.nextree.nxboard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/nx-board/board")
public class BoardFlowResource {
  @Autowired
  public BoardService boardService;

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
}
