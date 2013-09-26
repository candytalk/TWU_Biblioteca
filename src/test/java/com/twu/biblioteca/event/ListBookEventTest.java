package com.twu.biblioteca.event;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.message.Message;
import com.twu.biblioteca.message.TipMessage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class ListBookEventTest {
    Library library;
    ListBookEvent listBookEvent = new ListBookEvent();

    @After
    public void tearDown() throws Exception {
        Library.reset();
    }

    @Before
    public void setUp() throws Exception {
        library = Library.instance();
        Library.reset();
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

    @Test
    public void list_book_event_will_give_tip_message_as_execute() throws Exception {
        listBookEvent.execute();
        Message message = listBookEvent.messageAfterExecute();
        assertTrue(message instanceof TipMessage);
        assertEquals(message.getMsg(), "Book and counts:\r\n" +
                "Book info: Book{author='zhihao', name='zhbook'} total: 1 available: 1\r\n" +
                "Book info: Book{author='author', name='name'} total: 2 available: 1\r\n");
    }


}
