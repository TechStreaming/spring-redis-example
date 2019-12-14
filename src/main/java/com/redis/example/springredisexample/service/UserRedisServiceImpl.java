package com.redis.example.springredisexample.service;

import com.redis.example.springredisexample.model.User;
import com.redis.example.springredisexample.repository.UserRedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserRedisServiceImpl implements  UserRedisService {

    @Autowired
    private UserRedisRepository userRedisRepository;


    @Override
    public void add(User user) {
        userRedisRepository.save(user);
    }

    @Override
    public Map<String, User> findAll() {
        return userRedisRepository.findAll();
    }

    @Override
    public User findBy(String id) {
        return userRedisRepository.findBy(id);
    }

    @Override
    public void update(User user) {
        userRedisRepository.update(user);
    }

    @Override
    public void delete(String id) {
        userRedisRepository.delete(id);
    }
}
