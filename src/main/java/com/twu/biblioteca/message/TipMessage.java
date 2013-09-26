package com.twu.biblioteca.message;

public class TipMessage implements Message {
    private String tip;

    public TipMessage(String tip) {
        this.tip = tip;
    }

    @Override
    public String getMsg() {
        return tip;
    }

    @Override
    public void showMsg() {
        System.out.println(getMsg());
    }
}
