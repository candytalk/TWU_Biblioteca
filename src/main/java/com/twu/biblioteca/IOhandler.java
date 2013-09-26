package com.twu.biblioteca;

import com.twu.biblioteca.event.*;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class IOHandler {
    private String input = new String();
    private Event event;

    public IOHandler() {
    };

    public IOHandler(Event event) {
        this.event = event;
    }

    public IOHandler scanInput() {
        Scanner scanner = new Scanner(System.in);
        try {
            this.input = scanner.nextLine().trim();
        } catch (NoSuchElementException exception) {
            System.out.println("can't catch user input");
        }
        return this;
    }

    public Event handleOptionRouter() {
        if (event instanceof MenuEvent) {
            return handleOptionRouterInMenuEvent();

        } else return event;

    }

    private Event handleOptionRouterInMenuEvent() {

        Event nextEvent;
        if (input.equals("1")) {
            nextEvent = new ListBookEvent(event.getLibrary());
        } else if (input.equals("2")) {
            nextEvent = new ReserveBookEvent(event.getLibrary());
        } else if (input.equals("3")) {
            nextEvent = new CheckMembershipEvent(event.getLibrary());
        } else if (input.equals("q")) {
            nextEvent = new QuitEvent();
        } else {
            nextEvent = event;
        }
        return nextEvent;
    }

    public String returnInput() {
        return input.trim();
    }

}
