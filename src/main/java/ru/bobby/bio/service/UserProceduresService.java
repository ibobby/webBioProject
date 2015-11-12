package ru.bobby.bio.service;

import ru.bobby.bio.model.UserProcedures;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by b.istomin on 15.05.2015.
 */
public interface UserProceduresService {

    public UserProcedures save(UserProcedures userProcedure, int userId);

    public UserProcedures update(UserProcedures userProcedure, int userId);

    public void delete(int id, int userId);

    public void deleteAll(int userId);

    public UserProcedures get(int id, int userId);

    public List<UserProcedures> getAll(int userId);

    public List<UserProcedures> getBetween(int userId, LocalDateTime startDate, LocalDateTime endDate);

}
