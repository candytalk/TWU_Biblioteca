package com.twu.biblioteca;

import com.twu.biblioteca.event.Event;
import com.twu.biblioteca.event.MenuEvent;

public class Biblioteca {
    public static void main(String[] args) {
        executeEvent();
    }

    static private void executeEvent() {
        setUpInitialEvent();
        Event beginEvent = new MenuEvent();
        while (null != beginEvent) {
            beginEvent.messageBeforeExecute().showMsg();
            beginEvent.execute();
            beginEvent.messageAfterExecute().showMsg();
            beginEvent = beginEvent.nextEvent();
        }
    }

    static private void setUpInitialEvent() {
        Library library = Library.instance();
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


    }

}


