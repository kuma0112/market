package com.sparta.market;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardFindAllResponseDto {
    private Long id;
    private String title;
    private int price;
    private String username;

    public BoardFindAllResponseDto (Board board){
        this.id = board.getId();
        this.title = board.getTitle();
        this.price = board.getPrice();
        this.username = board.getUsername();
    }
}
