package org;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class PessoaTest {

    @Test
    void getNome() {
        Pessoa pessoa = new Pessoa("Nome Sobrenome", "12345678910");
        assertEquals("Nome Sobrenome", pessoa.getNome());
    }

    @Test
    void setNome() {
        Pessoa pessoa = new Pessoa("Nome Sobrenome", "12345678910");
        assertNotNull(pessoa.getNome());
    }

    @Test
    void testCpf() {
        Pessoa p = new Pessoa("Maria", "07021303971");
        assertTrue(p.isValidCPF(p.getCpf()));
        Pessoa j = new Pessoa("Maria", "00000000000");
        assertFalse(j.isValidCPF(j.getCpf()));
    }

   
}
