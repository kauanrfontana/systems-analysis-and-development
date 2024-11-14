import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HeaderComponent } from './components/header/header.component';
import { ListaTarefasComponent } from './components/lista-tarefas/lista-tarefas.component';
import { TarefaComponent } from './components/tarefa/tarefa.component';
import { EntradaComponent } from './components/entrada/entrada.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, HeaderComponent, ListaTarefasComponent, TarefaComponent, EntradaComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
}
