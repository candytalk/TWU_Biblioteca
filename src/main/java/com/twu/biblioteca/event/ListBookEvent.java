package com.twu.biblioteca.event;

import com.twu.biblioteca.IOHandler;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.message.InputInvalidMessage;
import com.twu.biblioteca.message.Message;
import com.twu.biblioteca.message.TipMessage;

import java.util.Iterator;
import java.util.Map;

public class ListBookEvent implements Event {
    private Library library;
    private IOHandler ioHandler = new IOHandler();
    private Event nextEvent;
    private InputInvalidMessage messageAfterExecute;

    public void setLibrary(Library library) {
        this.library = library;
    }

    @Override
    public Message messageBeforeExecute() {
        Map<String, Integer> bookListMap = library.listBooks();
        String results = "Book and counts:\r\n";
        for (Iterator<String> i = bookListMap.keySet().iterator(); i.hasNext(); ) {
            String book = i.next();
            results += book + "  :  " + bookListMap.get(book) + "\r\n";
        }
        results += "press number: \r\n" +
                "1: List books\r\n" +
                "2: Reserve book\r\n" +
                "0: back to Menu.";
        return new TipMessage(results);
    }

    @Override
    public Message messageAfterExecute() {
        return new TipMessage("press number: \r\n" +
                "1: List books\r\n" +
                "2: Reserve book\r\n" +
                "0: back to Menu.");
    }

    @Override
    public Event nextEvent() {
        return nextEvent();
    }

    @Override
    public Event execute() {
        String instructions = ioHandler.scanInput().returnInput();

        if (instructions.equals("1")) {
            nextEvent = new ListBookEvent();
        } else if (instructions.equals("2")) {
            nextEvent = new ReserveBookEvent();
        } else if (instructions.equals("0")) {
            nextEvent = new MenuEvent();
        } else {
            nextEvent = this;
            messageAfterExecute = new InputInvalidMessage();
        }
        return this;
    }
}