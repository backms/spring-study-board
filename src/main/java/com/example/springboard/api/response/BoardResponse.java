package com.example.springboard.api.response;

import com.example.springboard.api.domain.Board;
import lombok.Builder;
import lombok.Getter;

@Getter
public class BoardResponse {

    private final Long id;
    private final String title;
    private final String content;
    private final String writer;

    public BoardResponse(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.writer = board.getWriter();
    }

    @Builder
    public BoardResponse(Long id, String title, String content, String writer) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
    }
}
