package com.twu.biblioteca;

import com.twu.biblioteca.event.Event;
import com.twu.biblioteca.event.MenuEvent;

public class Biblioteca {
    public static void main(String[] args) {
        Library library = new Library();
        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();

        //book1
        book1.setAuthor("author").setName("name").reserved();
        //book2 are same to book1
        book2.setAuthor("author").setName("name");
        //book3
        book3.setAuthor("zhihao").setName("zhbook");
        library.addBook(book1).addBook(book2).addBook(book3);

        Event event = new MenuEvent(library);

        while (null != event) {
            System.out.println(event.messageBeforeExecute().getMsg());
            event.execute();
            System.out.println(event.messageAfterExecute().getMsg());
            event = event.nextEvent();
        }
    }

}


