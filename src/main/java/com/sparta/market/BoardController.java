package com.sparta.market;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/post")
    public BoardResponseDto createBoard (@RequestBody BoardRequestDto requestDto){
        return boardService.createBoard(requestDto);
    }

    @GetMapping ("/post/{id}")
    public BoardResponseDto getBoard (@PathVariable ("id") Long boardId){
        return boardService.getBoard(boardId);
    }
}
