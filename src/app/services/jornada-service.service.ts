import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { JornadaLaboral } from '../models/jornada';

@Injectable({
  providedIn: 'root'
})
export class JornadaServiceService {

  constructor(private http: HttpClient) { }

  registrarJornadaLaboral(request: JornadaLaboral, idEmpleado: number, idTipo: number): Observable<any>{
    let endpoint = '/api/jornada';
    return this.http.post(environment.api + endpoint + `?idEmpleado=${idEmpleado}` + `&idTipo=${idTipo}`, request)
  }
}
