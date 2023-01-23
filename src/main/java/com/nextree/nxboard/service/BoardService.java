package com.nextree.nxboard.service;

import com.nextree.nxboard.domian.entity.Board;
import com.nextree.nxboard.domian.entity.User;
import com.nextree.nxboard.domian.sdo.BoardCdo;
import com.nextree.nxboard.domian.vo.BoardId;
import com.nextree.nxboard.repo.mongo.BoardMongoStore;
import com.nextree.nxboard.util.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BoardService {
  //
  private final BoardMongoStore store;

  public BoardService(BoardMongoStore store) {
    this.store = store;
  }

  public List<Board> findAll() {
    return store.retrieveAll();
  }

  public Board findById(String id) {
    Board board = store.retrieveById(id);
    board.setViewCount(board.getViewCount() + 1);
    store.increaseViewCount(board);
    return board;
  }

  public void deleteById(String id) {
    store.deleteById(id);
  }

  public void createBoard(BoardCdo boardCdo) {
//    User user = boardCdo.getUser();
    Board board = new Board();
    board.setId(Util.genId());
//    board.setUserName(user.getUserName());
    board.setTitle(boardCdo.getTitle());
    board.setContent(boardCdo.getContent());
    board.setRegistrationTime(Util.genDate());
    board.setModificationTime(Util.genDate());
    board.setLikeCount(0);
    board.setViewCount(0);
    store.create(board);
  }
}
