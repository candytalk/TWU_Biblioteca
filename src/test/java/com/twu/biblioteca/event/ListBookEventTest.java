package com.twu.biblioteca.event;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.message.Message;
import com.twu.biblioteca.message.TipMessage;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class ListBookEventTest {
    ListBookEvent listBookEvent = new ListBookEvent();
    Library library = new Library();

    @Before
    public void setUp() throws Exception {
        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();

        //book1
        book1.setAuthor("author").setName("name");
        //book2 are same to book1
        book2.setAuthor("author").setName("name");
        //book3
        book3.setAuthor("zhihao").setName("zhbook");
        library.addBook(book1).addBook(book2).addBook(book3);

    }

    @Test
    public void list_book_event_will_give_tip_message_as_messageBeforeExecute() throws Exception {
        listBookEvent.setLibrary(library);
        Message message = listBookEvent.messageBeforeExecute();
        assertTrue(message instanceof TipMessage);
    }



}
