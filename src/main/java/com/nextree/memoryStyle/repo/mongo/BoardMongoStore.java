package com.nextree.memoryStyle.repo.mongo;

import com.nextree.memoryStyle.domian.board.entity.Board;
import com.nextree.memoryStyle.repo.BoardStore;
import com.nextree.memoryStyle.repo.mongo.doc.BoardDoc;
import com.nextree.memoryStyle.repo.mongo.repository.BoardRepo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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
    Optional<BoardDoc> boardDoc = boardRepo.findById(id);
    return boardDoc.map(BoardDoc::toEntity).orElse(null);
  }

  @Override
  public void increaseViewCount(Board board) {
    BoardDoc boardDoc = new BoardDoc(board);
    boardRepo.save(boardDoc);
  }

  @Override
  public void modifyBoard(Board board) {
    BoardDoc boardDoc = new BoardDoc(board);
    boardRepo.save(boardDoc);
  }

  @Override
  public void saveBoard(Board board) {
    BoardDoc boardDoc = new BoardDoc(board);
    boardRepo.save(boardDoc);
  }
}
