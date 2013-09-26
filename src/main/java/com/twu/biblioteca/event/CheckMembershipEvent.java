package com.twu.biblioteca.event;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.message.Message;
import com.twu.biblioteca.message.NullMessage;
import com.twu.biblioteca.message.TipMessage;

public class CheckMembershipEvent implements Event {
    private Library library;

    public CheckMembershipEvent(Library library) {
        this.library = library;
    }

    @Override
    public Message messageBeforeExecute() {
        return new NullMessage();
    }

    @Override
    public Message messageAfterExecute() {
        return new TipMessage("go to find laomao");
    }

    @Override
    public Event nextEvent() {
        return new MenuEvent(library);
    }

    @Override
    public Event execute() {
        return this;
    }

    @Override
    public Library getLibrary() {
        return library;
    }
}
