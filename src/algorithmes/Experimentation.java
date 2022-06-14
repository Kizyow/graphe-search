package algorithmes;

import graphes.GrapheListe;

import java.io.IOException;

public class Experimentation {

    public static void main(String[] args) throws IOException {

//        graphes.GrapheListe graphe1 = new graphes.GrapheListe();
//        graphe1.ajouterArc("A", "B", 20);
//        graphe1.ajouterArc("A", "D", 3);
//        graphe1.ajouterArc("D", "C", 4);
//        graphe1.ajouterArc("C", "B", 2);
//        graphe1.ajouterArc("B", "G", 10);
//        graphe1.ajouterArc("G", "F", 5);
//        graphe1.ajouterArc("F", "E", 3);
//
//        algorithmes.BellmanFord bellmanFord = new algorithmes.BellmanFord();
//        bellmanFord.resoudre(graphe1, "A");
//        algorithmes.Dijkstra dijkstra = new algorithmes.Dijkstra();
//        dijkstra.resoudre(graphe1, "A");

        /**
         *
         * q 21:
         * Djikstra : verifie chaque arc de chaque noeud du graphe même si les chemins les plus courts sont trouvés
         * algorithmes.BellmanFord : vérifie que entre chaque itération, les couts de chaque chemins sont identiques pour s'arrêter
         *
         * q22 :
         * On remarque que l'algorithme de Dijsktra a plus d'itération que l'algorithme de point fixe pour ce graphe
         *
         */

//        graphes.GrapheListe grapheListe = new graphes.GrapheListe("exemples/Graphe905.txt");
//
//        long time = System.nanoTime();
//        bellmanFord.resoudre(grapheListe, "1");
//        time = System.nanoTime() - time;
//
//        System.out.println("Temps d'exécution de l'algorithme du point fixe: " + (time / 1e6) + "ms");
//
//        time = System.nanoTime();
//        dijkstra.resoudre(grapheListe, "1");
//        time = System.nanoTime() - time;
//
//        System.out.println("Temps d'exécution de l'algorithme de Dijsktra: " + (time / 1e6) + "ms");

        /**
         * q 23 : L'algo Djikstra est bien plus rapide que l'autre algo quand le graphe comporte beaucoup de noeuds
         * puisqu'il ne traite pas les noeuds deja traites
         *
         * Résultats avec le Graphe1:
         * Djikstra 0.2954
         * algorithmes.BellmanFord 36.2453
         * en millisecondes
         */

        for (int i = 0; i <= 1000; i += 100) {

            long time = System.nanoTime();
            GrapheListe grapheAleatoire = new GrapheListe(i);
            time = System.nanoTime() - time;
            System.out.println("Temps de génération d'un graphe de taille " + i + ": " + (time / 1e6) + "ms");

            time = System.nanoTime();
            BellmanFord bellmanFord = new BellmanFord();
            bellmanFord.resoudre(grapheAleatoire, "1");
            time = System.nanoTime() - time;

            System.out.println("Temps d'exécution de l'algorithme du point fixe: " + (time / 1e6) + "ms");

            time = System.nanoTime();
            Dijkstra dijkstra = new Dijkstra();
            dijkstra.resoudre(grapheAleatoire, "1");
            time = System.nanoTime() - time;

            System.out.println("Temps d'exécution de l'algorithme de Dijsktra: " + (time / 1e6) + "ms");
            System.out.println("=====================================================================================");

        }

    }

}
