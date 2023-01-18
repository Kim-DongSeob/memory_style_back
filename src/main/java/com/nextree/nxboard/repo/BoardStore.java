package com.nextree.nxboard.repo;

import com.nextree.nxboard.domian.entity.Board;

import java.util.List;

public interface BoardStore {
//  void update(Board board);
//  void deleteById(Board board);

  void create(Board board);
  List<Board> retrieveAll();
}
