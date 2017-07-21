package edu.mum;

import java.util.ArrayList;
import java.util.List;

public class Category implements CatalogItem {
    private List<CatalogItem> items;

    public String name;

    public Category(String name) {
        this.name = name;
        items = new ArrayList<>();
    }

    @Override
    public void print() {
        System.out.println("Category: " + name);
        for(CatalogItem item: items) {
            item.print();
        }
    }

    public void addCatalogItem(CatalogItem item) {
        items.add(item);
    }

    public void removeCatalogItem(CatalogItem item) {
        items.remove(item);
    }

    public void getChild(int index) {
        items.remove(index);
    }
}
