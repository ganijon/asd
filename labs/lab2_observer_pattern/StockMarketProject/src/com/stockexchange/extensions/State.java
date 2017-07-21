package com.stockexchange.extensions;

public class State {
    public String stockSymbol;
    public Double price;

    public State(String stockSymbol, double price) {
        this.stockSymbol = stockSymbol;
        this.price = price;
    }

    @Override
    public String toString() {
        return "| StockSymbol: " + stockSymbol + " | Price: " + price;
    }
}
