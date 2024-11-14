import { Component } from '@angular/core';
import { ControladorTarefaService } from '../../controller/controlador-tarefa.service';
import { ListaTarefa } from '../../model/lista-tarefa';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-lista-tarefas',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './lista-tarefas.component.html',
  styleUrl: './lista-tarefas.component.css'
})
export class ListaTarefasComponent {

  lista: ListaTarefa = {
    _id: 4,
    _nome: "Tarefas ADS",
    _tarefas: [
      {
        _id: 1,
        _descricao: "Cancelar Matrícula!",
        _concluida: false
      }
    ]
  }

  descricao: string = "descricao da tarefa";
  constructor(private controlador: ControladorTarefaService){}

  public adicionaTarefa() {
    this.controlador.adicionaTarefa(this.descricao);
  }
}
