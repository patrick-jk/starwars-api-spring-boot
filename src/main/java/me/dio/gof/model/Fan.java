package me.dio.gof.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Fan {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String name;

    @OneToOne
    @JsonProperty("favorite_movie")
    private Film favoriteMovie;

    @OneToOne
    @JsonProperty("favorite_character")
    private Character favoriteCharacter;
}
