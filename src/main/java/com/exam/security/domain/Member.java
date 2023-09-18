package com.exam.security.domain;

import com.exam.security.dto.MemberJoinDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String userId;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String roles;
    private String name;
    private String email;
    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime regDate;

    @Builder
    public Member(Long id, String userId, String password, String roles, String name, String email, LocalDateTime regDate) {
        this.id = id;
        this.userId = userId;
        this.password = password;
        this.roles = roles;
        this.name = name;
        this.email = email;
        this.regDate = regDate;
    }

    public static Member of(MemberJoinDto dto){
        return Member.builder()
                .userId(dto.getUserId())
                .password(dto.getPassword())
                .email(dto.getEmail())
                .roles(dto.getRoles())
                .name(dto.getName())
                .build();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(id, member.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
