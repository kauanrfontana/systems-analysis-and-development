package org;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    @DisplayName("Teste da Soma")
    void add() {
        assertEquals(9, Calculator.add(2,3,4));
    }

    @Test
    @DisplayName("Teste da Multiplicação")
    void multiply() {
    }
}