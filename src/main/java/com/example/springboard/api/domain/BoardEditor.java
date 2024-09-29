package com.example.springboard.api.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class BoardEditor {

    private final String title;
    private final String writer;
    private final String content;

    @Builder
    public BoardEditor(String title, String writer, String content) {
        this.title = title;
        this.writer = writer;
        this.content = content;
    }

}
