package com.example.springboard.api.controller;

import com.example.springboard.api.request.BoardCreate;
import com.example.springboard.api.request.BoardEdit;
import com.example.springboard.api.response.BoardResponse;
import com.example.springboard.api.response.BoardSearch;
import com.example.springboard.api.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/board")
    public void write(@RequestBody @Valid BoardCreate boardCreate) {
        boardService.write(boardCreate);
    }

    @GetMapping("/board/{boardId}")
    public BoardResponse get(@PathVariable Long boardId){
        return boardService.get(boardId);
    }

    @GetMapping("/board")
    public List<BoardResponse> getList(@ModelAttribute BoardSearch boardSearch){
        return boardService.getList(boardSearch);
    }

    @PatchMapping("/board/{boardId}")
    public BoardResponse edit(@PathVariable long boardId, @RequestBody @Valid BoardEdit boardEdit){
        return boardService.edit(boardId, boardEdit);
    }

    @DeleteMapping("/board/{boardId}")
    public void delete(@PathVariable long boardId){
        boardService.delete(boardId);
    }

}
