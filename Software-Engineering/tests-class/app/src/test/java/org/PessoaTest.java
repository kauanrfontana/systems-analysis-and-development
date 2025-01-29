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
    void getCpf() {
    }

    @Test
    void setCpf() {
    }

    @Test
    void isValidCPF(){

    }
}