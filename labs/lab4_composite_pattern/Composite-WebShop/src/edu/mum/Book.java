package edu.mum;

public class Book extends Product {
    public String isbn;

    public Book(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
    }
    @Override
    public void print(){
        super.print();
        System.out.println("ISBN: " + isbn);
    }
}
