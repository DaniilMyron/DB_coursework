package com.miron.kursach.models;

public class Something <T>{
    T value;

    public Something() {
    }

    public Something(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public Something setValue(T value) {
        this.value = value;
        return this;
    }
}
