package com.twu.biblioteca.message;

public class MenuMessage implements Message {

    @Override
    public String getMsg() {
        return "1). list books\n"
                + "2). reserve a book\n"
                + "3). check their membership details\n";
    }
}
