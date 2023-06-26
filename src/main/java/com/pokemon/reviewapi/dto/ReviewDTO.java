package com.pokemon.reviewapi.dto;

import lombok.Data;

@Data
public class ReviewDTO {

    private Integer id;
    private String title;
    private String content;
    private int star;
}
