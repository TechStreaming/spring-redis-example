package com.redis.example.springredisexample.repository;

import com.redis.example.springredisexample.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class UserRedisRepositoryImpl implements UserRedisRepository {

    private RedisTemplate<String, User> redisTemplate;

    private HashOperations hashOperations;

    @Autowired
    public UserRedisRepositoryImpl(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(User user) {
        hashOperations.put(KEY, user.getId(), user);
    }

    @Override
    public Map<String, User> findAll() {
        return hashOperations.entries(KEY);
    }

    @Override
    public User findBy(String id) {
        return (User)hashOperations.get(KEY, id);
    }

    @Override
    public void update(User user) {
        save(user);
    }

    @Override
    public void delete(String id) {
        hashOperations.delete(KEY, id);

    }
}
