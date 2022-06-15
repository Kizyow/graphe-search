package algorithmes;

import graphes.GrapheListe;

public class MainBellmanFord {

    /**
     * Le main pour tester l'algorithme du point fixe
     *
     * @param args
     */
    public static void main(String[] args) {

        // on créé un graphe
        GrapheListe grapheListe = new GrapheListe();
        grapheListe.ajouterArc("A", "B", 12);
        grapheListe.ajouterArc("A", "D", 87);
        grapheListe.ajouterArc("B", "E", 11);
        grapheListe.ajouterArc("C", "A", 19);
        grapheListe.ajouterArc("D", "C", 10);
        grapheListe.ajouterArc("D", "B", 23);
        grapheListe.ajouterArc("E", "D", 43);
        System.out.println(grapheListe.toString());
        System.out.println(grapheListe.toGraphviz());

        // et on utilise l'algorithme du point fixe partant du noeud A
        BellmanFord bellmanFord = new BellmanFord();
        Valeur valeur = bellmanFord.resoudre(grapheListe, "A");

        // on affiche la valeur minimale de chaque noeud
        System.out.println(valeur);

        // on affiche le backtracking pour aller au noeud C depuis le noeud A
        System.out.println(valeur.calculerChemin("C"));

    }

}
