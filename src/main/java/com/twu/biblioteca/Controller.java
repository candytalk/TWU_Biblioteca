package com.twu.biblioteca;

import com.twu.biblioteca.event.*;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Controller {

    private String currentInput = new String();
    private Event currentEvent;
    private Map<String, Event> routerMapForMenu = new HashMap<String, Event>();

    public Controller() {
    }

    ;

    public Controller(Event currentEvent) {
        this.currentEvent = currentEvent;
    }

    public Controller scanInput() {
        Scanner scanner = new Scanner(System.in);
        try {
            this.currentInput = scanner.nextLine().trim();
        } catch (NoSuchElementException exception) {
            System.out.println("can't catch user Input");
        }
        return this;
    }

    public Event chooseNextEvent() {
        if (currentEvent instanceof MenuEvent) {
            return routerForMenu(currentInput);

        } else return null;

    }

    private Event routerForMenu(String currentInput) {
        routerMapForMenu.clear();
        routerMapForMenu.put("1", new ListBookEvent());
        routerMapForMenu.put("2", new ReserveBookEvent());
        routerMapForMenu.put("3", new CheckMembershipEvent());
        routerMapForMenu.put("q", new QuitEvent());
        Event nextEvent = routerMapForMenu.get(currentInput);
        nextEvent = (nextEvent != null) ? nextEvent : new MenuEvent();
        return nextEvent;
    }

    public String returnInput() {
        return currentInput.trim();
    }

}
