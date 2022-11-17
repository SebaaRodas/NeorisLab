import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Empleado } from 'src/app/models/empleado';
import { EmpleadoServiceService } from 'src/app/services/empleado-service.service';

@Component({
  selector: 'app-empleado',
  templateUrl: './empleado.component.html',
  styleUrls: ['./empleado.component.scss']
})
export class EmpleadoComponent implements OnInit {



  formEmpleado = this.fb.group({
    nombre: ['', Validators.required],
    apellido: ['', Validators.required],
    dni: ['', Validators.required],
    email: ['', [Validators.required, Validators.email]],
    telefono: ['', Validators.required]
  })
  constructor(private fb: FormBuilder, private empleadoService: EmpleadoServiceService) { }

  ngOnInit(): void {
  }
  registrar(){
    var empleado: Empleado = new Empleado();
    empleado.nombre = this.formEmpleado.get('nombre')?.value;
    empleado.apellido = this.formEmpleado.get('apellido')?.value;
    empleado.dni = this.formEmpleado.get('dni')?.value;
    empleado.email = this.formEmpleado.get('email')?.value;
    empleado.telefono = this.formEmpleado.get('telefono')?.value;

    this.empleadoService.registrarEmpleado(empleado).subscribe(res=>{
      console.log('Se registro al empleado: '+ res);
      this.formEmpleado.reset();
    },
    error => console.error(error)
    )
  }
}
