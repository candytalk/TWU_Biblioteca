package com.twu.biblioteca.event;

import com.twu.biblioteca.message.Message;
import com.twu.biblioteca.message.NullMessage;
import com.twu.biblioteca.message.TipMessage;

public class CheckMembershipEvent implements Event {

    public CheckMembershipEvent() {
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
        return new MenuEvent();
    }

    @Override
    public Event execute() {
        return this;
    }


}
