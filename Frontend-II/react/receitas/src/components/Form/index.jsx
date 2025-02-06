export default function Form({recipe, onEdit}) {
    return (
        <form>
            <h2>Editar receitas</h2>
            <input 
            type="text" 
            name="name" 
            value={recipe.nome}
            placeholder="Nome da receita"
            onChange={(e) => onEdit({...recipe, nome: e.target.value})}
            />
            <div>
                <h3>Ingredientes</h3>
                <ul>
                    {recipe.ingredientes.map(
                        (ingrediente, i) => {
                            return <li key={i}>
                                <input 
                                type="text" 
                                value={ingrediente.nome}
                                />
                                <input 
                                type="text"
                                value={ingrediente.quantidade} 
                                />
                                 <input 
                                type="text"
                                value={ingrediente.medida} 
                                />
                            </li>
                        }
                    )}
                </ul>
            </div>
            <div>
                <h3>Modo de Preparo</h3>
                <ul>
                    {recipe.instrucoes.map(
                        (instrucao, i) => {
                            return <li key={i}>
                                <input 
                                type="text" 
                                value={instrucao}
                                />
                            </li>
                        }
                    )}
                </ul>
            </div>
        </form>
    )
}