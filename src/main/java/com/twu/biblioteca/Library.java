package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<Book>();

    public Library addBook(Book book) {
        books.add(book);
        return this;
    }

    public boolean hasBook(Book book) {
        return countBook(book) > 0;
    }

    public boolean hasBookOfAuthor(String author) {
        return countBookWithAuthor(author) > 0;
    }

    public boolean hasBookOfName(String name) {
        return countBookWithName(name) > 0;
    }

    public Integer countBook(Book book) {
        return countBookWithSomeRules(book).size();
    }

    public Integer countBookWithAuthor(String author) {
        return countBookWithSomeRules(new Book().setAuthor(author)).size();
    }

    public Integer countBookWithName(String name) {
        return countBookWithSomeRules(new Book().setName(name)).size();

    }

    private List<Book> countBookWithSomeRules(Book book) {
        List<Book> booksWithRules = new ArrayList<Book>();
        for (Iterator<Book> i = books.iterator(); i.hasNext(); ) {
            Book bookInLib = i.next();

            if (
                    (bookInLib.getAuthor().equals(book.getAuthor()) || book.getAuthor().equals(""))
                            && (bookInLib.getName().equals(book.getName()) || book.getName().equals(""))
                    )
                booksWithRules.add(bookInLib);
        }
        return booksWithRules;

    }

}
