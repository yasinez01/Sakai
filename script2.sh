#!/bin/bash

# Directorio que contiene los archivos a procesar, en mi caso lo tengo en Documentos
DIRECTORIO="/home/alumno/Documentos/sakai/"

# Recorrer todos los archivos dentro del directorio
find "$DIRECTORIO" -type f -exec sed -i 's/\t/    /g' {} +

java -jar /home/alumno/Documentos/checkstyle-10.15.0-all.jar -c /home/alumno/Documentos/checkstyle.xml /home/alumno/Documentos/sakai 


#entregables
cd sakai
mvn clean install sakai:deploy -Dmaven.test.skip=true
find /home/alumno/Documentos/sakai/ -name "target"