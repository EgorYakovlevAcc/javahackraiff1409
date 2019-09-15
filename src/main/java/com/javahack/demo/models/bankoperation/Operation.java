package com.javahack.demo.models.bankoperation;

public enum Operation {
    ADD("add"),
    REMOVE("remove");
    String operationName;

    Operation(String operationName) {
        this.operationName = operationName;
    }

    public String getOperationName() {
        return operationName;
    }

    public static Operation getOperationByName (String name) {
        switch (name) {
            case "add": {
                return Operation.ADD;
            }
            case "remove": {
                return Operation.REMOVE;
            }
            default: return null;
        }
    }
}
