import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { JornadaLaboral } from 'src/app/models/jornada';

import { JornadaServiceService } from 'src/app/services/jornada-service.service';


@Component({
  selector: 'app-jornada',
  templateUrl: './jornada.component.html',
  styleUrls: ['./jornada.component.scss']
})
export class JornadaComponent implements OnInit {

  formJornada = this.fb.group({
    fecha:['', Validators.required],
    horaIngreso: ['', Validators.required],
    horaSalida:['', Validators.required],
    idEmpleado:['', Validators.required],
    idTipo:['', Validators.required]
  })
  constructor(private fb: FormBuilder, private jornadaService: JornadaServiceService) { }

  ngOnInit(): void {
  }
  registrarJornada(){
    var jornada: JornadaLaboral = new JornadaLaboral();
    jornada.fecha = this.formJornada.get('fecha')?.value;
    jornada.horaEntrada = this.formJornada.get('horaIngreso')?.value;
    jornada.horaSalida = this.formJornada.get('horaSalida')?.value;

    let idEmpleado = this.formJornada.get('idEmpleado')?.value!;
    let idTipo = this.formJornada.get('idTipo')?.value!;

    this.jornadaService.registrarJornadaLaboral(jornada, idEmpleado, idTipo).subscribe(res=>{
      console.log('Se registro la jornada correctamente: '+ res);
      this.formJornada.reset();
    },
    error=> console.error(error))
  }
}
