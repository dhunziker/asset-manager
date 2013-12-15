#!/bin/bash

if [ ! -f $JAVA_HOME/bin/java ]
then
    JAVA_HOME=/share/Dennis/Applications/ejre1.7.0_06
fi

echo JAVA_HOME set to $JAVA_HOME

$JAVA_HOME/bin/java -Declipselink.persistencexml=lib/am-model-plain-jpa-1.0-SNAPSHOT.jar!/META-INF/persistence.xml -jar am-updater-1.0-SNAPSHOT.one-jar.jar