# MangerDesPomsResolveur
### Ce que j'ai réalisé du projet :
- [x] classes qui implémentent Liste
- [x] classes de tests unitaires
- [x] classe noeud et classe solveur
- [x] affichage de la première solution
- [x] BONUS affichage de toutes les solutions (car j'ai fail l'algo au départ)

### Réponses aux questions
#### 1. Question : quel est le type du tableau à utiliser ?
Réponse : un tableau de type Object[] (on le caste avec (E[])) donc au final, le "type" est E pour respecter la générécité

#### 2. Question : Selon vous, quelles sont les différences majeures entre `ListeTableau` et `ListeChainee` ?
Réponse : ListeTableau : tous les éléments ont une référence mémoire, pas optimisé pour les ajouts en masse, rapide pour une recherche d'un index
ListeChainee : optimisé pour les ajouts en masse, lent pour une recherche d'un élément, chaque élément permet de trouver le suivant
Conclusion : si on a une taille fixe pour une liste et qu'on doit chercher souvent des éléments ListeTableau est plus adapté
Si on a une taille variable et qu'on doit ajouter souvent des éléments ListeChainee est plus adapté, et moins couteux en mémoire

#### 
#### 3. Question : dans votre code, le type statique de vos références de liste et dictionnaires est-il celui de vos implémentations concrètes ? Pourquoi ?
Réponse : oui, dans mon cas par exemple j'ai utilisé directement le type ListeChainee, ListeTableau et DictionnaireChainee. Cela est dû au fait que je n'ai pas implémenté d'interface pour les listes et les dictionnaires. J'ai donc directement utilisé les classes concrètes.
sinon, j'aurai pu utiliser "Liste<Noeud> listeDeNoeuds = new ListeTableau<Noeud>();" ,là le type statique de la référence est Liste<Noeud> et le type dynamique est ListeTableau<Noeud>

###Avis sur le projet
Sujet sympa pour approcher les types de structure de données,
mais j'ai pas mal galérer sur la réalisation de l'algo pour trouver les solution (calculer fils n'était pas en soi compliquer si on modélisait correctement les noeuds)
Pour un prochain projet, réaliser une optimisation de l'algo pour trouver la solution de niveaux plus conséquent pourrait être intéressant.
