package com.example.myrestfulwebservice.service;

import com.example.myrestfulwebservice.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class UserService {

    private static List<User> repository = new ArrayList<>();

    private static Long countUser = 3L;

    static {
        repository.add(new User(1L, "lee", new Date()));
        repository.add(new User(2L, "sim", new Date()));
        repository.add(new User(3L, "kim", new Date()));
    }

    public User findOne(Long id) {
        for (User user : repository) {
            if (id == user.getId()) {
                return user;
            }
        }
        return null;
    }

    public List<User> findAll() {
        return repository;
    }


    public User save(User user) {
        if (user.getId() == null) {
            user.setId(++countUser);
        }
        repository.add(user);
        return user; // return User -> user 객체를 반환해줘야 확인 가능
    }


    public User deleteById(Long id) {
        Iterator<User> iterator = repository.iterator();

        while (iterator.hasNext()) {
            User user = iterator.next();
            if (id == user.getId()) {
                iterator.remove();
                return user;
            }
        }
        return null;
    }

}
