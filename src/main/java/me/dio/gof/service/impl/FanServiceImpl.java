package me.dio.gof.service.impl;

import lombok.RequiredArgsConstructor;
import me.dio.gof.model.Character;
import me.dio.gof.model.Fan;
import me.dio.gof.model.Film;
import me.dio.gof.repository.CharacterRepository;
import me.dio.gof.repository.FanRepository;
import me.dio.gof.repository.FilmRepository;
import me.dio.gof.service.FanService;
import me.dio.gof.service.StarWarsApiService;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class FanServiceImpl implements FanService {
    private final StarWarsApiService starWarsApiService;
    private final FilmRepository filmRepository;
    private final FanRepository fanRepository;
    private final CharacterRepository characterRepository;

    @Override
    public Iterable<Fan> findAllFans() {
        return fanRepository.findAll();
    }

    @Override
    public Fan findById(Long id) {
        Optional<Fan> fan = fanRepository.findById(id);
        return fan.orElse(null);
    }

    @Override
    public void insertFan(Fan fan) {
        setupApiInfo(fan);
    }

    private void setupApiInfo(Fan fan) {
        requestFavoriteFilm(fan);
        requestFavoriteCharacter(fan);
        fanRepository.save(fan);
    }

    private void requestFavoriteCharacter(Fan fan) {
        long favoriteCharacter = fan.getFavoriteCharacter().getId();
        Character character = characterRepository.findById(favoriteCharacter).orElseGet(() -> {
            int urlId = fan.getFavoriteCharacter().getUrlId();
            Character newCharacter = starWarsApiService.findCharacter(urlId);
            characterRepository.save(newCharacter);
            return newCharacter;
        });
        fan.setFavoriteCharacter(character);
    }

    private void requestFavoriteFilm(Fan fan) {
        long favoriteMovie = fan.getFavoriteMovie().getId();
        Film film = filmRepository.findById(favoriteMovie).orElseGet(() -> {
            int urlId = fan.getFavoriteMovie().getUrlId();
            Film newFilm = starWarsApiService.findFilm(urlId);
            filmRepository.save(newFilm);
            return newFilm;
        });
        fan.setFavoriteMovie(film);
    }

    @Override
    public void updateFan(Long id, Fan fan) {
        Optional<Fan> fanDb = fanRepository.findById(id);
        if (fanDb.isPresent()) {
            setupApiInfo(fan);
        }
    }

    @Override
    public void deleteFan(Long id) {
        fanRepository.deleteById(id);
    }

}

