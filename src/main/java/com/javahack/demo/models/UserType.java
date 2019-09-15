package com.javahack.demo.models;

public enum UserType {
    INDIVIDUAL_BUISNESS("Indevidual Buisness"),
    SELF_EMPLOYED("Self-Employed");
    private String name;

    public String getName() {
        return name;
    }

    UserType(String name) {
        this.name = name;
    }
}
