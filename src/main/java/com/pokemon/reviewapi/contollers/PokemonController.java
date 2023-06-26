package com.pokemon.reviewapi.contollers;

import com.pokemon.reviewapi.dto.PokemonDTO;
import com.pokemon.reviewapi.dto.PokemonResponse;
import com.pokemon.reviewapi.services.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class PokemonController {

    private final PokemonService pokemonService;
    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("pokemon")
    public ResponseEntity<PokemonResponse> getPokemon(
            @RequestParam(value = "pageNo" , required = false , defaultValue = "0") int pageNo ,
            @RequestParam(value = "pageSize" , required = false , defaultValue = "10") int pageSize
    ){
        return new ResponseEntity<>(pokemonService.getAllPokemon(pageNo,pageSize) , HttpStatus.OK);
    }

    @PostMapping("pokemon/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PokemonDTO> createPokemon(@RequestBody PokemonDTO pokemonDTO){
        PokemonDTO pokemonDTO1 = pokemonService.createPokemon(pokemonDTO);
        return new ResponseEntity<>(pokemonDTO1 , HttpStatus.CREATED);
    }

    @GetMapping("pokemon/{id}")
    public ResponseEntity<PokemonDTO> getPokemonById(@PathVariable Integer id){
        PokemonDTO pokemonDTO = pokemonService.getPokemonById(id);
        return new ResponseEntity<>(pokemonDTO , HttpStatus.OK);
    }

    @PutMapping("pokemon/{id}/update")
    public ResponseEntity<PokemonDTO> updatePokemon(@RequestBody PokemonDTO pokemonDTO , @PathVariable Integer id){
        return new ResponseEntity<>(pokemonService.updatePokemon(pokemonDTO , id) , HttpStatus.OK);
    }

    @GetMapping("pokemon/{id}/delete")
    public ResponseEntity<String> deletePokemon(@PathVariable Integer id){
        pokemonService.deletePokemon(id);
        return new ResponseEntity<>("Pokemon Deleted" , HttpStatus.OK);
    }
}
