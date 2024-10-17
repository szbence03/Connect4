package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
class PalyaTest {

    @InjectMocks
    private Palya palya;

    @Mock
    private Oszlop oszlopMock;

    @BeforeEach
    void setUp() {
        palya = new Palya(6, 7);
    }

    @Test
    void testLepesShouldBeValid() {
        palya.lepes(1, 'A');
        assertNotNull(palya.getOszlopDb());
    }

    @Test
    void testCheckGyoztesShouldReturnTrueAndgetGyoztesShoulReturnWinner() {
        for (int i = 1; i <= 4; i++) {
            palya.lepes(i, 'A');
        }
        assertTrue(palya.checkGyoztes());
        assertEquals('A', palya.getGyoztes());
    }

    @Test
    void testMegteltEShouldReturnTrue() {
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 7; j++) {
                palya.lepes(i, 'A');
            }
        }
        assertTrue(palya.megteltE());
    }

    @Test
    void testOszlopMegteltEShouldReturnTrue() {
        when(oszlopMock.oszlopMegteltE()).thenReturn(true);
        assertTrue(oszlopMock.oszlopMegteltE());
    }
}