package com.twu.biblioteca.event;

import com.twu.biblioteca.IOHandler;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.message.InvalidOrErrorMessage;
import com.twu.biblioteca.message.Message;
import com.twu.biblioteca.message.NullMessage;
import com.twu.biblioteca.message.TipMessage;

public class MenuEvent implements Event {
    private Library library;
    private IOHandler ioHandler;
    private Event nextEvent;
    private Message messageAfterExecute = new NullMessage();

    public MenuEvent(Library library) {
        this.library = library;
        this.ioHandler = new IOHandler(this);

    }

    public Library getLibrary() {
        return library;
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
        nextEvent = ioHandler.scanInput().handleOptionRouter();
        if (nextEvent instanceof MenuEvent) {
            messageAfterExecute = new InvalidOrErrorMessage("please input correct option");
        }
        return this;
    }
}
