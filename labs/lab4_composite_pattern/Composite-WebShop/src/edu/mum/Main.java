package edu.mum;

import com.sun.org.apache.xml.internal.resolver.Catalog;

public class Main {

    public static void main(String[] args) {
        ProductCatalog pc = new ProductCatalog();

        Category cBooksDvd = new Category("Books & DVDs");
        Category cBooks = new Category("Books");
        Category cDvds = new Category("DVDs");

        Book book = new Book("Twilight", "111222333");
        DVD dvd = new DVD("Twilight Movie");

        cBooks.addCatalogItem(book);
        cDvds.addCatalogItem(dvd);

        cBooksDvd.addCatalogItem(cBooks);
        cBooksDvd.addCatalogItem(cDvds);

        pc.items.add(cBooksDvd);

        pc.printAllItems();
    }
}
