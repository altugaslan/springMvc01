package com.tpe.service;

import com.tpe.domain.Mission;
import com.tpe.repository.MissionRepository;
import com.tpe.exception.ResourcesNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MissionServiceImpl implements MissionService{

    @Autowired
    private MissionRepository missionRepository;
    @Override
    public void saveMission(Mission mission) {

        missionRepository.save(mission);
    }

    @Override
    public List<Mission> getAllMissions() {

        return missionRepository.getAll();
    }

    @Override
    public Mission findMissionWithId(Long id) {

        Mission mission=missionRepository.findById(id).orElseThrow(()->new ResourcesNotFoundException("Henuz bu gorev varolmadi!!"));
        return mission;
    }

    @Override
    public void deleteMission(Long id) {
        Mission mission=findMissionWithId(id);
        missionRepository.delete(mission.getId());

    }
}
