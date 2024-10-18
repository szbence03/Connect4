package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;


@ExtendWith(MockitoExtension.class)
class AppTest {

    @Test
    void testConnect4ShouldNotBeNull() {
        Connect4 connect4 = new Connect4(6, 7);
        assertNotNull(connect4);
    }


    @Test
    void testJatekosNevSetAndGet() {
        Connect4 connect4 = new Connect4();
        connect4.setJatekosNev("Jatekos");
        assertEquals("Jatekos", connect4.getJatekosNev());
    }

}