package edu.mum;


import java.util.ArrayList;
import java.util.List;

public class ProductCatalog {
    public List<CatalogItem> items;

        public ProductCatalog() {
            items = new ArrayList<>();
        }
    public void printAllItems() {
        for(CatalogItem item: items) {
            item.print();
        }
    }
}
