package com.sarvatra.bankingSystem.controller;

import com.sarvatra.bankingSystem.dao.UsersRepository;
import com.sarvatra.bankingSystem.entity.Login;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UsersRepository usersRepo;

    public AuthController(UsersRepository usersRepo) {
        this.usersRepo = usersRepo;
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Login req) {

        Map<String, Object> response = new HashMap<>();

        Login user = usersRepo.findByUserName(req.getUserName());

        if (user == null) {
            response.put("authenticated", false);
            response.put("message", "Invalid username");
            return response;
        }

        if (!user.getPassword().equals(req.getPassword())) {
            response.put("authenticated", false);
            response.put("message", "Invalid password");
            return response;
        }

        response.put("authenticated", true);
        response.put("message", "Authenticated");
        response.put("acc_no", user.getAcc_no());
        response.put("name", user.getName());
        response.put("ifsc_no", user.getIfsc_no());
        return response;
    }
}