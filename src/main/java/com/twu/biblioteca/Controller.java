package com.twu.biblioteca;

import com.twu.biblioteca.event.*;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Controller {

    private String CurrentInput = new String();
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
            this.CurrentInput = scanner.nextLine().trim();
        } catch (NoSuchElementException exception) {
            System.out.println("can't catch user Input");
        }
        return this;
    }

    public Event chooseNextEvent() {
        if (currentEvent instanceof MenuEvent) {
            return routerForMenu();

        } else return null;

    }

    private Event routerForMenu() {
        Event nextEvent = routerMapForMenu(currentEvent).get(CurrentInput);
        nextEvent = (nextEvent != null) ? nextEvent : new MenuEvent(currentEvent.getLibrary());
        return nextEvent;
    }

    private Map<String, Event> routerMapForMenu(Event currentEvent) {
        Library library = currentEvent.getLibrary();
        routerMapForMenu.clear();
        routerMapForMenu.put("1", new ListBookEvent(library));
        routerMapForMenu.put("2", new ReserveBookEvent(library));
        routerMapForMenu.put("3", new CheckMembershipEvent(library));
        routerMapForMenu.put("q", new QuitEvent());
        return routerMapForMenu;
    }

    public String returnInput() {
        return CurrentInput.trim();
    }

}
