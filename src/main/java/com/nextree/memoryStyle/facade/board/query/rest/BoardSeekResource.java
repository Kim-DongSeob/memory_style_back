package com.nextree.memoryStyle.facade.board.query.rest;

import com.nextree.memoryStyle.domian.board.entity.Board;
import com.nextree.memoryStyle.facade.board.query.query.FindBoardQuery;
import com.nextree.memoryStyle.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nx-board/board")
public class BoardSeekResource {

    @Autowired
    public BoardService boardService;

    @PostMapping("/find-all/query")
    public List<Board> findBoards() {
        return boardService.findAll();
    }

    @PostMapping("/find/query")
    public Board findBoard(@RequestBody FindBoardQuery query) {
        String boardId = query.getBoardId();
        return boardService.findById(boardId);
    }
}
