package com.exam.security.service;

import com.exam.security.domain.Member;
import com.exam.security.dto.MemberJoinDto;
import com.exam.security.exception.login.ErrorCode;
import com.exam.security.exception.login.IdDuplicateException;
import com.exam.security.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {
    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Optional<Member> findMemberById(String userId){
        return memberRepository.findByUserId(userId);
    }

    public Long join(MemberJoinDto dto){
        findMemberById(dto.getUserId())
                .ifPresent(member -> {throw new IdDuplicateException("이미 존재하는 회원입니다.", ErrorCode.ID_DUPLICATE);});

        dto.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
        dto.setRoles("user"); // admin / user 나누기 전까지 임시 하드코딩

        Member member = memberRepository.save(Member.of(dto));

        return member.getId();
    }
}
