package com.sparta.market;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoardService {

    private final BoardRepository boardRepository;

    // 판매 게시글 작성
    public BoardResponseDto createBoard(BoardRequestDto requestDto) {
        Board board = boardRepository.save(new Board(requestDto));
        return new BoardResponseDto(board);
    }

    public BoardResponseDto getBoard(Long boardId) {
        Board findBoard = boardRepository.findById(boardId).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));
        return new BoardResponseDto(findBoard);
    }
}
