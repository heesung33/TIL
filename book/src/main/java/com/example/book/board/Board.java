package com.example.book.board;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String bookname;

    @Column(nullable = false)
    private String bookmaker;

    @Column(nullable = false)
    private String creater;

    @Builder
    public Board(String bookname, String bookmaker, String creater) {
        this.bookmaker = bookmaker;
        this.bookname = bookname;
        this.creater = creater;

    }


}
