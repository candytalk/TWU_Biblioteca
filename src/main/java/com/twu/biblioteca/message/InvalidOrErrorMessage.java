package com.twu.biblioteca.message;

public class InvalidOrErrorMessage implements Message {
    private String msg = "input invalid or some error happen, please check";

    public InvalidOrErrorMessage() {
    }

    public InvalidOrErrorMessage(String msg) {

        this.msg = msg;
    }

    @Override
    public void showMsg() {
        System.out.println(getMsg());
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
