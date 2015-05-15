package ru.bobby.web.repository;

import ru.bobby.web.model.User;
import ru.bobby.web.model.UserProcedures;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by b.istomin on 14.05.2015.
 */
public interface UserProceduresRepository {

    UserProcedures save(UserProcedures userProcedure, int userId);

    boolean delete(int id, int userId);

    void deleteAll(int userId);

    UserProcedures get(int id, int userId);

    List<UserProcedures> getAll(int userId);

    List<UserProcedures> getBetween(int userId, LocalDateTime startDate, LocalDateTime endDate);

}
