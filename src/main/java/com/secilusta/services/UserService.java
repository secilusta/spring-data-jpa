package com.secilusta.services;

import com.secilusta.entities.Address;
import com.secilusta.entities.User;
import com.secilusta.repositories.UserRepo;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo repo) {
        this.userRepo = repo;
    }

    public User findUserByName(String name){
        return userRepo.findByName(name);
    }

    public void userOperations() {
        User u = new User();
        u.setName("seciluser");

        Address address = new Address();
        address.setStreet("Gazo sokak");
        address.setNumber("7");
        address.setCity("Istanbul");

        u.setAddress(address);

        userRepo.save(u);

        System.out.println(userRepo.findAllByNameContainingIgnoreCase("se"));
    }
}
