package com.pokemon.reviewapi.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String type;

    @OneToMany(mappedBy = "pokemon" ,cascade = CascadeType.ALL ,orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();
}
