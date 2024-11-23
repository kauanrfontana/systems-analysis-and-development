import { Component, OnInit } from '@angular/core';
import { ControladorTarefaService } from '../../controller/controlador-tarefa.service';
import { ListaTarefa } from '../../model/lista-tarefa';
import { FormsModule } from '@angular/forms';
import { TarefaComponent } from '../tarefa/tarefa.component';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-lista-tarefas',
  standalone: true,
  imports: [FormsModule, TarefaComponent, CommonModule],
  templateUrl: './lista-tarefas.component.html',
  styleUrl: './lista-tarefas.component.css'
})
export class ListaTarefasComponent implements OnInit{

  lista: ListaTarefa = {_id: 0, _tarefas: [], _nome: ""};

  descricao: string = "descricao da tarefa";

  constructor(private controlador: ControladorTarefaService){
    this.lista = this.controlador.listaAtual;
    console.log(this.lista._tarefas)
  }

  public ngOnInit(): void {
      
  }

  public adicionaTarefa() {
    this.controlador.adicionaTarefa(this.descricao);
  }
}
