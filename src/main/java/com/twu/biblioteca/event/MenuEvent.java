package com.twu.biblioteca.event;

import com.twu.biblioteca.Controller;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.message.InvalidOrErrorMessage;
import com.twu.biblioteca.message.Message;
import com.twu.biblioteca.message.NullMessage;
import com.twu.biblioteca.message.TipMessage;

public class MenuEvent implements Event {
    private Library library;
    private Controller controller;
    private Event nextEvent;
    private Message messageAfterExecute = new NullMessage();

    public MenuEvent() {
        this.library = Library.instance();
        this.controller = new Controller(this);

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
        nextEvent = controller.scanInput().chooseNextEvent();
        if (nextEvent instanceof MenuEvent) {
            messageAfterExecute = new InvalidOrErrorMessage("please input correct option");
        }
        return this;
    }
}
