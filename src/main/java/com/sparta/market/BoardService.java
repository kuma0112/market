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
        log.info(requestDto.getUsername());
        Board board = boardRepository.save(new Board(requestDto));
        log.info(board.getUsername());
        return new BoardResponseDto(board);
    }
}
