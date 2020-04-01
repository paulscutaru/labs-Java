package com;

import java.util.LinkedList;

public class Game {
    private int m;
    private int n;
    private int k;
    private LinkedList<Player> players = new LinkedList<Player>();
    private Board board;

    public Game(int m, int n, int k, LinkedList<Player> players, Board board) {
        this.m = m;
        this.n = n;
        this.k = k;
        this.players = players;
        this.board = board;
    }

    public void startGame() {
        for (int i = 0; i < players.size(); i++) {
            players.get(i).setTurn(i);
            new Thread(players.get(i)).start();
        }

    }

    public int getM() {
        return m;
    }

    public int getN() {
        return n;
    }

    public int getK() {
        return k;
    }

    public LinkedList<Player> getPlayers() {
        return players;
    }

    public Board getBoard() {
        return board;
    }

    @Override
    public String toString() {
        return "Game{" +
                "\nm=" + m +
                ", n=" + n +
                ", k=" + k +
                ", \nplayers=" + players +
                ", \nboards=" + board +
                '}';
    }
}
