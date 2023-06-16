# Point de vigilences de l'application

## Niveau global

Faire attention au fonctionnement de la librairie pickomino-jar et à sa bonne intégration(retours de fonctions, possibilités,...)

Faire attention a la bonne liaison de l'application avec le serveur(affichage,transferts de données,...)

Faire attention à la synchronisation vue-serveur et modele-serveur

## Niveau Vues

### Vue menu

Faire attention aux  liens entre nb_players et la vue qui sera affichée

Créer une partie en ligne doit impérativement être bien lié au modele 

Rejoindre une partie doit bien adapter la vue aux données du salon(nb_joueurs notamment)

### Vue 2j,3j,4j

Attention à la bonne intégration de tout les élements du jeu dans chaque vue

Faire attention à ce que nos fonctionnalités soient dépendantes des phases de la partie

Faire attention à ce que les vues s'adaptent visuellement aux phases et au déroulé de la partie 

## Niveau Modèle

Vérifier que le modèle respece bien sa spécification et l'UML correspondant 

S'assurer du bon typage de toutes les variables et des retours de méthodes

s'assurer de la bonne privatisation des variables/méthodes

S'assurer de la bonne implémentation de toutes les méthodes 

S'assurer IMPERATIVEMENT de la bonne intégration de la libraire pickomino-jar dans le modèle

## Niveau Controleur

### Controleur Join_game

vérifier l'existence et la disponibilité de l'id du salon que l'on essaie de rejoindre 

vérifier que la clé du salon est la bonne et est au bon format

vérifier que la bonne partie est bien rejointe

vérifier que le "lien de connexion est bien actif"

### Controleur Launch_game

vérifier que l'id et la clé reçu sont bien ceux du salon réservé

vérifier que le jeu se lance bien dans le mode choisi

vérifier que le jeu lance bien la partie avec le bon nombre de joueurs

vérifier que le jeu ne démarre pas la partie si le nombre de joueurs n'est pas le bon
