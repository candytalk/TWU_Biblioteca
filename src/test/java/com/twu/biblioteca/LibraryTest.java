package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LibraryTest {
    private Library library = new Library();
    private Book book = new Book();

    @Before
    public void setUp() throws Exception {
        book.setAuthor("author").setName("name");
    }

    @Test
    public void library_could_add_book() throws Exception {
        library.addBook(book);

        assertTrue(library.hasBook(book)
                && library.hasBookOfAuthor("author")
                && library.hasBookOfName("name"));
    }

    @Test
    public void library_has_search_api() throws Exception {
        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();


        //book1
        book1.setAuthor("author").setName("name");
        //book2 are same to book1
        book2.setAuthor("author").setName("name");
        //book3
        book3.setAuthor("zhihao").setName("zhbook");

        //when no book added in library
        assertThat(library.countBook(book1), is(0));

        //when add three books
        library.addBook(book).addBook(book2).addBook(book3);

        assertThat(library.countBook(book1), is(2));
        assertThat(library.countBook(book2), is(2));
        assertThat(library.countBookWithAuthor("zhihao"), is(1));
        assertThat(library.countBookWithName("zhbook"), is(1));
    }

    @Test
    public void list_total_book_api() throws Exception {
        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();

        //book1
        book1.setAuthor("author").setName("name");
        //book2 are same to book1
        book2.setAuthor("author").setName("name");
        //book3
        book3.setAuthor("zhihao").setName("zhbook");

        //when add three books
        library.addBook(book).addBook(book2).addBook(book3);

        //book1 and book2 belong to same kind which counts 2:
        assertThat(library.listTotalBooks().get(book1.toString()), is(2));
        //two kinds books:
        assertThat(library.listTotalBooks().size(), is(2));

    }

    @Test
    public void list_available_book_api() throws Exception {
        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();

        //book1
        book1.setAuthor("author").setName("name");
        //book2 are same to book1 but reserve
        book2.setAuthor("author").setName("name").reserve();
        //book3
        book3.setAuthor("zhihao").setName("zhbook").reserve();
        //when add three books
        library.addBook(book1).addBook(book2).addBook(book3);

        assertThat(library.listUnreservedBooks().size(), is(1));
        assertThat(library.listUnreservedBooks().get(book1.toString()), is(1));

    }

    @Test
    public void reserve_book_api() throws Exception {
        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();

        //book1
        book1.setAuthor("author").setName("name");
        //book2 are same to book1 but reserve
        book2.setAuthor("author").setName("name");
        //book3
        book3.setAuthor("zhihao").setName("zhbook");
        //when add three books
        library.addBook(book1).addBook(book2).addBook(book3);

        //we have two this kind(the book with name:"name" and author: "author")book,
        //so we can reserve this kind of book twice:
        assertTrue(library.reserveBook(new Book().setAuthor("author").setName("name")));
        assertTrue(library.reserveBook(new Book().setAuthor("author").setName("name")));
        //but NOT three times:
        assertFalse(library.reserveBook(new Book().setAuthor("author").setName("name")));

        //we have 1 this kind book:
        assertTrue(library.reserveBook(new Book().setAuthor("zhihao").setName("zhbook")));
        assertFalse(library.reserveBook(new Book().setAuthor("zhihao").setName("zhbook")));

        //we don't have this kind book:
        assertFalse(library.reserveBook(new Book().setAuthor("xxx").setName("zhbook")));
    }
}
