**Introduccion**
Este repositorio es una implementacion de un servicio REST para un sistema de tienda en linea. Este servicio se comunica con la capa de presentación del sistema, proveyendo
la funcionalidad del calculo de las distancias desde un punto de distribución hasta la dirección de entrega de un producto que fue comprado en la tienda en linea, tambien calcula
el tiempo estimado de entrega teniendo en cuenta la distancia y ademas el precio del servicio de envío.
Si bien este componente de la aplicación esta diseñado para que se comunique con la capa de presentación, tambien se puede probar individualmente usando la herramienta postman o 
incluso puede ser aprovechado por otros sistemas usando el protocolo http/https.

**Requisitos Previos:**
  - **java 21.0.3 2024-04-16 LTS:** Se debe instalar esta version de java en la maquina donde se vaya a ejecutar el servicio. Configurar las variables de entorno path y JAVA_HOME.
  - **Wildfly 31.0.1:** Es un servidor de aplicaciones de código abierto que implementa las especificaciones de Java EE (Enterprise Edition), ahora conocido como Jakarta EE.
  - **IntelliJ IDEA Community Edition 2024.1.2**
  - **Maven:** configurar variables de entorno.
  - **API KEY para usar Google Maps:** https://youtu.be/2_HZObVbe-g?si=9zjKJ6a2GJ7wqgFi.

**Pasos para ejecutar el proyecto:**
  1. Clonar o descargar el repositorio: git clone "https://github.com/Lukas0310/API_REST_ubicacion.git".
  2. Abrir el proyecto con IntelliJ IDEA.
  3. Descargar las dependencias del proeycto usando el archivo POM.xml:** Esto por lo general se hace automaticamente en el momento en que se abre el proyecto con el IDE.
  4. En el IDE dar clic en la opcion "current file -> edit configuration -> add new -> Maven -> run -> wildfly:deploy -> ok.
  5. Copiar el API KEY de google en la variable API_KEY de la clase controlador EnvioRestController.
  6. En la linea de comandos integrada en el IDE moverse a la carpeta bin de wildfly.
  7. Ejecutar el comando "standalone.bat".
  8. En la parte superior de la interfaz del IDE dar clic en la opcion run (comando wildfly:deploy).

En este momento el servicio quedará activo en el puerto 8080 para http o 8443 para https.

**para invocar el servicio se puede utillizar la herramienta postman:**
  1. **Nombre del proyecto:** este nombre es el nombre de la carpeta raiz del proyecto y tambien debe ir en la URL. en este caso el nombre del proeycto es webapp-jaxrs.
  2. **En la URL poner una de las dos opciones:**
      - http: https://localhost:8443/webapp-jaxrs/api/envios/calcular
      - http: http://localhost:8080/webapp-jaxrs/api/envios/calcular
  3. **En el cuerpo de la sulicitud poner:**
     {
         "origen": "Pontificia Universidad Javeriana",
         "destino": "Aeropuerto Internacional El Dorado"
     }
  4. **El resultado esperado debe ser algo como:**
    {
        "costoEnvio": 59.375,
        "distanciaEnKm": 11.875,
        "tiempoEnMinutos": 22.233333333333334
    }

**NOTA:**
1. Tener en cuenta que las instrucciones anteriores sirven para ejecutar el proyecto de manera local.
2. Estas instrucciones sirven para probar el proyecto individualmente e independientemente de los demas proyectos que hacen parte del sistema de ventas en linea.
3. Si se desea ejecutar el proyecto junto con los demas componentes dirijirse a la documentacion general del sistema de ventas en linea.
4. Tener en cuenta que si se desea establecer el servicio para que sea accesible publicamente a través de internet se deben realizar configuraciones adicionales.

