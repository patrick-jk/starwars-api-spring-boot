package me.dio.gof.service;

import me.dio.gof.model.Character;
import me.dio.gof.model.Film;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "sw-api", url = "https://swapi.dev/api")
public interface StarWarsApiService {

    @GetMapping(value = "/films/{id}/")
    Film findFilm(@PathVariable("id") int id);

    @GetMapping(value = "/people/{id}/")
    Character findCharacter(@PathVariable("id") int id);
}
