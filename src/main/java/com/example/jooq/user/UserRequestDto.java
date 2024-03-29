package com.example.jooq.user;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class UserRequestDto {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Signup{

        @NotBlank(message = "아이디는 필수 입력 값입니다.")
        private String accountId;

        @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
        private String password;

        public User toEntity() {
            return new User(accountId, password);
        }
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Login{

        @NotBlank(message = "아이디는 필수 입력 값입니다.")
        private String accountId;

        @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
        private String password;
    }
}
