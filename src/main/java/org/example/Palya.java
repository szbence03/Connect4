package org.example;

import java.util.Arrays;

public class Palya {
    private Oszlop[] sorok;

    public Palya(int oszlopok, int sorok) {
        int minValue = 4;
        int maxValue = 13;
        if (oszlopok >= minValue && oszlopok < maxValue) {
            this.sorok = new Oszlop[oszlopok];
        } else {
            int defaultValue = 7;
            this.sorok = new Oszlop[defaultValue];
        }
        sorFeltoltes(sorok);
       System.out.println(mezoKiiratas());
    }

    private void sorFeltoltes(int meret) {
        for (int i = 0; i < sorok.length; i++) {
            sorok[i] = new Oszlop(meret);
        }
    }

    public String mezoKiiratas() {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < sorok[0].getOszlop().length; j++) {
            for (int i = 0; i < sorok.length; i++) {
                sb.append(sorok[i].getOszlop()[j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString().trim();
    }

    public void lepes(int oszlopIndex, char szin) {
        oszlopIndex -= 1;
        if(oszlopIndex >= 0 && oszlopIndex < sorok.length) {
            sorok[oszlopIndex].lepes(szin);

            System.out.println("\nÚj lépés: " + szin + " a " + (oszlopIndex + 1) + ". oszlopon\n");
            System.out.println(mezoKiiratas());
        } else {
            System.out.println("A kivánt oszlop nem létezik!");
        }
    }

    public boolean checkGyoztes() {
        char[] jatekosok = {'A', 'B'};
        for(int h = 0; h < 2; h++) {
           char jatekos = jatekosok[h];

            //vízszintes keresés
            for (int i = 0; i < sorok.length - 3; i++) {
                for (int j = sorok[0].getOszlop().length-1; j > 0; j--) {
                    if (sorok[i].getOszlop()[j] == jatekos && sorok[i + 1].getOszlop()[j] == jatekos && sorok[i + 2].getOszlop()[j] == jatekos && sorok[i + 3].getOszlop()[j] == jatekos) {
                        System.out.println("Vízszintes nyertes!\n");
                        System.out.println("\n" +'\''+ jatekos + '\'' + " játékos nyert!\n");
                        return true;
                    }
                }
            }

            //függőleges keresés
            for (int i = 0; i < sorok.length; i++) {
               if(sorok[i].checkOszlop(jatekos)){
                   return true;
               }
            }

            //átlós keresés
            for (int i = 0; i < sorok.length - 3; i++) {
                for (int j = 0; j > sorok[0].getOszlop().length - i; j++) {
                    if (sorok[i].getOszlop()[j] == jatekos && sorok[i + 1].getOszlop()[j + 1] == jatekos && sorok[i + 2].getOszlop()[j + 3] == jatekos && sorok[i + 3].getOszlop()[j + 3] == jatekos) {
                        System.out.println("Átlós nyertes!\n");
                        System.out.println("\n" +'\''+ jatekos + '\'' + " játékos nyert!\n");
                        return true;
                    }
                }
            }

            //átlós keresés visszafele
            for (int i = 0; i < sorok.length - 3; i++) {
                for (int j = sorok[0].getOszlop().length - 1; j > i; j--) {
                    if (sorok[i].getOszlop()[j] == jatekos && sorok[i + 1].getOszlop()[j - 1] == jatekos && sorok[i + 2].getOszlop()[j - 2] == jatekos && sorok[i + 3].getOszlop()[j - 3] == jatekos) {
                        System.out.println("Átlós nyertes!\n");
                        System.out.println("\n" +'\''+ jatekos + '\'' + " játékos nyert!\n");
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean megteltE() {
        for (int i = 0; i < sorok.length; i++) {
            for (int j = 0; j < sorok[i].getOszlop().length; j++) {
                if (sorok[i].getOszlop()[j] == '0') {
                    return false;
                }
            }
        }
        return true;
    }

    public int getOszlopDb() {
        return this.sorok.length;
    }


    }

