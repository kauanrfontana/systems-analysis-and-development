import "./style.css";
import Avaliacao from "../Avaliacao/index.jsx";
import { FaRegEdit, FaRegTrashAlt } from "react-icons/fa";
import useReceita from "../../hooks/useReceita.jsx";

const Receita = ({ id }) => {
  const { receitas, apagarReceita, aoEditar } = useReceita();
  const receita = receitas.find((receita) => receita.id === id);

  return (
    <section className="receita-card">
      <h2>{receita.nome}</h2>
      <h3>Ingredientes</h3>
      <ul>
        {receita.ingredientes.map((ingrediente, i) => (
          <li key={i}>
            {ingrediente.quantidade} {ingrediente.medida} de {ingrediente.nome}
          </li>
        ))}
      </ul>
      <h3>Modo de preparo</h3>
      <ol>
        {receita.instrucoes.map((instrucao, i) => (
          <li key={i}>{instrucao}</li>
        ))}
      </ol>
      <div className="rodape">
        <Avaliacao />
        <div>
          <FaRegEdit onClick={() => aoEditar(id)} />
          <FaRegTrashAlt onClick={() => apagarReceita(id)} />
        </div>
      </div>
    </section>
  );
};

export default Receita;
