package com.pokemon.reviewapi.repositories;

import com.pokemon.reviewapi.models.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon , Integer> {
}
