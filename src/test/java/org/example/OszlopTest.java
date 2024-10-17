package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OszlopTest {

    private Oszlop oszlop;

    @BeforeEach
    void setUp() {
        oszlop = new Oszlop(6);
    }

    @Test
    void testOszlopInitialvaluesShouldBeZeros() {
        char[] expected = {'0', '0', '0', '0', '0', '0'};
        assertArrayEquals(expected, oszlop.getOszlop());
    }

    @Test
    void testLepesShouldUpdateWithPlayerChar() {
        oszlop.lepes('A');
        assertEquals('A', oszlop.getOszlop()[5]);
    }

    @Test
    void testOszlopMegteltEShouldReturnTrue() {
        for (int i = 0; i < 6; i++) {
            oszlop.lepes('A');
        }
        assertTrue(oszlop.oszlopMegteltE());
    }

    @Test
    void testCheckOszlopShouldReturnTrue() {
        for (int i = 0; i < 4; i++) {
            oszlop.lepes('A');
        }
        assertTrue(oszlop.checkOszlop('A'));
    }
}