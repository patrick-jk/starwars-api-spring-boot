package me.dio.gof.repository;

import me.dio.gof.model.Fan;
import org.springframework.data.repository.CrudRepository;

public interface FanRepository extends CrudRepository<Fan, Long> {

}
