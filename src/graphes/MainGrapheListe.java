package graphes;

import java.io.IOException;

/**
 * La classe MainGraphe
 */
public class MainGrapheListe {

    /**
     * La méthode main permettant de recréer le graphe présenté dans la figure 1 du PDF
     * et de générer un graphe a partir d'un fichier
     *
     * @param args
     */
    public static void main(String[] args) {

        graphes.GrapheListe grapheListe = new graphes.GrapheListe();
        grapheListe.ajouterArc("A", "B", 12);
        grapheListe.ajouterArc("A", "D", 87);
        grapheListe.ajouterArc("B", "E", 11);
        grapheListe.ajouterArc("C", "A", 19);
        grapheListe.ajouterArc("D", "C", 10);
        grapheListe.ajouterArc("D", "B", 23);
        grapheListe.ajouterArc("E", "D", 43);
        System.out.println(grapheListe.toString());
        System.out.println(grapheListe.toGraphviz());

        try {
            graphes.GrapheListe grapheListeFichier = new GrapheListe("exemples/Graphe1.txt");
            System.out.println(grapheListeFichier.toString());
            System.out.println(grapheListeFichier.toGraphviz());
        } catch (IOException e) {
            e.printStackTrace();
        }


        //generation d'un graphe aleatoire avec 100 noeuds
        GrapheListe grapheListe2 = GrapheListe.genererGraphe(100);
        System.out.println(grapheListe2.toString());
        System.out.println(grapheListe2.toGraphviz());

    }

}
