package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BookTest {
    private Book book;

    @Before
    public void setUp() throws Exception {
        book = new Book();
    }

    @Test
    public void should_get_book_name() throws Exception {
        //given
        String bookName = "bookname";

        //when
        book.setName(bookName);

        //then
        assertThat(book.getName(), is(bookName));
    }

    @Test
    public void should_get_author() throws Exception {
        //given
        String author = "author";

        //when
        book.setAuthor(author);

        //then
        assertThat(book.getAuthor(), is(author));
    }

    @Test
    public void books_have_same_name_and_same_author__should_be_equal() throws Exception {
        //given
        Book book2 = new Book();
        book.setAuthor("author").setName("name");
        book2.setAuthor("author").setName("name");

        //then
        assertEquals(book, book2);
    }

    @Test
    public void book_can_be_reserved() throws Exception {
        //when
        book.reserved();

        //then
        assertTrue(book.isReserved());
    }

    @Test
    public void book_can_be_unreserved() throws Exception {
        //when
        book.reserved().unreserved();

        //then
        assertFalse(book.isReserved());
    }
}
