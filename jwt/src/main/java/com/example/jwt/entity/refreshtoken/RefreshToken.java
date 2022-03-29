package com.example.jwt.entity.refreshtoken;


import lombok.*;
import org.springframework.stereotype.Indexed;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;


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
