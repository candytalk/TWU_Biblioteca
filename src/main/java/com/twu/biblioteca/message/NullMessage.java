package com.twu.biblioteca.message;

public class NullMessage implements Message{
    @Override
    public String getMsg() {
        return "";
    }

    @Override
    public void showMsg() {
        System.out.println(getMsg());
    }
}
