package com.santos.jwtproject.adapters.outbound.persistence.mongo;

import com.santos.jwtproject.application.domain.User;
import com.santos.jwtproject.application.ports.UserRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Primary
@Repository
@RequiredArgsConstructor
public class UserRepository implements UserRepositoryPort {

    private final MongoTemplate database;

    @Override
    public User findByLogin(String login) {
        var query = query(where("login").is(login));
        return database.findOne(query, User.class);
    }

    @Override
    public User save(User user) {
        return database.save(user);
    }
}
