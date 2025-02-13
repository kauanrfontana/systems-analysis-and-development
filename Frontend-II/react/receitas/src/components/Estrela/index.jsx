import { FaStar } from 'react-icons/fa'

const Estrela = ({ selecionado = false, aoSelecionar }) => {
    
    return (
        <FaStar 
            color={ selecionado ? 'yellow' : 'grey'} 
            onClick={aoSelecionar}
        />
    )
}

export default Estrela;