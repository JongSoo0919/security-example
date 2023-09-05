package com.exam.security.entity.user;

import com.exam.security.dto.user.request.UserRequestDto;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    @CreatedDate
    private LocalDateTime regDate;

    @Builder
    public UserEntity(Long id, String email, String password, String name, LocalDateTime regDate) {
        isEmail(email);
        isPassword(password);

        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.regDate = regDate;
    }

    public static UserEntity of(UserRequestDto userRequestDto){
        isEmail(userRequestDto.getEmail());
        isPassword(userRequestDto.getPassword());

        return UserEntity.builder()
                .email(userRequestDto.getEmail())
                .password(userRequestDto.getPassword())
                .name(userRequestDto.getName())
                .build();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    private static void isPassword(String password){
        //TODO : 비밀번호는 4 ~ 12자사이이며, 대소문자, 특수문자를 포함해야 한다.
    }

    private static void isEmail(String email){
        //TODO : 이메일 형식에 알맞아야한다.
    }
}
