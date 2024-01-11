package com.sparta.market;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/post")
    public BoardResponseDto createBoard(@RequestBody BoardRequestDto requestDto) {
        return boardService.createBoard(requestDto);
    }

    @GetMapping("/post/{id}")
    public BoardResponseDto getBoard(@PathVariable("id") Long boardId) {
        return boardService.getBoard(boardId);
    }

    @GetMapping("/post")
    public List<BoardFindAllResponseDto> getAllBoard(){
        return boardService.getAllBoard();
    }

    @PutMapping("/post/{id}")
    public BoardResponseDto updateBoard(@PathVariable("id") Long boardId, @RequestBody BoardRequestDto requestDto){
        return boardService.updateBoard(boardId, requestDto);
    }
}
