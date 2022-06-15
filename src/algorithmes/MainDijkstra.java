package algorithmes;

import graphes.GrapheListe;

import java.io.IOException;
import java.util.List;

public class MainDijkstra {

    /**
     * Le main pour tester l'algorithme de Dijsktra
     *
     * @param args
     */
    public static void main(String[] args) {

        try {

            // on crée un graphe de 20 noeuds a partir d'un fichier
            GrapheListe graphe = new GrapheListe("exemples/Graphe25.txt");
            System.out.println(graphe.toString());
            System.out.println(graphe.toGraphviz());

            // et on utilise l'algorithme de Dijsktra partant du noeud 1
            Dijkstra dijkstra = new Dijkstra();
            Valeur solution = dijkstra.resoudre(graphe, "1");

            // on affiche la valeur minimale de chaque noeud
            System.out.println(solution);

            // on affiche le backtracking pour aller au noeud 14 depuis le noeud 1
            List<String> chemin = solution.calculerChemin("14");
            System.out.println(chemin);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
