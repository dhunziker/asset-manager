@echo off

if not exist "%JAVA_HOME%\bin\java.exe" (
	set JAVA_HOME="C:\Program Files\Java\jdk1.7.0_45"
)

echo JAVA_HOME set to %JAVA_HOME%

"%JAVA_HOME%\bin\java.exe" -Declipselink.persistencexml=lib/am-model-plain-jpa-1.0-SNAPSHOT.jar!/META-INF/persistence.xml -jar target/am-updater-1.0-SNAPSHOT.one-jar.jar