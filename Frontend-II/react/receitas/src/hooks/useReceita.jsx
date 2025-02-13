import { useContext, useState } from "react";
import { ReceitaContext } from "../contexto/ReceitaContext";

const useReceita = () => {
  const { receitas, setReceitas, receitaSelecionada, setReceitaSelecionada } = useContext(ReceitaContext);

  const aoEditar = (id) => {
    setReceitaSelecionada(receitas.find((receita) => receita.id === id));
    console.log(receitaSelecionada);
  };

  const apagarReceita = (id) => {
    setReceitas(receitas.filter((receita) => receita.id !== id));
  };

  const atualizarReceita = (receita) => {
    setReceitas(receitas.map((r) => (r.id === receita.id ? receita : r)));
    setReceitaSelecionada(receita);
  };

  return {
    receitas,
    receitaSelecionada,
    aoEditar,
    apagarReceita,
    atualizarReceita,
  };
};

export default useReceita;
