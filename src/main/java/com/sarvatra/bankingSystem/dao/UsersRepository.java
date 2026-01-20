package com.sarvatra.bankingSystem.dao;

import com.sarvatra.bankingSystem.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Login, Integer> {

    Login findByUserName(String userName);
}
