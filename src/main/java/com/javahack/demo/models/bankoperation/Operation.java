package com.javahack.demo.models.bankoperation;

public enum Operation {
    ADD("add_money"),
    REMOVE("remove_money");
    String operationName;

    Operation(String operationName) {
        this.operationName = operationName;
    }
}
