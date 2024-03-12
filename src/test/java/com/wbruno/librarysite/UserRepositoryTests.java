package com.wbruno.librarysite;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;
import com.wbruno.librarysite.Repository.UserRepository;
import com.wbruno.librarysite.Model.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
//@Rollback(false)
public class UserRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository repo;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setEmail("williamgbruno1@gmail.com");
        user.setPassword("Password");
        user.setFirstName("William");
        user.setLastName("Bruno");

        User savedUser = repo.save(user);

        User existUser = entityManager.find(User.class, savedUser.getId());

        assertThat(user.getEmail()).isEqualTo(existUser.getEmail());
    }
/*
    @AfterEach
    public void execute() {
        jdbcTemplate.execute("TRUNCATE TABLE users" );
        jdbcTemplate.execute("ALTER SEQUENCE users_id_seq RESTART");
    }*/

}