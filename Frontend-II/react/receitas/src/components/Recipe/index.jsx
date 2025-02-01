import Rate from '../Rate';
import './style.css';
export default function Recipe({name, ingredients, instructions}){
    return (
    <section className='receita-card'>
        <h2>{name}</h2>
        <h3>Ingredientes:</h3>
        <ul>
            {ingredients.map((ingredient, i) => (
                <li key={i}>{ingredient.quantidade} {ingredient.medida} de {ingredient.nome}</li>
                )
            )}
        </ul>
        <h3>Modo de Preparo:</h3>
        <ol>
            {instructions.map((instruction, i) => (
                <li key={i}>{instruction}</li>
                )
            )}
        </ol>
        <Rate></Rate>
    </section>
)

}