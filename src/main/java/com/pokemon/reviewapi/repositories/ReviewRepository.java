package com.pokemon.reviewapi.repositories;

import com.pokemon.reviewapi.dto.ReviewDTO;
import com.pokemon.reviewapi.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review , Integer> {

    List<Review> findByPokemonId(Integer id);
}
