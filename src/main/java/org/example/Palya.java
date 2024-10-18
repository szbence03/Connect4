package org.example;

import java.util.Arrays;

public class Palya {
    private Oszlop[] oszlopok;
    private char gyoztes;

    public Palya() {
        this.oszlopok = new Oszlop[6];
        sorFeltoltes(7);
        System.out.println(mezoKiiratas());
    }

    public Palya(int oszlopok, int sorok) {
        int minValue = 4;
        int maxValue = 13;
        if (oszlopok >= minValue && oszlopok < maxValue) {
            this.oszlopok = new Oszlop[oszlopok];
            sorFeltoltes(sorok);
            System.out.println(mezoKiiratas());
        } else {
            new Palya();
        }

    }

    private void sorFeltoltes(int meret) {
        for (int i = 0; i < oszlopok.length; i++) {
            oszlopok[i] = new Oszlop(meret);
        }
    }

    public String mezoKiiratas() {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < oszlopok[0].getOszlop().length; j++) {
            for (int i = 0; i < oszlopok.length; i++) {
                sb.append(oszlopok[i].getOszlop()[j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString().trim();
    }

    public void lepes(int oszlopIndex, char szin) {
        oszlopIndex -= 1;
        if (oszlopIndex >= 0 && oszlopIndex < oszlopok.length) {
            oszlopok[oszlopIndex].lepes(szin);

            System.out.println("\nÚj lépés: " + szin + " a " + (oszlopIndex + 1) + ". oszlopon\n");
            System.out.println(mezoKiiratas());
        } else {
            System.out.println("A kivánt oszlop nem létezik!");
        }
    }

    public boolean checkGyoztes() {
        char[] jatekosok = {'A', 'B'};
        for (int h = 0; h < 2; h++) {
            char jatekos = jatekosok[h];

            //vízszintes keresés
            for (int i = 0; i < oszlopok.length - 3; i++) {
                for (int j = oszlopok[0].getOszlop().length - 1; j > 0; j--) {
                    if (oszlopok[i].getOszlop()[j] == jatekos && oszlopok[i + 1].getOszlop()[j] == jatekos && oszlopok[i + 2].getOszlop()[j] == jatekos && oszlopok[i + 3].getOszlop()[j] == jatekos) {
                        setGyoztes(jatekos);
                        return true;
                    }
                }
            }

            //függőleges keresés
            for (int i = 0; i < oszlopok.length; i++) {
                if (oszlopok[i].checkOszlop(jatekos)) {
                    setGyoztes(jatekos);
                    return true;
                }
            }

            //átlós keresés
            for (int i = 0; i < oszlopok.length - 3; i++) {
                for (int j = 0; j < oszlopok[0].getOszlop().length - 3; j++) {
                    if (oszlopok[i].getOszlop()[j] == jatekos && oszlopok[i + 1].getOszlop()[j + 1] == jatekos && oszlopok[i + 2].getOszlop()[j + 2] == jatekos && oszlopok[i + 3].getOszlop()[j + 3] == jatekos) {
                        setGyoztes(jatekos);
                        return true;
                    }
                }
            }

            //átlós keresés másik irányból
            for (int i = 0; i < oszlopok.length - 3; i++) {
                for (int j = 3; j < oszlopok[0].getOszlop().length; j++) {
                    if (oszlopok[i].getOszlop()[j] == jatekos && oszlopok[i + 1].getOszlop()[j - 1] == jatekos && oszlopok[i + 2].getOszlop()[j - 2] == jatekos && oszlopok[i + 3].getOszlop()[j - 3] == jatekos) {
                        setGyoztes(jatekos);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean megteltE() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < oszlopok.length; i++) {
            for (int j = 0; j < oszlopok[0].getOszlop().length; j++) {
                sb.append(oszlopok[i].getOszlop()[j]);
            }
        }
        String mezok = sb.toString();
        return !mezok.contains("0");
    }

    private void setGyoztes(char jatekos) {
        gyoztes = jatekos;
    }

    public char getGyoztes() {
        return gyoztes;
    }

    public boolean oszlopMegteltE(int index) {
        if (index >= 0 && index < oszlopok.length) {
            return oszlopok[index].oszlopMegteltE();
        }
        return false;
    }

    public int getOszlopDb() {
        return this.oszlopok.length;
    }


}
