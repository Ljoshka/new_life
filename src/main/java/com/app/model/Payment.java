package com.app.model;

public class Payment {
    //------------ATTRIBUTES------------
    private long id;
    private String giftCard;
    private String internetBank;
    private String creditCard;
    private String user;

    //---------GETTERS/SETTERS-----------

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGiftCard() {
        return giftCard;
    }

    public void setGiftCard(String giftCard) {
        this.giftCard = giftCard;
    }

    public String getInternetBank() {
        return internetBank;
    }

    public void setInternetBank(String internetBank) {
        this.internetBank = internetBank;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
