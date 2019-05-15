# EncryptionAlgorithms
Implementación de: Algoritmo Playfair y Análisis por frecuencia polialfabética.

## Prerrequisitos
* Sistema Unix.
* [JRE](https://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html) - Máquina virtual de JAVA.
* Consola de comandos Unix.

## Preparación
Se requiere el ejecutable *EncryptionAlgorithms.jar*. Puede obtenerse de dos maneras:
* Generar ejecutable *.jar* a partir del código fuente.
* Descargar la última versión del archivo [aquí](https://www.dropbox.com/s/jvwozqdvmknqx5e/EncryptionAlgorithms.jar?dl=0).
* En la ubicación del ejecutable deberá crear las carpetas contenedoras de archivos. Por ejemplo: Spanish/ English/ French/. Dichas carpetas contendrán los archivos de sus respectivos idiomas.
* El ejecutable está preparado para leer archivos dentro de subcarpetas. Ejemplo: Spanish/SinTiles Spanish/ConTildes.
* A cada archivo leído, sin importar el idioma, se le quitarán los espacios en blanco y todas sus letras se pasarán a mayúsculas.
* Los archivos deben estar códificados en UTF-8 sin BOM.

## Ejecución

### Desplegar menú inicial
```
java -jar EncryptionAlgorithms.jar
```
### Ver menú de ayuda
```
java -jar EncryptionAlgorithms.jar help
```
### Ayuda sobre algoritmo Playfair
```
java -jar EncryptionAlgorithms.jar pf
```
### Ayuda sobre Análisis por frecuencia polialfabética
```
java -jar EncryptionAlgorithms.jar afp
```

## Autores

* **Edson Ruiz** - [elhijodeed](https://www.linkedin.com/in/edson-ruiz-ramirez-04419911a)
* **Jairo Andrés Valencia** - [jaanvagu](https://www.linkedin.com/in/jaanvagu/)
