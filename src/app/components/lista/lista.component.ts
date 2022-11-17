import { Component, OnInit } from '@angular/core';
import { Lista } from 'src/app/models/lista';
import { ListaService } from 'src/app/services/lista.service';

@Component({
  selector: 'app-lista',
  templateUrl: './lista.component.html',
  styleUrls: ['./lista.component.scss']
})
export class ListaComponent implements OnInit {
  listaEmp: Lista [] = [];
  constructor(private listaService: ListaService) { }

  ngOnInit(): void {
    this.listaService.obtenerLista().subscribe(data=>{
      this.listaEmp = data;
      console.log(this.listaEmp)
    })
  }
}
