package ru.bobby.web.repository.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import ru.bobby.web.model.UserProcedures;
import ru.bobby.web.repository.UserProceduresRepository;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by b.istomin on 22.06.2015.
 */
@Repository
public class JdbcUserProceduresRepositoryImpl implements UserProceduresRepository {

    private static final RowMapper<UserProcedures> ROW_MAPPER =
       (rs, rowNum) -> (new UserProcedures(rs.getInt("id"), rs.getTimestamp("datetime").toLocalDateTime(), rs.getString("description"), rs.getInt("scores")));


    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    SimpleJdbcInsert simpleJdbcInsert;

    @Autowired
    public JdbcUserProceduresRepositoryImpl(DataSource dataSource) {
        this.simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("PROCEDURES")
                .usingGeneratedKeyColumns("id");
    }

    @Override

    public UserProcedures save(UserProcedures userProcedure, int userId) {

        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("id", userProcedure.getId())
                .addValue("user_id", userId)
                .addValue("dateTime", Timestamp.valueOf(userProcedure.getDateTime()))
                .addValue("description", userProcedure.getDescription())
                .addValue("scores", userProcedure.getScores());

        if (userProcedure.isNew()) {
            Number newKey = simpleJdbcInsert.executeAndReturnKey(map);
            userProcedure.setId(newKey.intValue());
        } else {
            if (namedParameterJdbcTemplate.update(
                    "UPDATE procedures SET description=:description, scores=:scores, dateTime=:dateTime" +
                            " WHERE id=:id AND user_id=:user_id", map) == 0) {
                return null;
            }
            ;
        }

        return userProcedure;
    }

    @Override
    public boolean delete(int id, int userId) {
        return jdbcTemplate.update("DELETE FROM procedures WHERE id=? AND user_id=?", id, userId) != 0;
    }

    @Override
    public void deleteAll(int userId) {
        jdbcTemplate.update("DELETE FROM procedures WHERE user_id=?", userId);
    }

    @Override
    public UserProcedures get(int id, int userId) {
        List<UserProcedures> userProcedures = jdbcTemplate.query(
                "SELECT * FROM procedures WHERE id=? AND user_id=?", ROW_MAPPER, id, userId);
        return CollectionUtils.isEmpty(userProcedures) ? null : DataAccessUtils.requiredSingleResult(userProcedures);
    }

    @Override
    public List<UserProcedures> getAll(int userId) {
        return jdbcTemplate.query(
                "SELECT * FROM procedures WHERE user_id=? ORDER BY datetime DESC", ROW_MAPPER, userId);
    }

    @Override
    public List<UserProcedures> getBetween(int userId, LocalDateTime startDate, LocalDateTime endDate) {
        return jdbcTemplate.query(
                "SELECT * FROM procedures WHERE user_id = ? AND datetime >= ? AND datetime < ? ORDER BY datetime DESC",
                ROW_MAPPER, userId, Timestamp.valueOf(startDate), Timestamp.valueOf(endDate));
    }
}
