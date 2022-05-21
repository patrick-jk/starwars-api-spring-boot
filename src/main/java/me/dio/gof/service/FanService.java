package me.dio.gof.service;

import me.dio.gof.model.Fan;
import org.springframework.stereotype.Service;

@Service
public interface FanService {
    Iterable<Fan> findAllFans();

    Fan findById(Long id);

    void insertFan(Fan fan);

    void updateFan(Long id, Fan fan);

    void deleteFan(Long id);
}
