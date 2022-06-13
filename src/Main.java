import java.io.IOException;

public class Main {

    /**
     * Le main pour tester l'algorithme du point fixe
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {

//        GrapheListe grapheListe = new GrapheListe();
//        grapheListe.ajouterArc("A", "B", 1);
//        grapheListe.ajouterArc("A", "C", 5);
//        grapheListe.ajouterArc("B", "C", 3);
//        grapheListe.ajouterArc("B", "D", 1);
//        grapheListe.ajouterArc("C", "E", 3);
//        grapheListe.ajouterArc("D", "C", 1);
//        grapheListe.ajouterArc("D", "E", 9);
//        System.out.println(grapheListe.toString());
//        System.out.println(grapheListe.toGraphviz());
//
//        BellmanFord bellmanFord = new BellmanFord();
//        Valeur valeur = bellmanFord.resoudre(grapheListe, "A");
//        System.out.println(valeur);
//        System.out.println(valeur.calculerChemin("E"));
//
//        Dijkstra dijkstra = new Dijkstra();
//        Valeur valeur1 = dijkstra.resoudre(grapheListe, "A");
//        System.out.println(valeur1);

        /**
         *
         * q 21:
         * Djikstra : verifie chaque points
         * BellmanFord : verifie que sur 2 iterations les resultats sont pareils
         *
         * q22 :
         * l'algo de Djikstra a plus d'iterations que l'autre
         *
         */

        GrapheListe grapheListe1 = new GrapheListe("exemples/Graphe1.txt");
        BellmanFord bellmanFord1 = new BellmanFord();
        long time1 = System.nanoTime();
        Valeur valeur2 = bellmanFord1.resoudre(grapheListe1, "A");
        time1 = System.nanoTime()-time1;
        System.out.println(time1/1e6);

        Dijkstra dijkstra1 = new Dijkstra();
        time1 = System.nanoTime();
        Valeur valeur3 = dijkstra1.resoudre(grapheListe1, "A");
        time1 = System.nanoTime()-time1;
        System.out.println(time1/1e6);

        /**
         * q 23 : L'algo Djikstra est bien plus rapide que l'autre algo quand le graphe comporte beaucoup de noeuds
         * puisqu'il ne traite pas les noeuds deja traites
         *
         * Résultats avec le Graphe1:
         * Djikstra 36.2453
         * BellmanFord 0.2954
         * en millisecondes
         */

    }

}
