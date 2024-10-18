package org.example;

import java.util.Scanner;

public final class Connect4 {
    private Palya jatek;
    private Scanner input;

    private String jatekosNev;

    public Connect4() {
        jatek = new Palya(6, 7);
    }

    public Connect4(Palya palyaMock) {
        jatek = palyaMock;
    }

    public Connect4(int oszlopok, int sorok) {
        jatek = new Palya(oszlopok, sorok);
    }


    public void inditas() {
        input = new Scanner(System.in);
        System.out.print("\nAdd meg a neved: ");
        setJatekosNev(input.next());
        jatekMenet();
        input.close();
    }

    public void jatekMenet() {
        while (!jatekEllenorzes()) {
            System.out.print("\n" + jatekosNev + ", add meg az oszlop számát (1 - " + jatek.getOszlopDb() + "): ");
            int sor = input.nextInt();
            if (jatek.oszlopMegteltE(sor - 1) || (sor > jatek.getOszlopDb() || sor < 1)) {
                continue;
            }
            jatek.lepes(sor, 'A');
            if (jatekEllenorzes()) {
                break;
            }
            System.out.println("Ellenfél lépése: \n");
            int ellenfelLepes = (int) Math.floor(Math.random() * jatek.getOszlopDb()) + 1;
            while (jatek.oszlopMegteltE(ellenfelLepes - 1)) {
                ellenfelLepes = (int) Math.floor(Math.random() * jatek.getOszlopDb()) + 1;
            }

            jatek.lepes(ellenfelLepes, 'B');

            if (jatekEllenorzes()) {
                break;
            }

        }
    }

    public void setJatekosNev(String j) {
        this.jatekosNev = j;
    }

    public String getJatekosNev() {
        return jatekosNev;
    }

    public boolean jatekEllenorzes() {
        if (jatek.checkGyoztes()) {
            if (jatek.getGyoztes() == 'A') {
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