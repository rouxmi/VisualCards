# Exercices

Modifiez ce projet pour rendre sa conception plus conforme aux meilleures pratiques (et mettre en oeuvre quelques unes). 

* Il faut en particulier commencer par séparer modèle, vue et controle et ajouter un observeur. 
* Il ne doit pas y avoir de références à des éléments de vue dans le modèle.
* Il ne doit pas y avoir besoin du l'option refresh du menu quand on fait une action qui change l'état du paquet.



## Pattern Command
Utilisez le pattern Command pour lier les menus et les outils aux actions qu'il est possible de le faire sur le jeu de carte.

## Pattern Factory
On veut pouvoir choisir un type de jeu de carte ? Scopa, Tarot, Belote, 52 cartes ?
Séparer l'image de la carte du modèle de la carte pour pouvoir changer de type de jeu de carte sans modifier le reste du code

Utiliser le même support pour l'affichage et les différentes fonctions. Ce qui est toujours valable c'est que les cartes
ont une couleur et une valeur. Mais ça peut changer en fonction du type de carte.

## Pattern Strategy
Utiliser le pattern Strategy pour permettde de choisir entre différentes méthodes de mélange des cartes (autre que shuffle de Collection).
[https://www.geeksforgeeks.org/shuffle-a-given-array-using-fisher-yates-shuffle-algorithm
](https://www.geeksforgeeks.org/shuffle-a-given-array-using-fisher-yates-shuffle-algorithm/?ref=rp)
[https://www.geeksforgeeks.org/shuffle-a-deck-of-cards-3/
](https://www.geeksforgeeks.org/shuffle-a-deck-of-cards-3/)


## Méthode

Vous clonerez le projet et à chaque séance de TP vous ferez au moins un commit et un push que vous commenterez pour indiquer ce que vous avez réalisé

## Pour exécuter le programme
* Clonez le projet
* Chargez le projet dans votre IDE (de préférence IntelliJ)
* Pour exécuter l'application faites mvn run en ligne de commande ou dans l'IDE




