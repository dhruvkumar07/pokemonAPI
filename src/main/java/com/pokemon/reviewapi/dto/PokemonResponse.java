package com.pokemon.reviewapi.dto;

import lombok.Data;

import java.util.List;

@Data
public class PokemonResponse {

    public List<PokemonDTO> content;
    public int pageNo;
    public int pageSize;
    public long totalElements;
    public long totalPages;
    public boolean last;
}
