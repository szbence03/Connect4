package org.example;

public class Palya {
    private Oszlop[] oszlopok;

    public Palya(int oszlopok, int sorok) {
        int minValue = 4;
        int maxValue = 13;
        if (oszlopok >= minValue && oszlopok < maxValue) {
            this.oszlopok = new Oszlop[oszlopok];
        } else {
            int defaultValue = 7;
            this.oszlopok = new Oszlop[defaultValue];
        }
        sorFeltoltes(sorok);
       System.out.println(mezoKiiratas());
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
        if(oszlopIndex >= 0 && oszlopIndex < oszlopok.length) {
            oszlopok[oszlopIndex].lepes(szin);

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
            for (int i = 0; i < oszlopok.length - 3; i++) {
                for (int j = oszlopok[0].getOszlop().length - 1; j > 0; j--) {
                    if (oszlopok[i].getOszlop()[j] == jatekos && oszlopok[i + 1].getOszlop()[j] == jatekos && oszlopok[i + 2].getOszlop()[j] == jatekos && oszlopok[i + 3].getOszlop()[j] == jatekos) {
                        System.out.println("Vízszintes nyertes!\n");
                        System.out.println("\n" + '\'' + jatekos + '\'' + " játékos nyert!\n");
                        return true;
                    }
                }
            }

            //függőleges keresés
            for (int i = 0; i < oszlopok.length; i++) {
                if (oszlopok[i].checkOszlop(jatekos)) {
                    return true;
                }
            }

            //átlós keresés
            for (int i = 0; i < oszlopok.length - 3; i++) {
                for (int j = 0; j < oszlopok[0].getOszlop().length - 3; j++) {
                    if (oszlopok[i].getOszlop()[j] == jatekos && oszlopok[i + 1].getOszlop()[j + 1] == jatekos && oszlopok[i + 2].getOszlop()[j + 3] == jatekos && oszlopok[i + 3].getOszlop()[j + 3] == jatekos) {
                        System.out.println("Átlós nyertes!\n");
                        System.out.println("\n" + '\'' + jatekos + '\'' + " játékos nyert!\n");
                        return true;
                    }
                }
            }

            //átlós keresés visszafele
            for (int i = 0; i < oszlopok.length - 3; i++) {
                for (int j = 3 ; j < oszlopok[0].getOszlop().length; j++) {
                    if (oszlopok[i].getOszlop()[j] == jatekos && oszlopok[i + 1].getOszlop()[j - 1] == jatekos && oszlopok[i + 2].getOszlop()[j - 2] == jatekos && oszlopok[i + 3].getOszlop()[j - 3] == jatekos) {
                        System.out.println("Átlós nyertes visszafelé!\n");
                        System.out.println("\n" + '\'' + jatekos + '\'' + " játékos nyert!\n");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean megteltE() {
        for (int i = 0; i < oszlopok.length; i++) {
            oszlopMegteltE(i);
        }
        return false;
    }

    public boolean oszlopMegteltE(int index) {
        return oszlopok[index].oszlopMegteltE();
    }

    public int getOszlopDb() {
        return this.oszlopok.length;
    }


    }

