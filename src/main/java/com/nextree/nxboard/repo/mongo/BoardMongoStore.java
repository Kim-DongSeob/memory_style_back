package com.nextree.nxboard.repo.mongo;

import com.nextree.nxboard.domian.entity.Board;
import com.nextree.nxboard.repo.BoardStore;
import com.nextree.nxboard.repo.mongo.doc.BoardDoc;
import com.nextree.nxboard.repo.mongo.repository.BoardRepo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardMongoStore implements BoardStore {
  //
  private final BoardRepo boardRepo;

  public BoardMongoStore(BoardRepo boardRepo) {
    this.boardRepo = boardRepo;
  }

//  @Override
//  public void update(Board board) {
//
//  }
//
//  @Override
//  public void deleteById(Board board) {
//
//  }

  @Override
  public void create(Board board) {
    BoardDoc boardDoc = new BoardDoc(board);
    boardRepo.save(boardDoc);
  }

  @Override
  public List<Board> retrieveAll() {
    return BoardDoc.toEntities(boardRepo.findAll());
  }
}
