package com.example.springboard.api.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Getter
@Setter
@ToString
@NoArgsConstructor
public class Login {

    @NotBlank(message = "이메일을 입력해주세요")
    private String email;

    @NotBlank(message = "비밀번호를 입력해주세요")
    private String password;

    @Builder
    public Login(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
