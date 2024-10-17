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

    @Mock
    private Scanner inputMock;

    @BeforeEach
    void setUp() {
        connect4 = new Connect4(6, 7);
    }

    @Test
    void testJatekInditasShouldReturnTrue() {
        when(inputMock.next()).thenReturn("Jatekos");
        when(inputMock.nextInt()).thenReturn(1);
        connect4.inditas();
        assertTrue(connect4.jatekEllenorzes());
    }

    @Test
    void testJatekEllenorzesShouldReturnTrue() {
        when(palyaMock.checkGyoztes()).thenReturn(true);
        when(palyaMock.getGyoztes()).thenReturn('A');
        assertTrue(connect4.jatekEllenorzes());
    }
}