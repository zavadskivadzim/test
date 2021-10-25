package com.zavadski.task5;

public class Thing {
    private final String name;
    private final int volume;
    private final int value;

    public Thing(String name, int volume, int value) {
        this.name = name;
        this.volume = volume;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }

    public int getValue() {
        return value;
    }
}