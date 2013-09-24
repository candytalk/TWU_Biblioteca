package com.twu.biblioteca.event;

import com.twu.biblioteca.IOHandler;
import com.twu.biblioteca.message.InputInvalidMessage;
import com.twu.biblioteca.message.MenuMessage;
import com.twu.biblioteca.message.Message;
import com.twu.biblioteca.message.NullMessage;

public class MenuEvent implements Event {
    private IOHandler ioHandler = new IOHandler();
    private Event nextEvent = null;
    private Message messageAfterExecute = new NullMessage();

    @Override
    public Message messageBeforeExecute() {
        return new MenuMessage();  //To change body of implemented methods use File | Settings | File Templates.
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
            nextEvent = new SearchBookEvent();
        } else if (instructions.equals("2")) {
            nextEvent = new ReserveBookEvent();
        } else if (instructions.equals("3")) {
            nextEvent = new MenuEvent();
        } else {
            nextEvent = this;
            messageAfterExecute = new InputInvalidMessage();
        }
        return this;
    }
}
