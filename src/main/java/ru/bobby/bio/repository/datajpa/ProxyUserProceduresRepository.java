package ru.bobby.bio.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.bobby.bio.model.UserProcedures;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by b.istomin on 31.01.2016.
 */
public interface ProxyUserProceduresRepository extends JpaRepository<UserProcedures, Integer> {

    @Transactional
    @Modifying
    @Query("delete from UserProcedures up where up.user.id=:userId and up.id=:id")
    int delete(@Param("id") int id, @Param("userId") int userId);

    @Transactional
    @Modifying
    @Query("delete from UserProcedures up where up.user.id=:userId")
    void deleteAll(@Param("userId") int userId);

    @Override
    @Transactional
    UserProcedures save(UserProcedures userProcedure);

    @Query("select up from UserProcedures up where up.id=:id and up.user.id=:userId")
    UserProcedures get(@Param("id") int id, @Param("userId") int userId);

    @Query("select up from UserProcedures up where up.user.id=:userId order by up.dateTime desc")
    List<UserProcedures> getAll(@Param("userId") int userId);

    @Query("select up from UserProcedures up where up.user.id=:userId and up.dateTime>=:after and up.dateTime<:before order by up.dateTime desc")
    List<UserProcedures> getBetween(@Param("userId") int userId, @Param("after") LocalDateTime startDate, @Param("before") LocalDateTime endDate);

}
