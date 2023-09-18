package com.exam.security.config;

import com.exam.security.domain.Member;
import com.exam.security.exception.login.ErrorCode;
import com.exam.security.exception.login.IdDuplicateException;
import com.exam.security.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
    private final MemberService memberService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberService.findMemberById(username)
                .orElseThrow(() -> new IdDuplicateException("존재하지 않는 회원입니다.", ErrorCode.ID_DUPLICATE));

        return User.builder()
                .username(member.getUserId())
                .password(member.getPassword())
                .roles(member.getRoles())
                .build();
    }


}
