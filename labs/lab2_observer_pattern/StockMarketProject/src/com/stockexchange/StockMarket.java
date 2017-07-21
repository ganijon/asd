package com.stockexchange;

import com.stockexchange.extensions.State;

public class StockMarket extends AbstractMarket {

    public void addStock(String stockSymbol, Double price) {
        stocklist.put(stockSymbol, price);
    }

    public void update(String stockSymbol, Double price) {
        stocklist.put(stockSymbol, price);
    }

    // Observable members

    private State observableState;

    public State getState() {
        return observableState;
    }

    public void setState(State currentState) {
        observableState = currentState;
        notifyObservers();
    }
}