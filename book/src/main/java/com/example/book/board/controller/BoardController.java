package com.example.book.board.controller;

import com.example.book.board.Board;
import com.example.book.board.payload.BoardDto;
import com.example.book.board.payload.ViewDto;
import com.example.book.board.service.BoardCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BoardController {
    private final BoardCreateService boardCreateService;

    @PostMapping("/post")
    public ResponseEntity<Board> write(@RequestBody BoardDto boardDto){
        return ResponseEntity.ok(boardCreateService.savePost(boardDto));
    }

    @GetMapping("/show")
    public ResponseEntity<ViewDto> boardview() throws IOException {
        ViewDto viewDto=new ViewDto();
        viewDto.setBoardDtoList(boardCreateService.getBoardList());
        return ResponseEntity.ok(viewDto);
    }
}