package com.twu.biblioteca.message;

public class TipMessage implements Message {
    private String tip;

    public TipMessage(String tip) {
        this.tip = tip;
    }

    @Override
    public String getMsg() {
        return tip;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
