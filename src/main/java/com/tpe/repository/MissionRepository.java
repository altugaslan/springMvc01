package com.tpe.repository;

import com.tpe.domain.Mission;

import java.util.List;
import java.util.Optional;

public interface MissionRepository {

    void save(Mission mission);

    List<Mission> getAll();

    Optional<Mission> findById(Long id);

    void delete(Long id);


}
