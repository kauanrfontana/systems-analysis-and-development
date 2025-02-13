import { Link, useLocation } from "react-router"

const LinkNavegacao = ({children, to}) => {
    const localizacao = useLocation()
    return (
        <Link to={to} className={`link ${localizacao.pathname === to && 'ativo'}`}>{children}</Link>
    )
}

export default LinkNavegacao;