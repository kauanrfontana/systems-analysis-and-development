import MenuNavegacao from "../MenuNavegacao";

export default function Cabecalho(props) {

    return (
        <header style={{textAlign: "center"}}>
            <h1>{props.titulo}</h1>
            <MenuNavegacao/>
        </header>
    )   
}