package com.tpe.service;

import com.tpe.domain.Mission;

import java.util.List;

public interface MissionService {
    void saveMission(Mission mission);

    List<Mission> getAllMissions();

    Mission findMissionWithId(Long id);

    void deleteMission(Long id);

}
