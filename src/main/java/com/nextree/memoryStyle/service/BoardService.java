package com.nextree.memoryStyle.service;

import com.nextree.memoryStyle.domian.board.entity.Board;
import com.nextree.memoryStyle.domian.board.sdo.BoardCdo;
import com.nextree.memoryStyle.domian.board.sdo.BoardUdo;
import com.nextree.memoryStyle.domian.user.entity.User;
import com.nextree.memoryStyle.repo.mongo.BoardMongoStore;
import com.nextree.memoryStyle.repo.mongo.UserMongoStore;
import com.nextree.memoryStyle.util.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BoardService {
  //
  private final BoardMongoStore store;
  private final UserMongoStore userStore;

  public BoardService(BoardMongoStore store, UserMongoStore userStore) {
    this.store = store;
    this.userStore = userStore;
  }

  public List<Board> findAll() {
    return store.retrieveAll();
  }

  public Board findById(String id) {
    Board board = store.retrieveById(id);
    if (board != null) {
      board.setViewCount(board.getViewCount() + 1);
      store.increaseViewCount(board);
    }
    return board;
  }

  public void deleteById(String id) {
    store.deleteById(id);
  }

  public void createBoard(BoardCdo boardCdo) {
    User user = userStore.retrieveById(boardCdo.getUserId());
    Board board = new Board();
    board.setId(Util.genId());
    board.setUserId(user.getId());
    board.setTitle(boardCdo.getTitle());
    board.setContent(boardCdo.getContent());
    board.setRegistrationTime(Util.genDate());
    board.setModificationTime(Util.genDate());
    board.setBookmarkCount(0);
    board.setViewCount(0);
    store.create(board);
  }

  public void modifyBoard(BoardUdo boardUdo) {
    Board board = store.retrieveById(boardUdo.getBoardId());
    board.setTitle(boardUdo.getTitle());
    board.setContent(boardUdo.getContent());
    store.modifyBoard(board);
  }
}
