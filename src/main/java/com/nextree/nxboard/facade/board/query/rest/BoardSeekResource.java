package com.nextree.nxboard.facade.board.query.rest;

import com.nextree.nxboard.domian.entity.Board;
import com.nextree.nxboard.facade.board.query.query.FindBoardQuery;
import com.nextree.nxboard.service.BoardService;
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
