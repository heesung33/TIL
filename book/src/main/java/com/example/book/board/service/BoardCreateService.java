package com.example.book.board.service;

import com.example.book.board.Board;
import com.example.book.board.payload.BoardDto;
import com.example.book.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardCreateService {
    private final BoardRepository boardRepository;

    @Transactional
    public Board savePost(BoardDto boardDto) {
        return boardRepository.save(boardDto.toEntity());
    }
    @Transactional
    public List<BoardDto> getBoardList() throws IOException {
        List<Board> boardList = boardRepository.findAll();
        List<BoardDto> boardDtoList = new ArrayList<>();


        for(Board board : boardList) {


            BoardDto boardDto = BoardDto.builder()
                    .bookmaker(board.getBookmaker())
                    .bookname(board.getBookname())
                    .creater(board.getCreater())
                    .build();
            boardDtoList.add(boardDto);
        }
        return boardDtoList;
    }
}
