
package org.example;

import org.apache.maven.surefire.shade.org.apache.commons.io.output.ByteArrayOutputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class Connect4Test {

    @InjectMocks
    private Connect4 connect4;


    @Mock
    private Palya palyaMock;


    @BeforeEach
    void setUp() {
        connect4 = new Connect4(palyaMock);
    }

    @Test
    void testConstructor() {
        Connect4 connect4Constructor = new Connect4();
        assertNotNull(connect4Constructor);
    }


    @Test
    void testsetJatekosNevShouldBeSet() {
        connect4.setJatekosNev("Jatekos");
        assertEquals("Jatekos", connect4.getJatekosNev());
    }


    @Test
    void testJatekEllenorzesShouldReturnTrue() {
        when(palyaMock.checkGyoztes()).thenReturn(true);
        when(palyaMock.getGyoztes()).thenReturn('A');
        assertTrue(connect4.jatekEllenorzes());
    }

}

