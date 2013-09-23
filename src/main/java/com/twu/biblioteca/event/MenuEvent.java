package com.twu.biblioteca.event;

import com.twu.biblioteca.message.MenuMessage;
import com.twu.biblioteca.message.Message;

public class MenuEvent implements Event {
    @Override
    public Message messageBeforeExecute() {
        return new MenuMessage();  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Message messageAfterExcute() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Event nextEvent() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Event execute() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
