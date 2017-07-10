package com.stockexchange;

import com.stockexchange.extensions.State;

public class Application {
    public static void main(String[] args) {

        StockMarket market = new StockMarket();

        market.attachObserver(new StockBuyer(market));
        market.attachObserver(new StockViewer(market));

        market.addStock("ORC", 12.23);
        market.addStock("MSC", 45.78);

        market.setState(new State("ORC", 12.34));
        market.setState(new State("MSC", 44.68));

        market.update("ORC", 12.34);
        market.update("MSC", 44.68);

        market.setState(new State("ORC", 12.34));
        market.setState(new State("MSC", 44.68));
    }
}