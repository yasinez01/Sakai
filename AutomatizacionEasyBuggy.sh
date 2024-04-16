git clone https://github.com/k-tamura/easybuggy.git
mvn -f easybuggy compile
mvn -f easybuggy package
echo "Los entregables se encuentran en: "
find easybuggy -name "target"
echo "El analisis:"
~/pmd-bin-7.0.0/bin/pmd check -d easybuggy/. -R rulesets/java/quickstart.xml -f text