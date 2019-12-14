package com.redis.example.springredisexample.action;

import com.redis.example.springredisexample.model.User;
import com.redis.example.springredisexample.service.UserRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/redis/user")
public class UserRedisAction {

    @Autowired
    private UserRedisService userRedisService;

    @GetMapping("/add/{id}/{name}")
    public User addUser(@PathVariable(name = "id") final String id,
                        @PathVariable(name = "name") final  String name){
        userRedisService.add(new User(id, name, 25000));
        return userRedisService.findBy(id);
    }

    @PostMapping(value="/create",headers="Accept=application/json")
    public User addUser(@RequestBody User user){
        userRedisService.add(user);
        return userRedisService.findBy(user.getId());
    }
    @GetMapping("/all")
    public Map<String , User> allUsers(){
        return userRedisService.findAll();
    }

    @GetMapping("/get/{id}")
    public User findUser(@PathVariable(name = "id") final String id){
        return userRedisService.findBy(id);
    }

    @GetMapping("/update/{id}/{name}")
    public User updateUser(@PathVariable(name = "id") final String id,
                        @PathVariable(name = "name") final  String name){
        userRedisService.update(new User(id, name, 25000));
        return userRedisService.findBy(id);
    }

    @PostMapping("/update")
    public User update(@RequestBody User user){
        userRedisService.update(user);
        return userRedisService.findBy(user.getId());

    }
    @GetMapping("/delete/{id}")
    public void deleteUser(@PathVariable(name = "id") final String id){
         userRedisService.delete(id);
    }
}
