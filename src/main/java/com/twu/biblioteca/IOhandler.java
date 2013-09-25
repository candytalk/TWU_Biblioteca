package com.twu.biblioteca;

import com.twu.biblioteca.message.Message;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class IOHandler {
    private String input = new String();

    public IOHandler scanInput() {
        Scanner scanner = new Scanner(System.in);
        try {
            this.input = scanner.nextLine();
        } catch (NoSuchElementException exception) {
            System.out.println("can't catch user input");
        }
        return this;
    }

    public String returnInput() {
        return input.trim();
    }

    public void outputMessage(Message message) {
        System.out.println(message.getMsg());
    }
}
