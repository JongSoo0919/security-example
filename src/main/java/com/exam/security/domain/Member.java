package com.exam.security.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

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
    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime regDate;

    @Builder
    public Member(Long id, String userId, String password, String roles, LocalDateTime regDate) {
        this.id = id;
        this.userId = userId;
        this.password = password;
        this.roles = roles;
        this.regDate = regDate;
    }
}
