package com.example.jwt.entity.refreshtoken;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;


@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class RefreshToken {

    @Id
    private String username;

    private String refreshToken;

    private Long refreshExpiration;

    public RefreshToken update(Long refreshExp) {
        this.refreshExpiration = refreshExp;
        return this;
    }
}
