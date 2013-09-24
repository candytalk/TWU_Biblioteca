package com.twu.biblioteca.message;

public class InputInvalidMessage implements Message{
    private String msg = "input invalid, please check";

    @Override
    public String getMsg() {
        return msg;
    }
}
