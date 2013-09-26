package com.twu.biblioteca;

public class Book {
    private String name = "";
    private String author = "";
    private boolean reserved = false;

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

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
    public int hashCode() {
        return (name + author).hashCode();
    }

    public Book reserve() {
        reserved = true;
        return this;
    }

    public boolean isReserved() {
        return reserved;
    }

    public Book unReserve() {
        reserved = false;
        return this;
    }

    public boolean isEmpty() {
        return author.isEmpty() && name.isEmpty();
    }
}
