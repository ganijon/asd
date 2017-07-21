package com.stockexchange;

import com.stockexchange.extensions.*;

import java.util.Iterator;
import java.util.Map;

public class StockViewer implements Observer {

    public void update(Map<String, Double> stocklist) {
        System.out.println("StockViewer: stocklist is changed:");
        Iterator iter = stocklist.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            String key = (String) entry.getKey();
            Double value = (Double) entry.getValue();
            System.out.println("StockViewer" + key + " - $" + value);
        }
    }

    private State observerState;
    private StockMarket observable;

    public StockViewer(StockMarket observable) {
        this.observable = observable;
    }

    @Override
    public void update() {
        observerState = observable.getState();
        log();
    }

    public void log() {
        System.out.println("StockViewer : Stock changed: " + observerState);
    }
}