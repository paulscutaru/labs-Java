package com;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Board {
    private LinkedList<Token> tokens = new LinkedList<Token>();
    private int n;
    private volatile boolean available = true;
    private volatile boolean empty = false;

    public Board(int n) {
        for (int i = 1; i <= n; i++) {
            Token t = new Token(i);
            this.tokens.add(t);
        }
        this.n = n;
    }

    public synchronized Token extractToken(int playerTurn) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (!tokens.isEmpty()) {
            Token t;
            t = tokens.getFirst();
            tokens.removeFirst();
            notifyAll();
            System.out.println("Player " + (playerTurn + 1) + " picked " + t);
            return t;
        }
        System.out.println("!!! Game stopped, all tokens consumed and nobody won...");
        available = false;
        empty=true;
        notifyAll();
        return null;
    }

    public synchronized void win(List<Token> tokens,int playerTurn){
        available = false;
        notifyAll();
        System.out.println("!!! Player " + (playerTurn+1) + " with tokens= " + tokens + " won the game!");
    }

    public synchronized boolean isEmpty() {
        return tokens.isEmpty();
    }

    public synchronized boolean isAvailable() {
        return available;
    }

    public synchronized void setAvailable(boolean available) {
        this.available = available;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return "Board{" +
                "tokens=" + tokens +
                '}';
    }
}
