package com.javahack.demo.models;

public enum BuisnessArea {
    FOOD("food"),
    TRANSPORT("taxi"),
    CLEANING("cleaning"),
    BABY_SITTER("baby"),
    BUILDING("building");
    private String name;

    BuisnessArea(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
