package com.nextree.nxboard.repo.mongo.doc;

import com.nextree.nxboard.domian.board.entity.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.stream.Collectors;

@Document("BOARD")
@Getter
@Setter
@NoArgsConstructor
public class BoardDoc {
  //
  private String id;
  private String title;
  private String content;
  private String registrationTime;
  private String modificationTime;
  private int likeCount;
  private int viewCount;

  public BoardDoc(Board board) {
    super();
    BeanUtils.copyProperties(board, this);
  }

  public Board toEntity() {
    Board board = new Board();
    BeanUtils.copyProperties(this, board);
    return board;
  }

  public static List<Board> toEntities(List<BoardDoc> boardDocs) {
    return boardDocs.stream().map(BoardDoc::toEntity).collect(Collectors.toList());
  }
}
