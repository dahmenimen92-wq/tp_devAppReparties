##Résultat TP1 Activité 1
Utilisation des sockets en mode connecté pour établir la connexion entre le client et le serveur.
Lancer le serveur puis le client pour tester.
La connexion est réussie.

##Résultat TP1 Activité 2
Faire une multiplication côté serveur par 5 après l’envoi d’une valeur côté client.

##Résultat TP1 Activité 3
Développer une calculatrice avec 4 services de calcul (addition, soustraction, multiplication, division), selon le choix du client et la valeur envoyée.
Utilisation du tampon (BufferedReader/Writer) car il y a deux valeurs à envoyer (nombre et option).
Le serveur effectue le calcul et renvoie le résultat au client.

##Résultat TP2 Activité 1
Amélioration de la calculatrice : le client envoie trois chaînes de caractères au serveur : deux nombres et un opérateur.
Le serveur effectue le calcul correspondant et renvoie le résultat au client.

Le serveur reçoit trois chaînes de caractères 
Il utilise un InputStream pour lire le flux de données en octets depuis le client.
Un InputStreamReader transforme ce flux d’octets en caractères 
Un BufferedReader permet de stocker ces caractères dans un buffer et de lire le flux ligne par ligne.
Le serveur effectue ensuite le calcul correspondant à l’opération reçue.
Pour envoyer le résultat au client :
Il utilise un OutputStream pour écrire le flux de sortie en octets.
Un PrintWriter écrit le résultat sous forme de caractères dans ce flux, ce qui permet de transmettre correctement le résultat, même s’il comporte plusieurs octets.

(meme principe cote client)

##Résultat TP2 Activité 2
Amélioration de l'activité précédente : au lieu d'envoyer 3 chaînes de caractères, on envoie un objet qui contient les deux valeurs et l'opération.  
On construit une classe `Formule` qui implémente l'interface `Serializable`, contenant un constructeur pour ces variables et des méthodes getter pour les récupérer.

Pour que le client envoie un objet au serveur :  
- OutputStream os : pour le flux de sortie des octets  
- ObjectOutputStream oos : enveloppe os pour écrire des objets et les convertir en octets (sérialisation) avant l'envoi au serveur

Pour que le serveur reçoive cet objet :  
- InputStream is : flux d'entrée des octets  
- ObjectInputStream : convertit les octets en objet pour le lire (désérialisation)

Pour l'envoi / réception du résultat :  
- On utilise une chaîne de caractères comme dans l'activité précédente








