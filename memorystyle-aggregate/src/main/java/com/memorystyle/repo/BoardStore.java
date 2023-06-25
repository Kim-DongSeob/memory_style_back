package com.memorystyle.repo;

import com.memorystyle.domian.board.entity.Board;

import java.util.List;

public interface BoardStore {
  void create(Board board);
  void deleteById(String id);
  List<Board> retrieveAll();
  Board retrieveById(String id);
  void increaseViewCount(Board board);
  void modifyBoard(Board board);

  void saveBoard(Board board);
}
