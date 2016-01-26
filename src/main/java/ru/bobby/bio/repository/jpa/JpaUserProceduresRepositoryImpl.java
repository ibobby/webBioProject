package ru.bobby.bio.repository.jpa;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.bobby.bio.model.User;
import ru.bobby.bio.model.UserProcedures;
import ru.bobby.bio.repository.UserProceduresRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by b.istomin on 18.11.2015.
 */
@Repository
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class JpaUserProceduresRepositoryImpl implements UserProceduresRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public UserProcedures save(UserProcedures userProcedure, int userId) {
        User ref = em.getReference(User.class, userId);
        userProcedure.setUser(ref);

        if (userProcedure.isNew()) {
            em.persist(userProcedure);
        } else {
            if (get(userProcedure.getId(), userId) == null) return null;
            em.merge(userProcedure);
        }
        return userProcedure;
    }

    @Override
    @Transactional
    public boolean delete(int id, int userId) {
        return em.createNamedQuery(UserProcedures.DELETE)
                .setParameter("id", id)
                .setParameter("userId", userId)
                .executeUpdate() != 0;
    }

    @Override
    @Transactional
    public void deleteAll(int userId) {
        em.createNamedQuery(UserProcedures.DELETE_ALL)
                .setParameter("userId", userId)
                .executeUpdate();
    }

    @Override
    public UserProcedures get(int id, int userId) {
        List<UserProcedures> userProcedures = em.createNamedQuery(UserProcedures.GET, UserProcedures.class)
                .setParameter("id", id)
                .setParameter("userId", userId)
                .getResultList();
        return userProcedures.size() == 0 ? null : DataAccessUtils.requiredSingleResult(userProcedures);
    }

    @Override
    public List<UserProcedures> getAll(int userId) {
        List<UserProcedures> userProcedures = em.createNamedQuery(UserProcedures.ALL_SORTED, UserProcedures.class)
                .setParameter("userId", userId)
                .getResultList();
        return userProcedures;
    }

    @Override
    public List<UserProcedures> getBetween(int userId, LocalDateTime startDate, LocalDateTime endDate) {
        List<UserProcedures> userProcedures = em.createNamedQuery(UserProcedures.GET_BETWEEN, UserProcedures.class)
                .setParameter("userId", userId)
                .setParameter("after", startDate)
                .setParameter("before", endDate)
                .getResultList();
        return userProcedures;
    }
}
