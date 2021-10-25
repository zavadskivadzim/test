package com.zavadski.task5;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Safe {
    Thing[] things;
    int value;

    public Safe(Thing[] things, int value) {
        this.things = things;
        this.value = value;
    }

    public Thing[] getThings() {
        return things;
    }

    public int getValue() {
        return value;
    }

    public String showSafe() {
        return things == null ? "" : Arrays.stream(things).map(Thing::getName).collect(Collectors.joining(", ")) + ". Ценность набора " + getValue();
    }
}
