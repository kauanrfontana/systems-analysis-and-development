import { Injectable } from '@angular/core';
import { ListaTarefa } from '../model/lista-tarefa';
import { Tarefa } from '../model/tarefa';

@Injectable({
  providedIn: 'root'
})
export class ControladorTarefaService {

  private listas: ListaTarefa[] = this.carregaListas();
  private idListaAtual: number = 0;

  constructor() { }

  public get listaAtual(): ListaTarefa {
    return this.listas[this.idListaAtual];
  }

  public salvaLista() {
    localStorage.setItem("tarefas", JSON.stringify(this.listas));
  }

  public carregaListas(): ListaTarefa[] {
    const listaSalvas = localStorage.getItem("tarefas");
    return listaSalvas ? JSON.parse(listaSalvas) : [this.criarLista('Lista 1')];
  }

  public criarLista(nome: string): ListaTarefa {
    return {_id: Date.now(), _nome: nome, _tarefas: []}
  }

  public criarTarefa(descricao: string): Tarefa {
    return {_id: Date.now(), _descricao: descricao, _concluida: false};
  }

  public adicionaTarefa(descricao: string): void{
    const tarefa = {
      _id: Date.now(),
      _descricao: descricao,
      _concluida: false
    };

    this.listas[this.idListaAtual]._tarefas.push(tarefa);
    this.salvaLista();
  }
}
