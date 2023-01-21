package com.nextree.nxboard.controller;

import com.nextree.nxboard.domian.entity.Board;
import com.nextree.nxboard.domian.sdo.BoardCdo;
import com.nextree.nxboard.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/nx-board/board")
public class BoardController {

    @Autowired
    public BoardService boardService;

    @PostMapping("/register/command")
    public void createBoard(@RequestBody BoardCdo boardCdo) {
        if (boardCdo == null || boardCdo.getTitle() == null || boardCdo.getContent() == null) {
            throw new NullPointerException("There is empty value");
        }
        boardService.createBoard(boardCdo);
    }

    @PostMapping("/delete/command")
    public void deleteBoard(@RequestBody Board board) {
        boardService.deleteById(board.getId());
    }

    @PostMapping("/find-all/query")
    public List<Board> findAll() {
        return boardService.findAll();
    }

    @PostMapping("/find/query")
    public Board findById(String id) {
        return boardService.findById(id);
    }
}
