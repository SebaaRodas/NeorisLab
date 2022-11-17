import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmpleadoComponent } from './components/empleado/empleado.component';
import { JornadaComponent } from './components/jornada/jornada.component';
import { ListaComponent } from './components/lista/lista.component';

const routes: Routes = [
  {
    path: '',
    component: EmpleadoComponent
  },
  {
    path: 'empleado',
    component: EmpleadoComponent
  },
  {
    path: 'lista',
    component: ListaComponent
  },
  {
    path: 'jornada',
    component: JornadaComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
