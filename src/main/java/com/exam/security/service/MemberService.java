package com.exam.security.service;

import com.exam.security.domain.Member;
import com.exam.security.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {
    private final MemberRepository memberRepository;

    public Optional<Member> findMemberById(String userId){
        return memberRepository.findByUserId(userId);
    }
}
