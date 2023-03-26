# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso 2022/23)
Autor/a: Manuel J Sanchez Garcia  uvus: mansangar13


## Estructura de las carpetas del proyecto

* **/src**: Directorio con el código fuente.
  * **fp.ajedrez**: Paquete que contiene los tipos del proyecto.
  * **fp.ajedrez.test**: Paquete que contiene las clases de test del proyecto.
  * **fp.utiles**:  Paquete que contiene las clases de utilidad. 
* **/data**: Contiene el dataset del proyecto.
* **/doc**: Contiene este archivo.

## Estructura del *dataset*

El dataset original Pokemon Gen 1 se puede obtener de la URL: http://kaggle.com/ecapelari/pokemon-gen1 . Originalmente tiene 12 columnas y cada fila contiene datos sobre un pokemon. El dataset usado en este proyecto tiene 14 columna, 12 se han tomado del dataset original, y dos más, la fecha de aparicion, que se ha generado de forma aleatoria, y las habilidades originales de los pokemon. A continuación se describen las 13 columnas del dataset:

* **numberP**: de tipo Integer,  indica el número de la pokédex de ese pokemon.
* **name**: de tipo String, indica el nombre que recibe el pokemon.
* **Type1**: de tipo Type, indica el primer tipo del pokemon de entre los 16 que hay.
* **Type2**: de tipo Type, indica el segundo tipo del pokemon de entre los 16 que hay.
* **fA**: de tipo DateTime, indica la primera fecha de aparicion del pokemon.
* **HP**: de tipo Integer, indica los stats en salud que tiene le pokemon.
* **Attack**: de tipo Integer, indica los stats en ataque que tiene le pokemon.
* **Defense**: de tipo Integer, indica los stats en defensa que tiene le pokemon.
* **SpAtk**: de tipo Integer, indica los stats en ataque especial que tiene le pokemon.
* **SpDef**: de tipo Integer, indica los stats en defensa especial que tiene le pokemon.
* **Speed**: de tipo Integer, indica los stats en velocidad que tiene le pokemon.
* **Stage**: de tipo Integer, indica el estado de evolucion del pokemon. Primera evolucion, segunda o tercera. 
* **Legendary**: de tipo Boolean,  indica si el pokemon es o no legendario.
* **Abilities**: de tipo List,  indica las habilidades del pokemon.


## Tipos implementados

Los tipos que se han implementado en el proyecto son los siguientes:

### Tipo Base - Pokemon
Representa una partida de ajedrez concreta.
**Propiedades**:
- Estan descritas en la estructura del dataset, todas son consultables y modificables, aunque realmente no tendria sentido modificar un pokemon. 

**Propiedades derivadas**:
- **TotalStats**: de tipo Integer, es la suma de todas las stats del pokemon, generalmente cuanto mayor stats tiene un pokemon, mas fuerte es.

- **IsPseudiLegendary**: de tipo Boolean, se dice que si un pokemon tiene 600 o mas del total de sus estadisticas es pseudolegendario pues a pesar de no serlo, se puede equipara su poder con un legendario.

**Constructores**: 

- C1: Tiene un parámetro por cada propiedad básica del tipo.
- C2: Crea un objeto de tipo Pokemon con sus atributos basicos, name, type1 y type 2

**Restricciones**:
 
- R1: Las fecha de aparicion de los pokemon deben estar entre el 1 de enero de 1996 a las 00:00:00 y el 1 de enero de 2023 a las 00:00:00.
- R2: Un pokemon debe estar entre los 1010 totales que existen.
- R3: El nombre de un pokemon nunca puede estar vacío.

**Criterio de igualdad**: Dos pokemon son iguales si todas sus propiedades lo son.

**Criterio de ordenación**: Por numberP y por name.


#### Tipos auxiliares

- Tipo Type, enumerado. Puede tomar los valores GRASS, POISON, DRAGON, FIRE, FLYING, WATER, ELECTRIC, NORMAL,  GROUND, BUG, FIGHTING, PSYCHIC, ROCK, GHOST, FAIRY, NT2. (Como no todos los pokemon tienen dos tipos, el tipo NT2 significa No Type 2)




































































































































