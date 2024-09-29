package com.example.springboard.api.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class BoardEdit {

    @NotBlank(message = "제목을 입력해주세요.")
    private String title;

    @NotBlank(message = "내용을 입력해주세요.")
    private String content;

    @NotBlank(message = "작성자를 입력해주세요.")
    private String writer;

    @Builder
    public BoardEdit(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

}
