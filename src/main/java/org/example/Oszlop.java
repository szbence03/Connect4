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
        String jatekosString = "";
        String keresendo = jatekos == 'A' ? "AAAA" : "BBBB";
        for (int i = 0; i < o.length; i++) {
            jatekosString += o[i];
        }
        return jatekosString.contains(keresendo);
    }

    public char[] getOszlop() {
        return this.o;
    }

    public boolean oszlopMegteltE() {
        String oszlop = "";
        String keresendo = "0";
        for (int i = 0; i < o.length; i++) {
            oszlop += o[i];
        }
        return !(oszlop.contains(keresendo));
    }

}
