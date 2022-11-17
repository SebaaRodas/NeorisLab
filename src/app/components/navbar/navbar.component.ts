import { Component, OnInit } from '@angular/core';
import { Lista } from 'src/app/models/lista';
import { ListaService } from 'src/app/services/lista.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  listaEmp: Lista[] = [];

  constructor(private listaService: ListaService) { }

  ngOnInit(): void {
    this.listaService.obtenerLista().subscribe(data=>{
      this.listaEmp = data;
    })
  }

}
