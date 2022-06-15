package algorithmes;

import graphes.GrapheListe;

import java.io.IOException;

public class Experimentation {

    public static void main(String[] args) throws IOException {

//        // on crée un graphe boucle represente dans la figure 10
//        GrapheListe grapheListe = new GrapheListe();
//        grapheListe.ajouterArc("A", "B", 20);
//        grapheListe.ajouterArc("A", "D", 3);
//        grapheListe.ajouterArc("D", "C", 4);
//        grapheListe.ajouterArc("C", "B", 2);
//        grapheListe.ajouterArc("B", "G", 10);
//        grapheListe.ajouterArc("G", "F", 5);
//        grapheListe.ajouterArc("F", "E", 3);
//
//        // on cherche le chemin minimale avec l'algorithme de bellman-ford
//        BellmanFord bellmanFord = new BellmanFord();
//        bellmanFord.resoudre(grapheListe, "A");
//
//        // on cherche le chemin minimale avec l'algorithme de dijkstra
//        Dijkstra dijkstra = new Dijkstra();
//        dijkstra.resoudre(grapheListe, "A");

        /**
         *
         * Q21:
         * Djikstra : verifie chaque arc de chaque noeud du graphe même si les chemins les plus courts sont trouvés
         * BellmanFord : vérifie que entre chaque itération, les couts de chaque chemins sont identiques pour s'arrêter
         *
         * Q22 :
         * On remarque que l'algorithme de Dijsktra a plus d'itération que l'algorithme de point fixe pour ce graphe
         *
         */

//        // de 10 a 90
//        for (int i = 1; i < 10; i++) {
//
//            System.out.println("Graphe de taille " + i + "0");
//
//            GrapheListe grapheListe = new GrapheListe("exemples/Graphe" + i + "5.txt");
//
//            // calcul du temps d'execution de l'algorithme du point fixe en nanosecondes
//            BellmanFord bellmanFord = new BellmanFord();
//            long time = System.nanoTime();
//            bellmanFord.resoudre(grapheListe, "1");
//            time = System.nanoTime() - time;
//
//            System.out.println("Temps d'exécution de l'algorithme du point fixe: " + (time / 1e6) + "ms");
//
//            // calcul du temps d'execution de l'algorithme de dijkstra en nanosecondes
//            Dijkstra dijkstra = new Dijkstra();
//            time = System.nanoTime();
//            dijkstra.resoudre(grapheListe, "1");
//            time = System.nanoTime() - time;
//
//            System.out.println("Temps d'exécution de l'algorithme de Dijsktra: " + (time / 1e6) + "ms");
//
//            System.out.println("=====================================================================================");
//
//        }

//        // de 100 a 900
//        for (int i = 10; i < 100; i+=10) {
//
//            System.out.println("Graphe de taille " + i + "0");
//
//            GrapheListe grapheListe = new GrapheListe("exemples/Graphe105.txt");
//
//            // calcul du temps d'execution de l'algorithme du point fixe en nanosecondes
//            BellmanFord bellmanFord = new BellmanFord();
//            long time = System.nanoTime();
//            bellmanFord.resoudre(grapheListe, "1");
//            time = System.nanoTime() - time;
//
//            System.out.println("Temps d'exécution de l'algorithme du point fixe: " + (time / 1e6) + "ms");
//
//            // calcul du temps d'execution de l'algorithme de dijkstra en nanosecondes
//            Dijkstra dijkstra = new Dijkstra();
//            time = System.nanoTime();
//            dijkstra.resoudre(grapheListe, "1");
//            time = System.nanoTime() - time;
//
//            System.out.println("Temps d'exécution de l'algorithme de Dijsktra: " + (time / 1e6) + "ms");
//
//            System.out.println("=====================================================================================");
//
//        }

        /**
         * q 23 : L'algo Djikstra est bien plus rapide que l'autre algo quand le graphe comporte beaucoup de noeuds
         * puisqu'il ne traite pas les noeuds deja traites
         *
         * Résultats avec le Graphe1:
         * Djikstra 0.2954
         * algorithmes.BellmanFord 36.2453
         * en millisecondes
         */

        int TAILLE_MAX = 10000;
        int PAS = 1000;

        int NB_ITERATION = TAILLE_MAX / PAS;
        long sommeBellman = 0;
        long sommeDijsktra = 0;

        for (int i = 0; i <= TAILLE_MAX; i += PAS) {

            long time = System.nanoTime();
            GrapheListe grapheAleatoire = GrapheListe.genererGraphe(i);
            time = System.nanoTime() - time;
            System.out.println("Temps de génération d'un graphe de taille " + i + ": " + (time / 1e6) + "ms");

            time = System.nanoTime();
            BellmanFord bellmanFord = new BellmanFord();
            Valeur valeur = bellmanFord.resoudre(grapheAleatoire, "1");
            time = System.nanoTime() - time;
            sommeBellman += time;

            System.out.println("Temps d'exécution de l'algorithme du point fixe: " + (time / 1e6) + "ms");
            System.out.println(valeur.calculerChemin(String.valueOf(i)));

            time = System.nanoTime();
            Dijkstra dijkstra = new Dijkstra();
            valeur = dijkstra.resoudre(grapheAleatoire, "1");
            time = System.nanoTime() - time;
            sommeDijsktra += time;

            System.out.println("Temps d'exécution de l'algorithme de Dijsktra: " + (time / 1e6) + "ms");
            System.out.println(valeur.calculerChemin(String.valueOf(i)));
            System.out.println("=====================================================================================");

        }

        System.out.println("=====================================================================================");
        System.out.println("Noeuds maximum: " + TAILLE_MAX);
        System.out.println("Pas entre chaque itération: " + PAS);
        System.out.println("Nombre itérations: " + NB_ITERATION);
        System.out.println("Moyenne Bellman-Ford: " + (sommeBellman / NB_ITERATION) / 1e6 + "ms");
        System.out.println("Moyenne Dijsktra: " + (sommeDijsktra / NB_ITERATION) / 1e6 + "ms");
        System.out.println("=====================================================================================");

    }

}
