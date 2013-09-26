package com.twu.biblioteca.event;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.message.Message;
import com.twu.biblioteca.message.NullMessage;

public class QuitEvent implements Event{
    @Override
    public Message messageBeforeExecute() {
        return new NullMessage();
    }

    @Override
    public Message messageAfterExecute() {
        return new NullMessage();
    }

    @Override
    public Event nextEvent() {
        return null;
    }

    @Override
    public Event execute() {
        return this;
    }

    @Override
    public Library getLibrary() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
