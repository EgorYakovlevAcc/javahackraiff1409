package com.javahack.demo.models;

import java.util.List;

public enum  TransactionType {
    TAX("tax"),
    FOR_BUISNESS_PURPOSES("for buisness"),
    OTHER("other");
    private String name;

    TransactionType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
