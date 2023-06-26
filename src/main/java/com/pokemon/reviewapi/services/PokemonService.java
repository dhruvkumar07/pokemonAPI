package com.pokemon.reviewapi.services;


import com.pokemon.reviewapi.dto.PokemonDTO;
import com.pokemon.reviewapi.dto.PokemonResponse;


public interface PokemonService {

    PokemonDTO createPokemon(PokemonDTO pokemonDTO);

    PokemonResponse getAllPokemon(int pageNo , int pageSize);

    PokemonDTO getPokemonById(Integer id);

    PokemonDTO updatePokemon(PokemonDTO pokemonDTO , Integer id);

    void deletePokemon(Integer id);
}
