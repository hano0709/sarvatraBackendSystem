package com.sarvatra.bankingSystem.controller;

import com.sarvatra.bankingSystem.dao.UsersRepository;
import com.sarvatra.bankingSystem.dto.CBSRequest;
import com.sarvatra.bankingSystem.entity.Login;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/cbs")
public class CBSController {

    private final UsersRepository usersRepository;

    public CBSController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @PostMapping("/validate")
    public Map<String, Object> validateAccounts(@RequestBody CBSRequest request){
        Map<String, Object> response = new HashMap<>();

        Login payer = usersRepository.findByAccNo(request.getPayer().getAcc_no());

        if (payer == null){
            response.put("transaction", "invalid");
            response.put("reason", "payer not found");
            return response;
        }

        if(!payer.getIfsc_no().equals(request.getPayer().getIfsc_no())){
            response.put("transaction", "invalid");
            response.put("reason", "Payer IFSC mismatch");
            return response;
        }

        Login payee = usersRepository.findByAccNo(request.getPayee().getAcc_no());

        if (payee == null) {
            response.put("transaction", "invalid");
            response.put("reason", "Payee account not found");
            return response;
        }

        if (!payee.getIfsc_no().equals(request.getPayee().getIfsc_no())) {
            response.put("transaction", "invalid");
            response.put("reason", "Payee IFSC mismatch");
            return response;
        }

        response.put("transaction", "valid");
        return response;
    }
}
