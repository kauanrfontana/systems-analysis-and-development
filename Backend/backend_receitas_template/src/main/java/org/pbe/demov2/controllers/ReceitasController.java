package org.pbe.demov2.controllers;

import org.pbe.demov2.entidades.Recipe;
import org.pbe.demov2.services.ReceitaContent;
import org.pbe.demov2.services.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ReceitasController {

    @Autowired
    ReceitaService receitaService;

    @GetMapping("/teste")
    public ReceitaContent teste() throws Exception{
        return receitaService.testa_bd();
    }

    @GetMapping("/receitas")
    public List<ReceitaContent> lista_receitas() throws Exception{
        return receitaService.obtem_receitas();
    }

    @GetMapping("/receitas/{id:\\d+}")
    public ReceitaContent obtem_receita(@PathVariable("id") int id) {
        return receitaService.obtem_receita(id);
    }

    @PostMapping("/receitas/adicionar")
    public ReceitaContent adiciona_receita(@RequestBody String receita) {
        return receitaService.adiciona_receita(receita);
    }

    @PutMapping("/receitas/{id:\\d+}")
    public ReceitaContent substitui_receita(@PathVariable("id") int id, @RequestBody String receita) {
        return receitaService.substitui_receita(id, receita);
    }

//    @PutMapping(value="/receitas/**", )
//    public void put_error() throws Exception{
//        throw new MissingBodyException("PUT incorreto");
//    }

}