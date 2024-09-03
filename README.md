<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <style>
    h1 {
      font-size: 3em;
      color: #4CAF50; /* Cambia el color */
      text-align: center;
      text-transform: uppercase; /* Texto en mayúsculas */
      letter-spacing: 2px; /* Espaciado entre letras */
      margin-top: 50px;
      margin-bottom: 20px;
      font-family: 'Arial', sans-serif;
    }
  </style>
  <title>Microservicios de Pacientes y Turnos</title>
</head>
<body>

Estos microservicios han sido diseñados para gestionar las operaciones relacionadas con la 
administración de pacientes y turnos médicos, aprovechando una arquitectura de microservicios 
distribuida. 

• Microservicio de Pacientes: Este servicio se encarga de gestionar la información de los 
pacientes, como su registro, edición y eliminación. Todas las solicitudes son procesadas 
mediante endpoints REST, lo que permite interactuar con una base de datos SQL Server, en 
este caso estamos usando phpmyadmin para gestionarlas.
• Microservicio de Turnos: A través de este servicio, es posible crear, modificar y consultar 
turnos médicos. Funciona de manera independiente al servicio de pacientes, aunque también 
se conecta a su propia base de datos SQL 

A continuación, se mencionarán los pasos para ejecutar ambos microservicios:

1. Conexión de base de datos:
Necesitamos una herramienta como Xampp para activar los servicios de mySql y 
apache de la siguiente manera:
Luego nos dirigimos a la siguiente dirección:
http://localhost/phpmyadmin/index.php?route=/
Aquí vamos a crear dos bases de datos ‘servicio_paciente’ y ‘servicio_turno’, las tablas luego se crearán
una vez que ejecutado el backend.

2. Ejecución de microservicios
Se tienen que abrir los dos proyectos en un IDE, aconsejo usar NetBeans o IntelliJ IDEA 
Community Edition ya que por lo general hacen la descarga de todas la dependencias 
necesarías para ejecutar los microservicios. Primero ejecutar el de Pacientes y luego el de 
Turnos. Una vez que los servicios estén ejecutándose vamos a poder probarlos en postman.
Las siguientes son las configuraciones del aplication properties de ambos proyectos

Mientras que el microservicio Turnos se encuentra en el 9002
El microservicio Paciente se encuentra en el puerto 9001

3. Documentación de endpoints:
Se puede acceder a los endpoints para probarlos en una conexión la local, en el siguiente archivo 
‘Microservicios_ Local.postman_collection’ Se puede descargar desde la siguiente ubicación y probarlos 
en postman:
https://drive.google.com/drive/folders/16TCiMoV8XF2eGc30Zr6INJkn7kcP53GR?usp=sharing
- Crear paciente: 
http://localhost:9001/paciente/crear
Este endpoint permite crear un nuevo registro de paciente. El cuerpo de la solicitud debe incluir 
los datos del paciente, y devuelve un mensaje confirmando la creación exitosa.
- Mostrar pacientes:
http://localhost:9001/pacientes/traer
Recupera una lista de todos los pacientes almacenados en la base de datos.
- Borrar Paciente:
- http://localhost:9001/pacientes/borrar/4
Elimina el paciente con el ID especificado en la URL. Devuelve un mensaje confirmando la 
eliminación exitosa.
- Editar paciente:
http://localhost:9001/pacientes/editar/6
Permite editar la información de un paciente existente. Se requiere el ID original en la URL y los 
nuevos datos en el cuerpo de la solicitud. Devuelve los datos del paciente actualizado.
- Mostrar Paciente por id:
http://localhost:9001/pacientes/traer/1
Recupera la información de un paciente específico utilizando su ID.
- Crear turno:
- http://localhost:9002/turno/crear
Este endpoint permite crear un nuevo turno. Se utiliza un DTO para enviar la información del 
turno. El cuerpo de la solicitud debe incluir la fecha, el tratamiento y el DNI del paciente, y la 
api buscará el nombre del paciente utilizando ese DNI. Devuelve un mensaje confirmando la 
creación del turno.
- Mostrar Turnos:
http://localhost:9002/turno/traer
Recupera una lista de todos los turnos almacenados en la base de datos.
- Eliminar turno:
http://localhost:9002/turno/borrar/6
Elimina el turno con el ID especificado en la URL. Devuelve un mensaje confirmando la 
eliminación exitosa.
- Editar turno:
http://localhost:9002/turno/editar/3
Permite editar la información de un turno existente. Se requiere el ID original en la URL y los 
nuevos datos en el cuerpo de la solicitud. Devuelve los datos del turno actualizado.
- Mostrar turno específico:
http://localhost:9002/turno/traer/1
Recupera la información de un turno específico utilizando su ID
