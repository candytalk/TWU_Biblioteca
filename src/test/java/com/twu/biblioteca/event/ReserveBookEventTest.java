package com.twu.biblioteca.event;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.IOTools;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.message.InvalidOrErrorMessage;
import com.twu.biblioteca.message.TipMessage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;

public class ReserveBookEventTest {
    public Library library = Library.instance();
    private ReserveBookEvent reserveBookEvent = new ReserveBookEvent();

    @Before
    public void setUp() throws Exception {
        library.addBook(new Book().setName("book").setAuthor("zhihao"));
    }

    @After
    public void tearDown() throws Exception {
        Library.reset();
    }

    @Test
    public void reserve_book_event_should_let_user_reserve_correct_book() throws Exception {
        IOTools.InputFromString(" book , zhihao ");
        assertTrue(reserveBookEvent.execute().messageAfterExecute() instanceof TipMessage);
        assertTrue(reserveBookEvent.nextEvent() instanceof MenuEvent);
    }

    @Test
    public void reserve_book_event_should_not_let_user_reserve_incorrect_book() throws Exception {
        IOTools.InputFromString(" book2 , zhihao ");
        assertTrue(reserveBookEvent.execute().messageAfterExecute() instanceof InvalidOrErrorMessage);
    }
}
