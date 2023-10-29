package com.tpe.repository;

import com.tpe.domain.Mission;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class MissionRepositoryImpl implements MissionRepository{

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void save(Mission mission) {
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();

        session.saveOrUpdate(mission);

        transaction.commit();
        session.close();
    }

    @Override
    public List<Mission> getAll() {

        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();

        List<Mission>missionList= session.createQuery("from Mission",Mission.class).getResultList();

        transaction.commit();
        session.close();
        return missionList;
    }

    @Override
    public Optional<Mission> findById(Long id) {
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();

        Mission mission=session.get(Mission.class,id);
        Optional<Mission>optionalMission=Optional.ofNullable(mission);


        transaction.commit();
        session.close();
        return optionalMission;
    }

    @Override
    public void delete(Long id) {
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();

        Mission mission=session.load(Mission.class,id);
        session.delete(mission);

        transaction.commit();
        session.close();

    }
}
