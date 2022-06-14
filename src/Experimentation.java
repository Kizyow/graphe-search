import java.io.IOException;

public class Experimentation {

    public static void main(String[] args) throws IOException {

        GrapheListe graphe1 = new GrapheListe();
        graphe1.ajouterArc("A", "B", 20);
        graphe1.ajouterArc("A", "D", 3);
        graphe1.ajouterArc("D", "C", 4);
        graphe1.ajouterArc("C", "B", 2);
        graphe1.ajouterArc("B", "G", 10);
        graphe1.ajouterArc("G", "F", 5);
        graphe1.ajouterArc("F", "E", 3);

        BellmanFord bellmanFord = new BellmanFord();
        bellmanFord.resoudre(graphe1, "A");
        Dijkstra dijkstra = new Dijkstra();
        dijkstra.resoudre(graphe1, "A");

        /**
         *
         * q 21:
         * Djikstra : verifie chaque arc de chaque noeud du graphe même si les chemins les plus courts sont trouvés
         * BellmanFord : vérifie que entre chaque itération, les couts de chaque chemins sont identiques pour s'arrêter
         *
         * q22 :
         * On remarque que l'algorithme de Dijsktra a plus d'itération que l'algorithme de point fixe pour ce graphe
         *
         */

        GrapheListe grapheListe = new GrapheListe("exemples/Graphe905.txt");

        long time = System.nanoTime();
        bellmanFord.resoudre(grapheListe, "1");
        time = System.nanoTime() - time;

        System.out.println("Temps d'exécution de l'algorithme du point fixe: " + (time / 1e6) + "ms");

        time = System.nanoTime();
        dijkstra.resoudre(grapheListe, "1");
        time = System.nanoTime() - time;

        System.out.println("Temps d'exécution de l'algorithme de Dijsktra: " + (time / 1e6) + "ms");

        /**
         * q 23 : L'algo Djikstra est bien plus rapide que l'autre algo quand le graphe comporte beaucoup de noeuds
         * puisqu'il ne traite pas les noeuds deja traites
         *
         * Résultats avec le Graphe1:
         * Djikstra 0.2954
         * BellmanFord 36.2453
         * en millisecondes
         */

    }

}
