# MangerDesPomsResolveur
### Ce que j'ai réalisé du projet :
- [x] classes qui implémentent Liste
- [x] classes de tests unitaires
- [x] classe noeud et classe solveur
- [x] affichage de la première solution et de toutes les solutions

### Réponses aux questions
#### 1. Question : quel est le type du tableau à utiliser ?
Réponse : un tableau de type Object[] (on le caste avec (E[])) donc au final, le "type" est E pour respecter la générécité

#### 
#### 1. Question : dans votre code, le type statique de vos références de liste et dictionnaires est-il celui de vos implémentations concrètes ? Pourquoi ?
Réponse : oui, dans mon cas par exemple j'ai utilisé directement le type ListeChainee, ListeTableau et DictionnaireChainee. Cela est dû au fait que je n'ai pas implémenté d'interface pour les listes et les dictionnaires. J'ai donc directement utilisé les classes concrètes.
sinon, j'aurai pu utiliser Liste<Noeud> listeDeNoeuds = new ListeTableau<Noeud>();