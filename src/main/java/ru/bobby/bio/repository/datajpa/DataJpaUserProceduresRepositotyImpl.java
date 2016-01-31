package ru.bobby.bio.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bobby.bio.model.User;
import ru.bobby.bio.model.UserProcedures;
import ru.bobby.bio.repository.UserProceduresRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by b.istomin on 31.01.2016.
 */
@Repository
public class DataJpaUserProceduresRepositotyImpl implements UserProceduresRepository {

    @Autowired
    private ProxyUserProceduresRepository proxy;

    @Autowired
    private ProxyUserRepository userProxy;

    @Override
    public UserProcedures save(UserProcedures userProcedure, int userId) {

        User currentUser = userProxy.getOne(userId);
        userProcedure.setUser(currentUser);

        if (!userProcedure.isNew() && get(userProcedure.getId(), userId) == null) {
            return null;
        }

        return proxy.save(userProcedure);
    }

    @Override
    public boolean delete(int id, int userId) {
        return proxy.delete(id, userId) != 0;
    }

    @Override
    public void deleteAll(int userId) {
        proxy.deleteAll(userId);
    }

    @Override
    public UserProcedures get(int id, int userId) {
        return proxy.get(id, userId);
    }

    @Override
    public List<UserProcedures> getAll(int userId) {
        return proxy.getAll(userId);
    }

    @Override
    public List<UserProcedures> getBetween(int userId, LocalDateTime startDate, LocalDateTime endDate) {
        return proxy.getBetween(userId, startDate, endDate);
    }
}
