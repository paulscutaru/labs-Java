package com;

public class Token{
    private int value;

    public Token() {
    }

    public Token(int token) {
        this.value = token;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int token) {
        this.value = token;
    }

    @Override
    public String toString() {
        return "Token=" +
                value;
    }
}
