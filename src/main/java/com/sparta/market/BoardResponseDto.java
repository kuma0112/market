package com.sparta.market;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardResponseDto {
    private Long id;
    private String title;
    private String content;
    private int price;
    private String username;

    public BoardResponseDto (Board board){
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.price = board.getPrice();
        this.username = board.getUsername();
    }
}
