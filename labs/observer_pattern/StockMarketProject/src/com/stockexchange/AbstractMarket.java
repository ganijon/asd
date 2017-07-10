package com.stockexchange;

import com.stockexchange.extensions.Observable;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractMarket extends Observable {
    Map<String, Double> stocklist = new HashMap<String, Double>();

    public Map<String, Double> getStocklist() {
        return stocklist;
    }
}
