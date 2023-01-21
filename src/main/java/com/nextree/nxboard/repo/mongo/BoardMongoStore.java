package com.nextree.nxboard.repo.mongo;

import com.nextree.nxboard.domian.entity.Board;
import com.nextree.nxboard.repo.BoardStore;
import com.nextree.nxboard.repo.mongo.doc.BoardDoc;
import com.nextree.nxboard.repo.mongo.repository.BoardRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class BoardMongoStore implements BoardStore {
  //
  private final BoardRepo boardRepo;

  public BoardMongoStore(BoardRepo boardRepo) {
    this.boardRepo = boardRepo;
  }

  @Override
  public void create(Board board) {
    BoardDoc boardDoc = new BoardDoc(board);
    boardRepo.save(boardDoc);
  }

  @Override
  public void deleteById(String id) {
    boardRepo.deleteById(id);
  }

  @Override
  public List<Board> retrieveAll() {
    return BoardDoc.toEntities(boardRepo.findAll());
  }

  @Override
  public Board retrieveById(String id) {
    return boardRepo.findById(id).orElseThrow().toEntity();
  }
}
