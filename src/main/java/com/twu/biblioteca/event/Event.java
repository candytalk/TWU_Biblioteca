package com.twu.biblioteca.event;

import com.twu.biblioteca.message.Message;

public interface Event {
    public Message messageBeforeExecute();
    public Message messageAfterExecute();
    public Event nextEvent();
    public Event execute();
}