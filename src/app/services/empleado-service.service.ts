import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Empleado } from '../models/empleado';

@Injectable({
  providedIn: 'root'
})
export class EmpleadoServiceService {

  constructor(private http: HttpClient) { }

  registrarEmpleado(request: Empleado): Observable<any>{
    let endpoint = '/api/empleado';
    return this.http.post(environment.api + endpoint, request)
  }
}
