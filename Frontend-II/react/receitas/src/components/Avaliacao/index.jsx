import { useState } from "react";
import Estrela from "../Estrela";
import './style.css'

const Avaliacao = () => {

    const estrelas = [...Array(5)];
    const [ avaliacao, setAvaliacao ] = useState(0);

    return (
        <div className="avaliacao">
            {estrelas.map((_, i) => (
                <Estrela 
                    key={i} 
                    selecionado={avaliacao > i}
                    aoSelecionar={() => {
                        setAvaliacao(i + 1);
                        console.log(avaliacao)
                    }}
                />
            ))}
        </div>
    )
}

export default Avaliacao;