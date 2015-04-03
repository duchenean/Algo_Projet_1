#Manipulation d’expressions arithmétiques


## To do list : Programme
1. Implémenter l'interface TreeBuilderIF => Voir annexe : buildExpressionTree
2. Implémenter l'interface ExprIF
  * getReducedTree()
  * toString()
3. Tester les 2 implémentations 
4. Implémenter l'algorithme récursif, parcourant l'AST 
5. Implémenter la résolution de l'AST 
6. Tester la résolution de l'expression mathématique
7. Implémenter la classe Main, permettant d'entrer des arguments en paramètre
8. Tester le programme et les performances
9. Effectuer des optimisations au niveau de l'expression mathématique
  * Simplifications *évidentes* => 1*a = a ; 0+a = a ; ...
10. Retester les performances 

## To do list : Rapport
* Diagramme de classes
* Choix d'implémentation
* Complexité des différentes opérations des interfaces *TreeBuilderIF* & *ExprIF*
* Difficultés rencontrées 

## Choix de l'implémentation de l'arbre 
**Plusieurs choix possibles :**
* Structure chainée
* Tableau dynamique

*À prioris* la structure chainée semble la plus polyvalente, complexité spatiale en Theta(n)
=> À confirmer !


