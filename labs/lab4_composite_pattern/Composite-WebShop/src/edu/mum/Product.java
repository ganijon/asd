package edu.mum;

public abstract class Product implements CatalogItem {
    public String title;
    @Override
    public void print() {
        System.out.println("Title: " + title);
    }
}
