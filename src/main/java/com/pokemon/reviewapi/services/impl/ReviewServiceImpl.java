package com.pokemon.reviewapi.services.impl;

import com.pokemon.reviewapi.dto.ReviewDTO;
import com.pokemon.reviewapi.models.Pokemon;
import com.pokemon.reviewapi.models.Review;
import com.pokemon.reviewapi.repositories.PokemonRepository;
import com.pokemon.reviewapi.repositories.ReviewRepository;
import com.pokemon.reviewapi.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final PokemonRepository pokemonRepository;
    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository, PokemonRepository pokemonRepository) {
        this.reviewRepository = reviewRepository;
        this.pokemonRepository = pokemonRepository;
    }

    @Override
    public ReviewDTO createReview(Integer id, ReviewDTO reviewDTO) {
        Pokemon pokemon = pokemonRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND));

        Review review = mapToEntity(reviewDTO);
        review.setPokemon(pokemon);
        Review review1 = reviewRepository.save(review);

        return mapToDTO(review);
    }

    @Override
    public List<ReviewDTO> getReviewsByPokemonId(Integer id) {
        List<Review> reviews = reviewRepository.findByPokemonId(id);
        return reviews.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    private ReviewDTO mapToDTO(Review review){
        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setId(review.getId());
        reviewDTO.setContent(review.getContent());
        reviewDTO.setTitle(review.getTitle());
        reviewDTO.setStar(review.getStar());

        return reviewDTO;
    }

    private Review mapToEntity(ReviewDTO reviewDTO){
        Review review = new Review();
        review.setContent(reviewDTO.getContent());
        review.setTitle(reviewDTO.getTitle());
        review.setStar(reviewDTO.getStar());

        return review;
    }
}
