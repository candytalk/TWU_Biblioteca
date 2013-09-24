package com.twu.biblioteca;

import java.util.Scanner;

public class IOHandler {
    private String input;

    public IOHandler scanInput() {
        Scanner scanner = new Scanner(System.in);
        this.input = scanner.nextLine();
        return this;
    }

    public String returnInput() {
        return input.trim();
    }
}
