package org.pbe.demov2.entidades;

import org.springframework.data.jpa.repository.JpaRepository;

// O repositório de receitas, por meio do qual se fazem os acessos
// no banco
public interface ReceitaRepository extends JpaRepository<Recipe, Long> {
}

