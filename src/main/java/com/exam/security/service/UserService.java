package com.exam.security.service;

import com.exam.security.dto.user.request.UserRequestDto;
import com.exam.security.entity.user.Users;
import com.exam.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByEmail(username)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 회원입니다."));

        return User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .roles("ROLE_MEMBER")
                .build();
    }

    public void validUser(UserRequestDto userRequestDto) {
        UserDetails userDetails = loadUserByUsername(userRequestDto.getEmail());
        if(!passwordEncoder.matches(userRequestDto.getPassword(), userDetails.getPassword())){
            throw new RuntimeException("패스워드가 일치하지 않습니다.");
        }

    }
}
