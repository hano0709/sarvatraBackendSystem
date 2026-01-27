package com.sarvatra.bankingSystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "acc_no", unique = true)
    private String accNo;

    @Column(name = "ifsc_no")
    private String ifscNo;

    public Login(){}

    public Login(String userName, String password, String name, String accNo, String ifscNo) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.accNo = accNo;
        this.ifscNo = ifscNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAcc_no() {
        return accNo;
    }

    public void setAcc_no(String accNo) {
        this.accNo = accNo;
    }

    public String getIfsc_no() {
        return ifscNo;
    }

    public void setIfsc_no(String ifscNo) {
        this.ifscNo = ifscNo;
    }
}
