package com.example.book.board.payload;

import com.example.book.board.Board;
import lombok.*;

@Getter
@ToString
@Setter
@NoArgsConstructor
public class BoardDto {
    private String bookmaker;
    private String bookname;
    private String creater;


    public Board toEntity() {
        return Board.builder()
                .bookmaker(bookmaker)
                .bookname(bookname)
                .creater(creater)
                .build();
    }

    @Builder
    public BoardDto(String bookname, String bookmaker, String creater) {
        this.bookmaker = bookmaker;
        this.bookname = bookname;
        this.creater = creater;
    }
}
