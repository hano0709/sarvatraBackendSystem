package com.sarvatra.bankingSystem.dto;

public class CBSRequest {

    private AccountDTO payer;
    private AccountDTO payee;

    public AccountDTO getPayer() {
        return payer;
    }

    public void setPayer(AccountDTO payer) {
        this.payer = payer;
    }

    public AccountDTO getPayee() {
        return payee;
    }

    public void setPayee(AccountDTO payee) {
        this.payee = payee;
    }
}
