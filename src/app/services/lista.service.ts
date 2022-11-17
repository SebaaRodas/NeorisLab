import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Lista } from '../models/lista';

@Injectable({
  providedIn: 'root'
})
export class ListaService {

  constructor(private http: HttpClient) { }
  obtenerLista(){
    let endpoint = '/api/empleado/tipo'
    return this.http.get<Lista[]>(environment.api + endpoint)
  }
}
