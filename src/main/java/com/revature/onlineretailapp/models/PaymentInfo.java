package com.revature.onlineretailapp.models;

public class PaymentInfo {
    String cardNum;
    String securityCode;

    public PaymentInfo(String cardNum, String securityCode) {
        this.cardNum = cardNum;
        this.securityCode = securityCode;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }
}
