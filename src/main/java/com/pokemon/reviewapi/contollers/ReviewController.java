package com.pokemon.reviewapi.contollers;

import com.pokemon.reviewapi.dto.ReviewDTO;
import com.pokemon.reviewapi.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class ReviewController {
    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("pokemon/{pokemonId}/createReview")
    public ResponseEntity<ReviewDTO> createReview(@PathVariable(value = "pokemonId") Integer pokemonId,
                                                  @RequestBody ReviewDTO reviewDTO){
        return new ResponseEntity<>(reviewService.createReview(pokemonId, reviewDTO) , HttpStatus.CREATED);
    }

    @GetMapping("pokemon/{id}/reviews")
    public List<ReviewDTO> pokemonReview(@PathVariable Integer id){
        return reviewService.getReviewsByPokemonId(id);
    }
}
