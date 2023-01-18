package com.nextree.nxboard.service;

import com.nextree.nxboard.domian.entity.Board;
import com.nextree.nxboard.repo.mongo.BoardMongoStore;
import org.springframework.stereotype.Service;

import java.util.List;

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

  public void createBoard(Board board) {
    board.setId(board.getId());
    board.setTitle(board.getTitle());
    board.setContent(board.getContent());
    board.setRegistrationTime(board.getRegistrationTime());
    board.setModificationTime(board.getModificationTime());
    board.setViewCount(board.getViewCount());
    store.create(board);
  }
}
