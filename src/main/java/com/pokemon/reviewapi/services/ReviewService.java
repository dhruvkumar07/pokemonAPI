package com.pokemon.reviewapi.services;

import com.pokemon.reviewapi.dto.ReviewDTO;
import com.pokemon.reviewapi.models.Review;

import java.util.List;

public interface ReviewService {

    ReviewDTO createReview(Integer id , ReviewDTO reviewDTO);

    List<ReviewDTO> getReviewsByPokemonId(Integer id);
}
