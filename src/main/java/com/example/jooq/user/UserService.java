package com.example.jooq.user;


import com.example.jooq.user.repository.UserJooqRepository;
import com.example.jooq.user.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserJpaRepository userJpaRepository;
    private final UserJooqRepository userJooqRepository;

    public List<User> getAllUser() {
        return userJooqRepository.getAllUser();
    }

    public void createUser(UserRequestDto.Signup signupDto) {
        if(userJpaRepository.existsByAccountId(signupDto.getAccountId()))
            throw new IllegalArgumentException("이미 존재하는 계정입니다.");

        User user = signupDto.toEntity();
        userJpaRepository.save(user);
    }

    public void login(UserRequestDto.Login loginDto) {
        User getUser = userJpaRepository.findByAccountId(loginDto.getAccountId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 계정입니다."));

        // 비밀번호 불일치
        if(!getUser.getPassword().equals(loginDto.getPassword()))
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
    }
}