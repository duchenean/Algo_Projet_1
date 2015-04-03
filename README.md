##Manipulation d’expressions arithmétiques


### To do list : Programme
1. Implémenter l'interface TreeBuilderIF => Voir annexe : buildExpressionTree
2. Implémenter l'interface ExprIF
  - getReducedTree()
  - toString()
3. Tester les 2 implémentations 
4. Implémenter l'algorithme récursif, parcourant l'AST 
5. Implémenter la résolution de l'AST 
6. Tester la résolution de l'expression mathématique
7. Implémenter la classe Main, permettant d'entrer des arguments en paramètre
8. Tester le programme et les performances
9. Effectuer des optimisations au niveau de l'expression mathématique
  - Simplifications *évidentes* => 1*a = a ; 0+a = a ; ...
10. Retester les performances 

### To do list : Rapport
- Diagramme de classes
- Choix d'implémentation
- Complexité des différentes opérations des interfaces **TreeBuilderIF** & **ExprIF**
- Difficultés rencontrées 

### Choix de l'implémentation de l'arbre 
**Plusieurs choix possibles :**
- Structure chainée
- Tableau dynamique

> À prioris la structure chainée semble la plus polyvalente, complexité spatiale en Theta(n) => À confirmer !

### Contraintes
- Implémentation de l’interface ExprIF
- La/les classes liées à la structure de l’arbre **dans le package _exprTree_.**
- La classe qui crée l’AST à partir d’une expression s’appelle *TreeBuilder*. Elle implémente l’interface *TreeBuilderIF* et se trouve dans le package *builder*.
- Le constructeur de *TreeBuilder* prend **un String** qui représente l’expression arithmétique.
- Les opérateurs sont **+, -, * et /.**
- *getReducedTree*, simplifie l’arbre courant (en renvoyant un arbre simplifié), ou sa/ses méthode(s) auxiliaire(s) pour réaliser cette opération, ainsi que la méthode toString, qui permet de convertir un arbre en une expression complètement parenthésée sous forme de String, **sont à appeler de manière récursive (utiliser un parcours adéquat).**

>  /!\ LE CODE DOIT ÊTRE CLAIR ET FACILEMENT MAINTENABLE


### Spécifications

#### Format d'entrée
 - 1 expression / ligne ;
 - Expressions complètement parenthésées ;
 - Chaque élément de l’expression est séparé par un espace. Par exemple : `( 5 * ( 4 / 2 ) )`

#### Format de sortie
 - Pas d’espace entre les éléments d’une expression. Il y a “=” entre 2 expressions consécutives avec un espace avant et un autre après. Par exemple : `(5.0*(4.0/2.0)) = (5.0*2.0) = 10.0`
 - Représentation en String des nombres est celle de `Double.toString(double d)`.


