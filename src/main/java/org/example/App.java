package org.example;


public final class App {
    private App() {
        throw new IllegalStateException("Utility class cannot be instantiated");
    }
    public static void main(final String[] args) {
       Connect4 jatek = new Connect4(6, 7);
       jatek.inditas();
    }
}
