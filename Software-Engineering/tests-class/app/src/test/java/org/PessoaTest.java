package org;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class PessoaTest {

    @Test
    void constructor() {
        assertThrows(IllegalArgumentException.class, () -> {
           Pessoa p = new Pessoa("Maria", "");
        });
        assertDoesNotThrow(() -> {
            Pessoa p = new Pessoa("João", "12345678909");
        });
    }

    @Test
    void setNome() {
        Pessoa p = new Pessoa("João", "12345678909");
        assertEquals("João", p.getNome());
        assertThrows(IllegalArgumentException.class, () -> {
            p.setNome(null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            p.setNome("");
        });
    }

    @Test
    void testCpf() {
        Pessoa p = new Pessoa("Maria", "07021303971");
        assertTrue(p.isValidCPF(p.getCpf()));
        Pessoa j = new Pessoa("Maria", "00000000000");
        assertFalse(j.isValidCPF(j.getCpf()));
    }

   
}
