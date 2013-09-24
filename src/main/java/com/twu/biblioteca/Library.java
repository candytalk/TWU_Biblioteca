package com.twu.biblioteca;

import java.util.*;

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
        Book bookInLib;
        for (Iterator<Book> i = books.iterator(); i.hasNext(); ) {
            bookInLib = i.next();

            //dirty code to do the search
            if (
                    (bookInLib.getAuthor().equals(book.getAuthor()) || book.getAuthor().equals(""))
                            && (bookInLib.getName().equals(book.getName()) || book.getName().equals(""))
                    )
                booksWithRules.add(bookInLib);
        }
        return booksWithRules;

    }

    public Map<String,Integer> listBooks() {
        Book bookInLib;
        Map<String, Integer> bookListMap = new HashMap<String, Integer>();
        for (Iterator<Book> i = books.iterator(); i.hasNext(); ) {
            bookInLib = i.next();
            String bookToString = bookInLib.toString();
            if (!bookListMap.containsKey(bookToString)) bookListMap.put(bookToString,1);
            else bookListMap.put(bookToString,bookListMap.get(bookToString)+1);
        }
        return bookListMap;
    }
}
