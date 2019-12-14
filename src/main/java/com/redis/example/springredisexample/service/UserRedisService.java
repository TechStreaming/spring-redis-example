package com.redis.example.springredisexample.service;

import com.redis.example.springredisexample.model.User;

import java.util.Map;

public interface UserRedisService {


    void add(User user);

    Map<String, User> findAll();

    User findBy(String id);

    void update(User user);

    void delete(String  id);
}
