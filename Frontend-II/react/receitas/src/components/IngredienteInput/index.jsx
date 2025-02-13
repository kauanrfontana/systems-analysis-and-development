const IngredienteInput = ( {nome, quantidade, medida, aoAtualizar }) => {
  return (
    <div>
      <input 
        type="text" 
        value={nome} 
        onChange={(e) => {aoAtualizar({nome: e.target.value, quantidade, medida})}}/>
      <input 
        type="text" 
        value={quantidade} 
        onChange={(e) => {aoAtualizar({nome, quantidade: e.target.value, medida})}}/>
      <input 
        type="text" 
        value={medida} 
        onChange={(e) => {aoAtualizar({nome, quantidade, medida: e.target.value})}}/>
    </div>
  );
};

export default IngredienteInput;
