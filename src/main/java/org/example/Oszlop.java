
package org.example;

import java.util.Arrays;

public class Oszlop {
    private char[] o;

    public Oszlop(final int meret) {
        int minValue = 4;
        int maxValue = 13;
        if (meret >= minValue && meret < maxValue) {
            this.o = new char[meret];
        } else {
            int defaultValue = 6;
            this.o = new char[defaultValue];
        }
        oszlopFeltoltes();
    }

    private void oszlopFeltoltes() {
        Arrays.fill(o, '0');
    }

    public void lepes(final char szin) {
        for (int i = o.length - 1; i >= 0; i--) {
            if (o[i] == '0') {
                o[i] = szin;
                return;
            }
        }
    }

    public boolean checkOszlop(char jatekos) {
        StringBuilder jatekosString = new StringBuilder();
        String keresendo = jatekos == 'A' ? "AAAA" : "BBBB";
        for (int i = 0; i < o.length; i++) {
            jatekosString.append(o[i]);
        }
        return jatekosString.toString().contains(keresendo);
    }

    public char[] getOszlop() {
        return this.o;
    }

    public boolean oszlopMegteltE() {
        StringBuilder oszlop = new StringBuilder();
        String keresendo = "0";
        for (int i = 0; i < o.length; i++) {
            oszlop.append(o[i]);
        }
        return !(oszlop.toString().contains(keresendo));
    }

}
