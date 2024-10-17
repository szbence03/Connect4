package org.example;

public class Palya {
    private Oszlop[] oszlopok;
<<<<<<< HEAD
    private char gyoztes;
=======
>>>>>>> 3d377db (bővítgetések)

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
<<<<<<< HEAD
        if (oszlopIndex >= 0 && oszlopIndex < oszlopok.length) {
=======
        if(oszlopIndex >= 0 && oszlopIndex < oszlopok.length) {
>>>>>>> 3d377db (bővítgetések)
            oszlopok[oszlopIndex].lepes(szin);

            System.out.println("\nÚj lépés: " + szin + " a " + (oszlopIndex + 1) + ". oszlopon\n");
            System.out.println(mezoKiiratas());
        } else {
            System.out.println("A kivánt oszlop nem létezik!");
        }
    }

    public boolean checkGyoztes() {
        char[] jatekosok = {'A', 'B'};
<<<<<<< HEAD
        for (int h = 0; h < 2; h++) {
=======
        for(int h = 0; h < 2; h++) {
>>>>>>> 3d377db (bővítgetések)
            char jatekos = jatekosok[h];

            //vízszintes keresés
            for (int i = 0; i < oszlopok.length - 3; i++) {
                for (int j = oszlopok[0].getOszlop().length - 1; j > 0; j--) {
                    if (oszlopok[i].getOszlop()[j] == jatekos && oszlopok[i + 1].getOszlop()[j] == jatekos && oszlopok[i + 2].getOszlop()[j] == jatekos && oszlopok[i + 3].getOszlop()[j] == jatekos) {
<<<<<<< HEAD
                        setGyoztes(jatekos);
=======
                        System.out.println("Vízszintes nyertes!\n");
                        System.out.println("\n" + '\'' + jatekos + '\'' + " játékos nyert!\n");
>>>>>>> 3d377db (bővítgetések)
                        return true;
                    }
                }
            }

            //függőleges keresés
            for (int i = 0; i < oszlopok.length; i++) {
                if (oszlopok[i].checkOszlop(jatekos)) {
<<<<<<< HEAD
                    setGyoztes(jatekos);
=======
>>>>>>> 3d377db (bővítgetések)
                    return true;
                }
            }

            //átlós keresés
            for (int i = 0; i < oszlopok.length - 3; i++) {
                for (int j = 0; j < oszlopok[0].getOszlop().length - 3; j++) {
<<<<<<< HEAD
                    if (oszlopok[i].getOszlop()[j] == jatekos && oszlopok[i + 1].getOszlop()[j + 1] == jatekos && oszlopok[i + 2].getOszlop()[j + 2] == jatekos && oszlopok[i + 3].getOszlop()[j + 3] == jatekos) {
                        setGyoztes(jatekos);
=======
                    if (oszlopok[i].getOszlop()[j] == jatekos && oszlopok[i + 1].getOszlop()[j + 1] == jatekos && oszlopok[i + 2].getOszlop()[j + 3] == jatekos && oszlopok[i + 3].getOszlop()[j + 3] == jatekos) {
                        System.out.println("Átlós nyertes!\n");
                        System.out.println("\n" + '\'' + jatekos + '\'' + " játékos nyert!\n");
>>>>>>> 3d377db (bővítgetések)
                        return true;
                    }
                }
            }

<<<<<<< HEAD
            //átlós keresés másik irányból
            for (int i = 0; i < oszlopok.length - 3; i++) {
                for (int j = 3; j < oszlopok[0].getOszlop().length; j++) {
                    if (oszlopok[i].getOszlop()[j] == jatekos && oszlopok[i + 1].getOszlop()[j - 1] == jatekos && oszlopok[i + 2].getOszlop()[j - 2] == jatekos && oszlopok[i + 3].getOszlop()[j - 3] == jatekos) {
                        setGyoztes(jatekos);
=======
            //átlós keresés visszafele
            for (int i = 0; i < oszlopok.length - 3; i++) {
                for (int j = 3 ; j < oszlopok[0].getOszlop().length; j++) {
                    if (oszlopok[i].getOszlop()[j] == jatekos && oszlopok[i + 1].getOszlop()[j - 1] == jatekos && oszlopok[i + 2].getOszlop()[j - 2] == jatekos && oszlopok[i + 3].getOszlop()[j - 3] == jatekos) {
                        System.out.println("Átlós nyertes visszafelé!\n");
                        System.out.println("\n" + '\'' + jatekos + '\'' + " játékos nyert!\n");
>>>>>>> 3d377db (bővítgetések)
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean megteltE() {
<<<<<<< HEAD
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
=======
        for (int i = 0; i < oszlopok.length; i++) {
            oszlopMegteltE(i);
        }
        return false;
    }

    public boolean oszlopMegteltE(int index) {
        return oszlopok[index].oszlopMegteltE();
>>>>>>> 3d377db (bővítgetések)
    }

    public int getOszlopDb() {
        return this.oszlopok.length;
    }


}
