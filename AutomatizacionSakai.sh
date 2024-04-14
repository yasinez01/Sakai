#!/bin/bash
git clone https://github.com/yasinez01/Sakai
mvn -f Sakai/kernel install
mvn -f Sakai/kernel package
echo "Los entregables se encuentran en: "
find Sakai/kernel -name "target"
echo "El analisis:"
~/pmd-bin-7.0.0/bin/pmd check -d Sakai/kernel/kernel-test/src/main/java/org/sakaiproject/test/. -R rulesets/java/quickstart.xml -f text