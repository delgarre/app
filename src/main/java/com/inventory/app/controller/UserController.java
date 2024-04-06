package com.inventory.app.controller;

import com.inventory.app.db.UserRepository;
import com.inventory.app.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    private SessionFactory factory;

    public UserController(SessionFactory factory) {
        this.factory = factory;
    }

    @GetMapping(produces = "application/json")
    @RequestMapping({ "/validateLogin" })
    public User validateLogin() {
        return new User("User successfully authenticated");
    }

    @GetMapping("/get")
    public List<User> getUsers() {
        return userRepository.findAll();
    }


    @PostMapping("/add")
    public void createUser(@RequestBody User user) {
        userRepository.save(user);
    }

    @DeleteMapping(path = { "/{id}" })
    public User deleteUser(@PathVariable("id") long id) {
        User user = userRepository.getById(id);
        userRepository.deleteById(id);
        return user;
    }

    @GetMapping("/login")
    public User getLogin(String email, String password) {


        User user = null;
        try {
            String query="from User where email =: e and password =: p";
            Session session = this.factory.openSession();
            Query q= session.createQuery(query);
            q.setParameter("e", email);
            q.setParameter("p", password);
            user =(User) q.uniqueResult();

            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        return user;
    }

    @PutMapping("/update")
    public void updateUser(@RequestBody User user) {
        userRepository.save(user);
    }

}

