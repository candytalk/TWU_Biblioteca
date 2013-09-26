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
        return filterBookWithSomeRules(book).size();
    }

    public Integer countBookWithAuthor(String author) {
        return filterBookWithSomeRules(new Book().setAuthor(author)).size();
    }

    public Integer countBookWithName(String name) {
        return filterBookWithSomeRules(new Book().setName(name)).size();

    }

    private boolean haveSameAuthorOrNoAuthor(Book book1, Book book2) {
        return book1.getAuthor().equals(book2.getAuthor()) || book2.getAuthor().equals("");
    }

    private boolean haveSameNameOrNoName(Book book1, Book book2) {
        return book1.getName().equals(book2.getName()) || book2.getName().equals("");
    }

    private List<Book> filterBookWithSomeRules(Book book) {
        List<Book> booksWithRules = new ArrayList<Book>();
        if (book.isEmpty()) return booksWithRules;
        Book bookInLib;
        for (Iterator<Book> i = books.iterator(); i.hasNext(); ) {
            bookInLib = i.next();
            if (haveSameAuthorOrNoAuthor(bookInLib, book) && haveSameNameOrNoName(bookInLib, book))
                booksWithRules.add(bookInLib);
        }
        return booksWithRules;

    }

    public boolean reserveBook(Book book) {
        List<Book> suitableBooks = filterBookWithSomeRules(book);
        Book bookInSuitableBooks;
        for (Iterator<Book> i = suitableBooks.iterator(); i.hasNext(); ) {
            bookInSuitableBooks = i.next();
            if (!bookInSuitableBooks.isReserved()) {
                bookInSuitableBooks.reserve();
                return true;
            }
        }
        return false;
    }

    public Map<String, Integer> listTotalBooks() {
        Book bookInLib;
        Map<String, Integer> bookListMap = new HashMap<String, Integer>();
        for (Iterator<Book> i = books.iterator(); i.hasNext(); ) {
            bookInLib = i.next();
            String bookToString = bookInLib.toString();
            if (!bookListMap.containsKey(bookToString)) bookListMap.put(bookToString, 1);
            else bookListMap.put(bookToString, bookListMap.get(bookToString) + 1);
        }
        return bookListMap;
    }

    public Map<String, Integer> listUnreservedBooks() {
        Book bookInLib;
        Map<String, Integer> bookListMap = new HashMap<String, Integer>();
        for (Iterator<Book> i = books.iterator(); i.hasNext(); ) {
            bookInLib = i.next();
            if (!bookInLib.isReserved()) {
                String bookToString = bookInLib.toString();
                if (!bookListMap.containsKey(bookToString)) bookListMap.put(bookToString, 1);
                else bookListMap.put(bookToString, bookListMap.get(bookToString) + 1);
            }
        }
        return bookListMap;
    }
}
