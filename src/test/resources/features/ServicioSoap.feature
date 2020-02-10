#language: es
# encoding: iso-8859-1
#Author: jbuiles@qvision.com.co
Caracter�stica: Automatizar un servicio Soap

  Esquema del escenario: Consultar empleador
    Dado que el usuario ingrese la url del servicio <url>
    Cuando ingrese el mensaje con los datos
      | dominio   | tipoDocumento   | documento         |
      | <dominio> | <tipoDocumento> | <numeroDocumento> |
    Entonces ver� el c�digo de respuesta <codigoRespuesta>

    Ejemplos: 
      | url                                                   | dominio    | tipoDocumento | numeroDocumento | codigoRespuesta |
      | http://epsappslab.suramericana.com/EpsSuraWS/services | /EpsSuraWS | NI            |       800256161 |             200 |
