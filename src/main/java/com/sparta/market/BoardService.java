package com.sparta.market;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<BoardFindAllResponseDto> getAllBoard() {
        List<Board> boardList = boardRepository.findAll();

        return boardList.stream()
                .map(BoardFindAllResponseDto::new)
                .collect(Collectors.toList());
    }

    public BoardResponseDto updateBoard(Long boardId, BoardRequestDto requestDto) {
        Board board = boardRepository.findById(boardId).orElseThrow(
                ()-> new IllegalArgumentException("해당 게시글을 찾을 수 없습니다."));

        Board updatedBoard = board.update(requestDto);
        return new BoardResponseDto(updatedBoard);
    }
}
