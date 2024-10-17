package org.example;

import java.util.Scanner;

public class Connect4 {
    private Palya jatek;
    private Scanner input;

    private String jatekosNev;


    public Connect4(int oszlopok, int sorok) {
        jatek = new Palya(oszlopok, sorok);
        inditas();
    }

    public void inditas() {
        input = new Scanner(System.in);
        System.out.print("\nAdd meg a neved: ");
        jatekosNev = input.next();
        while (!jatekEllenorzes()) {
            System.out.print("\n" + jatekosNev +", add meg az oszlop számát (1 - " + jatek.getOszlopDb() + "): ");
            int sor = input.nextInt();
            if(jatek.oszlopMegteltE(sor-1)) {
                continue;
            }
            jatek.lepes(sor, 'A');
            if(jatekEllenorzes()) {
                break;
            }
            System.out.println("Ellenfél lépése: \n");
            int ellenfelLepes = (int) Math.floor(Math.random() * jatek.getOszlopDb()) + 1;
            while (jatek.oszlopMegteltE(ellenfelLepes-1)) {
                ellenfelLepes = (int) Math.floor(Math.random() * jatek.getOszlopDb()) + 1;
            }

            jatek.lepes(ellenfelLepes, 'B');

            if(jatekEllenorzes()) {
                break;
            }
        }
        input.close();
    }

    private boolean jatekEllenorzes() {
        if(jatek.checkGyoztes()) {
            if(jatek.getGyoztes() == 'A') {
                System.out.println("\n" + jatekosNev + ", nyertél!\n");
            } else {
                System.out.println("\nAz ellenfeled nyert!\n");
            }
            return true;
        }
        if (jatek.megteltE()) {
            System.out.println("Döntetlen!");
            return true;
        }
        return false;
    }
}
