package org.example;

import java.util.Scanner;

public class Connect4 {
    Palya jatek;
    Scanner input = new Scanner(System.in);

    public Connect4(int oszlopok, int sorok) {
        jatek = new Palya(oszlopok, sorok);
        inditas();
    }

    public void inditas() {

        while (!jatekEllenorzes()) {
            System.out.print("\n'A' játékos, add meg az oszlop számát: ");
            jatek.lepes(input.nextInt(), 'A');
            if(jatekEllenorzes()) {
                break;
            }
            int ellenfelLepes = (int) Math.floor(Math.random() * jatek.getOszlopDb()) + 1;
            System.out.println("'B' játékos, lépése: \n");
            jatek.lepes(ellenfelLepes, 'B');
            if(jatekEllenorzes()) {
                break;
            }
        }
        input.close();
    }

    private boolean jatekEllenorzes() {
        if (jatek.checkGyoztes()) {
            return true;
        }
        if (jatek.megteltE()) {
            System.out.println("Döntetlen!");
            return true;
        }
        return false;
    }
}
