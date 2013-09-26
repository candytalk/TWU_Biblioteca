package com.twu.biblioteca;

import com.twu.biblioteca.event.Event;
import com.twu.biblioteca.event.MenuEvent;

public class Biblioteca {
    public static void main(String[] args) {
        execute(setUpInitialEvent());
    }

    static private void execute(Event beginEvent) {
        while (null != beginEvent) {
            beginEvent.messageBeforeExecute().showMsg();
            beginEvent.execute();
            beginEvent.messageAfterExecute().showMsg();
            beginEvent = beginEvent.nextEvent();
        }
    }

    static private Event setUpInitialEvent() {
        Library library = new Library();
        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();

        //book1
        book1.setAuthor("author").setName("name").reserve();
        //book2 are same to book1
        book2.setAuthor("author").setName("name");
        //book3
        book3.setAuthor("zhihao").setName("zhbook");
        library.addBook(book1).addBook(book2).addBook(book3);

        return new MenuEvent(library);

    }

}


