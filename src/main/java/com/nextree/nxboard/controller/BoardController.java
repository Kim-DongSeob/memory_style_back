package com.nextree.nxboard.controller;

import com.nextree.nxboard.domian.entity.Board;
import com.nextree.nxboard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/board")
public class BoardController {

    @Autowired
    public BoardService boardService;

    @PostMapping("/create-board")
    public void createBoard(@RequestBody Board board) {
        boardService.createBoard(board);
    }

    @PostMapping("/delete-board")
    public void deleteBoard(@RequestBody Board board) {
        boardService.deleteById(board.getId());
    }

    @PostMapping("/find-all-boards")
    public List<Board> findAll() {
        return boardService.findAll();
    }

    @PostMapping("/find-board")
    public Board findById(String id) {
        return boardService.findById(id);
    }
}
