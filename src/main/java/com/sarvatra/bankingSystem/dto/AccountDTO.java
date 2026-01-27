package com.sarvatra.bankingSystem.dto;

public class AccountDTO {

    private long acc_no;
    private String ifsc_no;

    public long getAcc_no() {
        return acc_no;
    }

    public void setAcc_no(long acc_no) {
        this.acc_no = acc_no;
    }

    public String getIfsc_no() {
        return ifsc_no;
    }

    public void setIfsc_no(String ifsc_no) {
        this.ifsc_no = ifsc_no;
    }
}
