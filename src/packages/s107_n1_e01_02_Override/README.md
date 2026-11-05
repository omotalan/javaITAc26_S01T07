# Override
**Descripció**: Sprint 1, Tasca 7, Nivell 1, Exercicis 1 i 2

## 📌 Anotacions bàsiques
```
Exercici 1 - Override

Crea una jerarquia d’objectes amb tres classes: Treballador, TreballadorOnline i TreballadorPresencial.

La classe Treballador té els atributs nom, cognom, preu/hora, i el mètode calcularSou() que rep per paràmetre el nombre d'hores treballades i el multiplica pel preu/hora. Les classes filles l'han de sobreescriure, emprant @Override.

Des del main() de la classe Principal, fes les invocacions necessàries per demostrar el funcionament de l’anotació @Override.

En els treballadors presencials, el mètode per calcular el seu sou, rebrà per paràmetre el nombre d’hores treballades al mes. A l’hora de calcular el sou es multiplicarà el nombre d’hores treballades pel preu/hora, més el valor d'un atribut static anomenat benzina que afegirem en aquesta classe.

En els treballadors online, el mètode per calcular el seu sou rebrà per paràmetre el nombre d'hores treballades al mes. A l'hora de calcular el sou es multiplicarà el nombre d'hores treballades pel preu/hora i se li sumarà el preu de la tarifa plana d'Internet, que serà una constant de la classe TreballadorOnline.

Exercici 2 - Deprecated

Afegeix a les classes filles alguns mètodes obsolets (deprecated), i utilitza l’anotació corresponent. Invoca des d'una classe externa els mètodes obsolets, suprimint mitjançant l'anotació corresponent els “warnings” per ser obsolets.
```

## ✨ Funcionalitats (si és aplicable)
Dins el Main jo demostro els 3 casos, i el polimorfisme al definir la classe Treballador
(normalment no calria crear un objecte pare i inicialitzar l'objecte fill).

## 🛠 Tecnologies
- Backend: Java

## 🚀 Instal·lació i Execució
1. Clonar el repositori: `git clone javaITAc26_S01T07`
2. Execució dels tests des del terminal:
   2.1. `javac -d out src/packages/s107_n1_e01_02_Override/*.java`
   2.2. `java -cp out s107_n1_e01_02_Override.Main`


## 📸 Demo
```bash
alan@alan-Vivobook-ASUSLaptop-M1502YA-M1502YA:~/alan_projects/JavaBootcamp/javaITAc26_S01T07$ javac -d out src/packages/s107_n1_e01_02_Override/*.java
Note: src/packages/s107_n1_e01_02_Override/Main.java uses or overrides a deprecated API.
Note: Recompile with -Xlint:deprecation for details.
```



