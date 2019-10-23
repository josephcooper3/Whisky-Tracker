package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;


import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class WhiskyRepositoryImpl implements WhiskyRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Whisky> findWhiskiesByDistilleryAndAge(String distilleryName, int whiskyAge) {
        List<Whisky> result = null;

        Session session = entityManager.unwrap(Session.class);

        try {
            Criteria criteria = session.createCriteria(Whisky.class);

            criteria.add(Restrictions.eq("age", whiskyAge));
            criteria.createAlias("distillery", "distilleryAlias");
            criteria.add(Restrictions.eq("distilleryAlias.name", distilleryName));

            result = criteria.list();

        } catch (HibernateException exception) {
            exception.printStackTrace();
        }

        return result;
    }

    public List<Whisky> findWhiskiesByRegion(String region) {
        List<Whisky> result = null;

        Session session = entityManager.unwrap(Session.class);

        try {
            Criteria criteria = session.createCriteria(Whisky.class);

            criteria.createAlias("distillery", "distilleryAlias");
            criteria.add(Restrictions.eq("distilleryAlias.region", region));

            result = criteria.list();

        } catch (HibernateException exception) {
            exception.printStackTrace();
        }

        return result;
    }

}
