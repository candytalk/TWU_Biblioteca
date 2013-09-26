package com.twu.biblioteca.event;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.message.Message;
import com.twu.biblioteca.message.NullMessage;
import com.twu.biblioteca.message.TipMessage;

import java.util.Iterator;
import java.util.Map;

public class ListBookEvent implements Event {
    private Library library;
    private Event nextEvent;
    private Message messageAfterExecute;

    public ListBookEvent(Library library) {
        this.library = library;
    }

    public Library getLibrary() {
        return library;
    }

    @Override
    public Message messageBeforeExecute() {
        return new NullMessage();
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
        Map<String, Integer> bookListMap = library.listBooksCategoryAndCounts();
        String results = "Book and counts:\r\n";
        for (Iterator<String> i = bookListMap.keySet().iterator(); i.hasNext(); ) {
            String bookCategory = i.next();
            results += "Book info: " + bookCategory
                    + " total: " + bookListMap.get(bookCategory)
                    + " available: " + countUnreservedBook(bookCategory) + "\r\n";
        }
        messageAfterExecute = new TipMessage(results);
        nextEvent = new MenuEvent(library);
        return this;
    }

    private Integer countUnreservedBook(String bookCategory) {
        return library.listBooksCategoryAndUnreservedCounts().get(bookCategory) != null ? library.listBooksCategoryAndUnreservedCounts().get(bookCategory) : 0;
    }

}