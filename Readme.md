#API DE TURNOS ROTATIVOS
***
El siguiente proyecto es una API para la gestión de turnos desarrollado en Java. Utilizando las siguientes tecnologías: Spring Boot, el jdk 1.8, Maven y H2.

Para el proyecto se implementó la arquitectura MVC.

La carpeta controller tiene las diferentes clases de controladores para realizar las peticiones http.

La carpeta Service contiene las interfaces y las implementaciones que contienen la lógica para que funcione dicho proyecto.

La carpeta repository contiene las diferentes interfaces mediante JPA que brindará los diferentes métodos y la referencia a la entidad.

La carpeta entity contiene el modelo de las diferentes entidades que van a ser utilizadas.

Un ejemplo: 

* La clase ControlerEmpleado recibe la petición de dar un alta empleado y llama al servicio guardarEmpleado.
* En service se encuentra la interfaz ServiceEmpleado, que es implementada en la clase ServiceEmpleadoImpl, que a su vez este llama al método save que viene desde RepositoryEmpleado.
* En repository se encuentra RepositoryEmpleado que es la interfaz que implementa mediante JPA la entidad Empleado y el método save que hereda.
***

Para las diferentes pruebas:
* Dar de alta un empleado.

    Para dar de alta al empleado debe realizar mediante Postman los siguientes pasos:
  1. Ingresar a Postman.
  2. Crear un Post.
  3. Ingresar en la url: http://localhost:8080/api/empleado
  4. En "Body" seleccionar "raw" y elegir el formato JSON.
  5. Luego ingresar el siguiente JSON:

     {
     "nombre":"Jorge",
     "apellido":"Gomez",
     "dni":"144445",
     "email":"nombre@gmail.com",
     "telefono":"12356"
     }
  6. Por último dar click en "Send" para guardar dicho método.
  
    Este procedimiento debe realizarlo cada vez que quiera dar de alta un empleado.

***

* Dar de alta un turno de trabajo.

    Para dar de alta un turno de trabajo debe realizar los siguientes pasos:

    1. Ingresar a Postman y seleccionar el método POST.
    2. Ingresar a la url: http://localhost:8080/api/tipo
    3. En "Body" seleccionar "raw" y elegir el formato JSON.
    4. Luego ingresar el siguiente JSON:
  
       {
       "tipo":"normal"
       }
    5. Hacer click en "Send" para guardar el post.
    
    Una aclaración con respecto a estas altas es que las jornadas deben cargarse con el siguiente formato debido a la implementación de otras soluciones:
    
    Si va a trabajar un turno normal debe ingresar "normal"

  Si va a trabajar un turno extra debe ingresar "extra"

    Si desea sacar vaciones debe ingresar "vacaciones"

    Si desea tomarse el dia libre debe ingresar "libre"

    Y por último, en caso de que haga turno normal y horas extras cargue "normalYExtra" sin espacios.
***
* Cargar una jornada

    Para cargar una jornada como precondición debe existir el empleado (se lo asigna mediante su id) y debe existir el tipo de jornada que desea realizar (vinculado por id).
    
    Para dar de alta debe realizar los siguientes pasos: 

    1. Ingresar al Postman y seleccionar el método Post.
    2. Ingresar a la url: 
    3. Debe mandar el JSON en este formato:

  {
"fecha":"2022-09-12",
"horaEntrada":"08:00",
"horaSalida":"16:00",
"empleado":{},
"tipoJornada":{}
}
  4. En "Params" debe ingresar el idEmpleado y el idTurno con sus respectivos id ya existentes.
  5. Hacer click en "Send" para cargar la jornada.


***
* Listar a los empleados por su identificador mostrando el tipo de jornada y la cantidad de horas que trabajó semanalmente.

    Para mostrar la lista debe ingresar la siguiente url: http://localhost:8080/api/empleado/tipo

    Tambien puede verlo mediante el método get en Postman utilizando la misma url.
* **
* Modificar cantidad de horas trabajadas

    Como precondición debe estar creada la jornada.
    
    Para actualizar debe realizar los siguientes pasos: 
  1. Ingresar al Postman y seleccionar el método "PUT".
  2. Ingresar la siguiente url: http://localhost:8080/api/jornada
  3. En "Params" debe ingresar el idJornada, la horaEntrada y horaSalida, el cual va a modificar la url de acuerdo a los parámetros ingresados.
  4. Dar click en "Send" para guardar la actualización.

