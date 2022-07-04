package com.example.practice.domain.auth.domain;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Auth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accountId;

    private String password;

    private String name;

    @Enumerated(EnumType.STRING)
    private Role role;


    @Builder
    public Auth(String accountId, String password, String name, Role role) {
        this.accountId = accountId;
        this.password = password;
        this.name = name;
        this.role = role;
    }

}
