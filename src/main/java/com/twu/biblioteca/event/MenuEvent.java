package com.twu.biblioteca.event;

import com.twu.biblioteca.IOHandler;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.message.InvalidOrErrorMessage;
import com.twu.biblioteca.message.Message;
import com.twu.biblioteca.message.NullMessage;
import com.twu.biblioteca.message.TipMessage;

public class MenuEvent implements Event {
    private final Library library;
    private IOHandler ioHandler = new IOHandler();
    private Event nextEvent;
    private Message messageAfterExecute = new NullMessage();

    public MenuEvent(Library library) {
        this.library = library;
    }

    @Override
    public Message messageBeforeExecute() {
        return new TipMessage("1). list books\r\n"
                + "2). reserve a book\r\n"
                + "3). check their membership details\r\n" +
                "q.  quit");
    }

    @Override
    public Message messageAfterExecute() {
        return messageAfterExecute;
    }

    @Override
    public Event nextEvent() {
        return nextEvent;
    }

    @Override
    public Event execute() {
        String instructions = ioHandler.scanInput().returnInput();

        if (instructions.equals("1")) {
            nextEvent = new ListBookEvent(library);
        } else if (instructions.equals("2")) {
            nextEvent = new ReserveBookEvent(library);
        } else if (instructions.equals("3")) {
            nextEvent = new CheckMembershipEvent(library);
        } else if (instructions.equals("q")) {
            nextEvent = new QuitEvent();
        } else {
            nextEvent = this;
            messageAfterExecute = new InvalidOrErrorMessage("please input correct option");
        }
        return this;
    }
}
