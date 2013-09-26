package com.twu.biblioteca.event;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.IOHandler;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.message.InvalidOrErrorMessage;
import com.twu.biblioteca.message.Message;
import com.twu.biblioteca.message.TipMessage;

public class ReserveBookEvent implements Event {
    private Library library;
    private IOHandler ioHandler = new IOHandler();
    private Event nextEvent;
    private Message messageAfterExecute;

    public ReserveBookEvent(Library library) {
        this.library = library;
    }

    public Library getLibrary() {
        return library;
    }

    @Override
    public Message messageBeforeExecute() {
        return new TipMessage("Please input the book you want to reserve as this format:\r\n" +
                "name,author\r\n");
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
        Book book = createBookFromInput();
        if (!library.reserveBook(book)) {
            messageAfterExecute = new InvalidOrErrorMessage("can't reserve this kind of book, please check");
            nextEvent = new MenuEvent(library);
        } else {
            messageAfterExecute = new TipMessage("Succeed");

        }
        nextEvent = new MenuEvent(library);
        return this;
    }

    private Book createBookFromInput() {
        String[] bookInfo = ioHandler.scanInput().returnInput().split(",");
        Book book = new Book();
        String bookName = bookInfo[0].trim();
        book.setName(bookName);
        if (bookInfo.length > 1) {
            String bookAuthor = bookInfo[1].trim();
            book.setAuthor(bookAuthor);
        }
        return book;
    }
}
