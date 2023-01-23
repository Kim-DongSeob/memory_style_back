package com.nextree.nxboard.repo;

import com.nextree.nxboard.domian.entity.Board;

import java.util.List;

public interface BoardStore {
//  void update(Board board);
//  void deleteById(Board board);

  void create(Board board);

  void deleteById(String id);
  List<Board> retrieveAll();
  Board retrieveById(String id);

  void increaseViewCount(Board board);
}
