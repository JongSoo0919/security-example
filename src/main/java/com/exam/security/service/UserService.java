package com.exam.security.service;

import com.exam.security.dto.user.request.UserRequestDto;
import com.exam.security.entity.user.Users;
import com.exam.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;


    public Long register(UserRequestDto userRequestDto){
        userRepository.findByEmail(userRequestDto.getEmail())
                        .ifPresent((entity) -> {
                            throw new RuntimeException("중복된 회원입니다.");
                        });

        userRequestDto.setPassword(passwordEncoder.encode(userRequestDto.getPassword())); //TODO : passwordEncoder 가 어느 객체에 있어야 할 지 생각해보자.
        Users entity = Users.of(userRequestDto);

        userRepository.save(entity);

        return entity.getId();
    }
}
