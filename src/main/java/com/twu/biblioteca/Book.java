package com.twu.biblioteca;

public class Book {
    private String name;
    private String author;
    private boolean reserved;

    public String getName() {
        return name;
    }

    public Book setName(String name) {
        this.name = name;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public Book setAuthor(String author) {
        this.author = author;
        return this;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Book)) return false;
        Book anotherBook = (Book) object;
        return author == anotherBook.getAuthor() && name == anotherBook.getName();
    }

    @Override
    public int hashCode(){
        return (name+author).hashCode();
    }

    public Book reserved() {
        reserved = true;
        return this;
    }

    public boolean isReserved() {
        return reserved;
    }

    public Book unreserved() {
        reserved = false;
        return this;
    }
}
