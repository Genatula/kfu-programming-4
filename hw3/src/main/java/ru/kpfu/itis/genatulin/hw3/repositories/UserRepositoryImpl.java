package ru.kpfu.itis.genatulin.hw3.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.genatulin.hw3.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import javax.sql.DataSource;
import java.util.List;
@Repository
public class UserRepositoryImpl implements UserRepository {
    private static final String GET_BY_ID_QUERY = "select * from user where id = ?";
    private static final String GET_BY_EMAIL_QUERY = "select * from user where email = ?";
    private static final String GET_BY_USERNAME_QUERY = "select * from user where username = ?";
    private static final String DELETE_BY_ID_QUERY = "delete from user where id = ?";

    @PersistenceContext
    private final EntityManager entityManager;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepositoryImpl(EntityManager entityManager, DataSource dataSource) {
        this.entityManager = entityManager;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getById(Long id) {
        return jdbcTemplate.queryForObject(GET_BY_ID_QUERY, new UserRowMapper(), id);
    }

    @Override
    public List<User> getByEmail(String email) {
        return jdbcTemplate.query(GET_BY_EMAIL_QUERY, new UserRowMapper(), email);
    }

    @Override
    public List<User> getByUsername(String username) {
        return jdbcTemplate.query(GET_BY_USERNAME_QUERY, new UserRowMapper(), username);
    }

    @Override
    public void deleteById(Long id) {
        jdbcTemplate.update(DELETE_BY_ID_QUERY, id);
    }

    @Override
    public void updateEmail(Long id, String email) {
        Query query = entityManager.createQuery("update User u set u.email = :email where u.id = :id", User.class);
        query.setParameter("email", email);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public void updateUsername(Long id, String username) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaUpdate<User> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(User.class);
        Root<User> user = criteriaUpdate.from(User.class);
        criteriaUpdate
                .set("username", username)
                .where(criteriaBuilder.equal(user.get("id"), id));
        entityManager.createQuery(criteriaUpdate).executeUpdate();
    }
}
