import './index.css';
import LinkNavegacao from '../LinkNavegacao';

const MenuNavegacao = () => {
    return (
        <nav className="menu-navegacao">
            <LinkNavegacao to="/">Home</LinkNavegacao>
            <LinkNavegacao to="/adicionar">Nova Receita</LinkNavegacao>
        </nav>
    )
    
}

export default MenuNavegacao;