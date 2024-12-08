## Reto 1 - Elecciones
 
Este ejercicio tiene como fin hacer uso de **herencia** y **polimorfismo** en Java.
> Se requiere desarrollar un sistema para **gestionar unas elecciones** utilizando el modelo de **votos transferibles**. El proceso de recuento se realiza de la siguiente manera :
 
> - **Primer Recuento**: Se contabiliza el primer candidato de cada papeleta.
> - **Mayoría Absoluta**: Si un candidato obtiene la mayoría absoluta de los votos, se declara ganador y el proceso termina.
> - **Eliminación y Recuento**: Si ningún candidato obtiene la mayoría absoluta, se elimina el candidato con el menor número de votos y se realiza un nuevo recuento, considerando la siguiente preferencia en las papeletas de los votantes que eligieron al candidato eliminado.
> - **Validación de Papeletas**: Es necesario comprobar que las papeletas son correctas, es decir, que contienen una lista válida de candidatos ordenados por preferencia.
 
 
### Uso
 
Primero compile el programa con el comando :
 
```
make
```
 
Lance el programa :
 
```
./a.out
```
 
### Output
 
```
[Ronda 1] Ningún candidato tiene mayoría absoluta.
El candidato Pepe (0 votos) ha sido eliminado.
No se han transferido votos de Pepe
[Ronda 2] Ningún candidato tiene mayoría absoluta.
El candidato Luis (1 votos) ha sido eliminado.
Se han transferido 1 votos de Luis a Carla
[Ronda 3] Ningún candidato tiene mayoría absoluta.
El candidato Juan (2 votos) ha sido eliminado.
Se han transferido 2 votos de Juan a Carla
El candidato Carla tiene mayorîa absoluta con 4 votos.
 
Resultados del recuento
-----------------------
 
Carla: 4 votos.
Rosa: 3 votos.
```
