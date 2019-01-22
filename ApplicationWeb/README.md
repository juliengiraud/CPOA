Projet de PHP par Julien GIRAUD et Matteo TALBY (G1S3) :
Au niveau du TP3 :
http://iutdoua-web.univ-lyon1.fr/~p1704709/projetPHP

Au niveau du TP4 :
http://iutdoua-web.univ-lyon1.fr/~p1704709/projetPHP2

Un gros travail complémentaire effectué. Une grosse erreur sur les requètes. 

TD3

Controleur accueil : il est dommage de récupérer en base toutes les catégorie pour ensuite les balayer pour trouver les information d'une catégorie. Pourquoi ne pas faire une simple requète avec en paramètre l'id de la catégorie?  

CategorieDAO : vous ne séparez pas les données de la requète. Vous n'êtes pas protégé contre les injections SQL. Idem pour photoDAO

PhotoDAO : il existe dans DAO une fonction insertid  qui  permet de récupérer l'id après un insert et donc de mettre à jour la base avec un update. La méthode que vous utilisez est basée sur l'hypothèse que id sera toujours celui qui suit le plus grand enregistré en base. Cette hypothèse n'est pas vraie. Si vous faites un insert suivit d'un delete, le prochain incrément sera de 2 et pas de 1. 

Vue accueil : vous n'utilisez pas la vue alert pour afficher les messages

TD4

Controleur addphoto : vous ne testez pas le résultat du moveuploadedfile.

Controleur connexion : vous utiliser des POST comme variable de requète sans les valider. Idem pour le controlleur inscription

Controleur deconnexion : vous ne faites pas une redirection par index.PH au moyen d'un header location

Vue connexion : vous n'affichez pas les valeurs entrées en cas d'erreur
