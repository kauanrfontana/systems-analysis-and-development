import { FaStar } from "react-icons/fa";

export default function Star({selected = trues, onSelect}){
    return (
        <span><FaStar enableBackground={'red'}  color={selected ? 'yellow' : 'gray'} onClick={onSelect}></FaStar></span>
    )
}