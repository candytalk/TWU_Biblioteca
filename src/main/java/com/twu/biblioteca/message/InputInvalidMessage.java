package com.twu.biblioteca.message;

public class InputInvalidMessage implements Message {
    private String msg = "input invalid, please check";

    public InputInvalidMessage() {
    }

    public InputInvalidMessage(String msg) {

        this.msg = msg;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
