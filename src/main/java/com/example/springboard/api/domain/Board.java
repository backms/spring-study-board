package com.example.springboard.api.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Lob
    private String content;

    private String writer;

    @Builder
    public Board(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

    public BoardEditor.BoardEditorBuilder toEditor() {
        return BoardEditor.builder()
                .title(title)
                .content(content)
                .writer(writer);
    }

    public void edit(BoardEditor boardEditor) {
        title = boardEditor.getTitle();
        content = boardEditor.getContent();
        writer = boardEditor.getWriter();
    }

}
