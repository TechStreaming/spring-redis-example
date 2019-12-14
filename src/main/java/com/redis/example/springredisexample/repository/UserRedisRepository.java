package com.redis.example.springredisexample.repository;

import com.redis.example.springredisexample.model.User;

import java.util.Map;

public interface UserRedisRepository {

    String KEY = "USERS";

    void save(User  user);

    Map<String, User> findAll();

    User findBy(String id);

    void update(User user);

    void delete(String  id);
}
