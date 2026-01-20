package com.sarvatra.bankingSystem.controller;

import com.sarvatra.bankingSystem.dao.UsersRepository;
import com.sarvatra.bankingSystem.entity.Login;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final UsersRepository usersRepo;

    public UsersController(UsersRepository usersRepo) {
        this.usersRepo = usersRepo;
    }

    @PostMapping
    public Login createUser(@RequestBody Login user) {
        return usersRepo.save(user);
    }
}