import Receita from "../Receita";
import Form from "../Form";
import useReceita from "../../hooks/useReceita";

const Principal = () => {
  const {
    receitas,
    receitaSelecionada,
    apagarReceita,
    aoEditar,
    atualizarReceita,
  } = useReceita();

  return (
    <>
      <section className="receitas">
        {receitas.map((receita) => {
          return (
            <Receita
              key={receita.id}
              id={receita.id}
            />
          );
        })}
      </section>
      <section>
        <Form receita={receitaSelecionada} aoAtualizar={atualizarReceita} />
      </section>
    </>
  );
};

export default Principal;
