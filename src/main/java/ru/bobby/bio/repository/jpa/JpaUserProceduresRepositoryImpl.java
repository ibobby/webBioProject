package ru.bobby.bio.repository.jpa;

import org.springframework.stereotype.Repository;
import ru.bobby.bio.model.UserProcedures;
import ru.bobby.bio.repository.UserProceduresRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by b.istomin on 18.11.2015.
 */
@Repository
public class JpaUserProceduresRepositoryImpl implements UserProceduresRepository {

    @Override
    public UserProcedures save(UserProcedures userProcedure, int userId) {
        return null;
    }

    @Override
    public boolean delete(int id, int userId) {
        return false;
    }

    @Override
    public void deleteAll(int userId) {

    }

    @Override
    public UserProcedures get(int id, int userId) {
        return null;
    }

    @Override
    public List<UserProcedures> getAll(int userId) {
        return null;
    }

    @Override
    public List<UserProcedures> getBetween(int userId, LocalDateTime startDate, LocalDateTime endDate) {
        return null;
    }
}
