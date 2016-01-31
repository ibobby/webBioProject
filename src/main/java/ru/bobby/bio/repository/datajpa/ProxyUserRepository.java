package ru.bobby.bio.repository.datajpa;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.bobby.bio.model.User;

import java.util.List;

/**
 * Created by b.istomin on 30.01.2016.
 */
public interface ProxyUserRepository extends JpaRepository<User, Integer> {

    @Transactional
    @Modifying
    @Query("delete from User u where u.id=:id")
    int delete(@Param("id") int id);

    @Override
    @Transactional
    User save(User user);

    @Override
    User findOne(Integer id);

    @Override
    List<User> findAll(Sort sort);

    User getByEmail(String email);

}
