#clonar
git clone https://github.com/sakaiproject/sakai

#acceder al proyecto
cd sakai
#!/bin/bash

# Nombre del archivo pom.xml
POM_FILE="pom.xml"

# Actualizar los módulos dentro de los perfiles all y experimental
sed -i '/<id>all<\/id>/,/<\/modules>/ s|<module>.*<\/module>||g' $POM_FILE
sed -i '/<id>all<\/id>/,/<\/modules>/ s|<\/modules>|<module>kernel<\/module>\n<\/modules>|' $POM_FILE

sed -i '/<id>experimental<\/id>/,/<\/modules>/ s|<module>.*<\/module>||g' $POM_FILE
sed -i '/<id>experimental<\/id>/,/<\/modules>/ s|<\/modules>|<module>kernel<\/module>\n<\/modules>|' $POM_FILE


# ejecucion del mvn
mvn install
