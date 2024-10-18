
package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Scanner;

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
    void testJatekEllenorzesShouldReturnTrue() {
        when(palyaMock.checkGyoztes()).thenReturn(true);
        when(palyaMock.getGyoztes()).thenReturn('A');
        assertTrue(connect4.jatekEllenorzes());
    }
}
