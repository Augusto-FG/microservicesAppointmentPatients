<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <style>
    body {
      font-family: Arial, sans-serif;
      line-height: 1.6;
      background-color: #f4f4f4;
      padding: 20px;
    }
    h1, h2 {
      color: #333;
      text-align: center;
    }
    h1 {
      font-size: 2.5em;
    }
    h2 {
      font-size: 1.8em;
    }
    p {
      margin-bottom: 20px;
    }
    ul {
      list-style-type: disc;
      margin-left: 20px;
    }
    code {
      background-color: #eef;
      padding: 2px 6px;
      border-radius: 5px;
    }
    .container {
      background-color: #fff;
      border-radius: 10px;
      box-shadow: 0 2px 5px rgba(0,0,0,0.1);
      padding: 20px;
      max-width: 800px;
      margin: auto;
    }
    .steps {
      margin-top: 40px;
    }
    .steps ol {
      padding-left: 20px;
    }
    a {
      color: #007bff;
      text-decoration: none;
    }
    a:hover {
      text-decoration: underline;
    }
  </style>
  <title>Microservicios de Pacientes y Turnos</title>
</head>
<body>

  <div class="container">
    <h1>Microservicios de Pacientes y Turnos</h1>
    
    <p>Estos microservicios han sido diseñados para gestionar las operaciones relacionadas con la administración de pacientes y turnos médicos, aprovechando una arquitectura de microservicios distribuida.</p>
    
    <h2>Microservicios</h2>
    <ul>
      <li><strong>Microservicio de Pacientes</strong>: Este servicio se encarga de gestionar la información de los pacientes, como su registro, edición y eliminación. Todas las solicitudes son procesadas mediante endpoints REST, lo que permite interactuar con una base de datos SQL Server, en este caso estamos usando phpMyAdmin para gestionarlas.</li>
      <li><strong>Microservicio de Turnos</strong>: A través de este servicio, es posible crear, modificar y consultar turnos médicos. Funciona de manera independiente al servicio de pacientes, aunque también se conecta a su propia base de datos SQL.</li>
    </ul>

    <div class="steps">
      <h2>Pasos para ejecutar los microservicios</h2>
      
      <ol>
        <li><strong>Conexión de base de datos:</strong> Necesitamos una herramienta como XAMPP para activar los servicios de MySQL y Apache:
          <ul>
            <li>Dirígete a <a href="http://localhost/phpmyadmin/index.php?route=/">phpMyAdmin</a> y crea dos bases de datos: <code>servicio_paciente</code> y <code>servicio_turno</code>.</li>
            <li>Las tablas se crearán automáticamente cuando ejecutes el backend.</li>
          </ul>
        </li>

        <li><strong>Ejecución de microservicios:</strong> Abre los dos proyectos en un IDE (como NetBeans o IntelliJ IDEA Community Edition) y ejecuta primero el microservicio de Pacientes y luego el de Turnos.</li>

        <li><strong>Configuraciones de puertos:</strong>
          <ul>
            <li>El microservicio de Pacientes está en el puerto <code>9001</code>.</li>
            <li>El microservicio de Turnos está en el puerto <code>9002</code>.</li>
          </ul>
        </li>

        <li><strong>Documentación de endpoints:</strong> Los endpoints se pueden probar en Postman descargando la colección desde el siguiente enlace: 
          <a href="https://drive.google.com/drive/folders/16TCiMoV8XF2eGc30Zr6INJkn7kcP53GR?usp=sharing">Microservicios_Local.postman_collection</a>.
        </li>
      </ol>
    </div>

    <h2>Endpoints principales</h2>
    <h3>Microservicio de Pacientes</h3>
    <ul>
      <li>Crear paciente: <code>POST</code> <a href="http://localhost:9001/paciente/crear">http://localhost:9001/paciente/crear</a></li>
      <li>Mostrar pacientes: <code>GET</code> <a href="http://localhost:9001/pacientes/traer">http://localhost:9001/pacientes/traer</a></li>
      <li>Borrar paciente: <code>DELETE</code> <a href="http://localhost:9001/pacientes/borrar/4">http://localhost:9001/pacientes/borrar/4</a></li>
      <li>Editar paciente: <code>PUT</code> <a href="http://localhost:9001/pacientes/editar/6">http://localhost:9001/pacientes/editar/6</a></li>
      <li>Mostrar paciente por ID: <code>GET</code> <a href="http://localhost:9001/pacientes/traer/1">http://localhost:9001/pacientes/traer/1</a></li>
    </ul>

    <h3>Microservicio de Turnos</h3>
    <ul>
      <li>Crear turno: <code>POST</code> <a href="http://localhost:9002/turno/crear">http://localhost:9002/turno/crear</a></li>
      <li>Mostrar turnos: <code>GET</code> <a href="http://localhost:9002/turno/traer">http://localhost:9002/turno/traer</a></li>
      <li>Eliminar turno: <code>DELETE</code> <a href="http://localhost:9002/turno/borrar/6">http://localhost:9002/turno/borrar/6</a></li>
      <li>Editar turno: <code>PUT</code> <a href="http://localhost:9002/turno/editar/3">http://localhost:9002/turno/editar/3</a></li>
      <li>Mostrar turno específico: <code>GET</code> <a href="http://localhost:9002/turno/traer/1">http://localhost:9002/turno/traer/1</a></li>
    </ul>
  </div>

</body>
</html>
