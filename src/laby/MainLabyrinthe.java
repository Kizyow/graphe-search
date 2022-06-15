package laby;

import algorithmes.BellmanFord;
import algorithmes.Dijkstra;
import algorithmes.Valeur;
import graphes.GrapheListe;

import java.io.IOException;

public class MainLabyrinthe {

    /**
     * Le main pour générer un labyinrthe et rechercher le chemin le plus court
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

//        Labyrinthe labyrinthe = new Labyrinthe("labySimple/laby2.txt");
//        GrapheListe grapheListe = labyrinthe.genererGraphe();
//        System.out.println(grapheListe.toGraphviz());
//
//        BellmanFord bellmanFord = new BellmanFord();
//        Valeur valeurBellmanFord = bellmanFord.resoudre(grapheListe, "1,1");
//        System.out.println(valeurBellmanFord.calculerChemin("18,1"));
//
//        Dijkstra dijkstra = new Dijkstra();
//        Valeur valeurDijkstra = dijkstra.resoudre(grapheListe, "1,1");
//        System.out.println(valeurDijkstra.calculerChemin("18,1"));

        // solution de type adaptateur
        GrapheLabyrinthe grapheLabyrinthe = new GrapheLabyrinthe("labySimple/laby2.txt");
        System.out.println(grapheLabyrinthe.toGraphviz());

        BellmanFord bellmanFord = new BellmanFord();
        Valeur valeurBellmanFord = bellmanFord.resoudre(grapheLabyrinthe, "1,1");
        System.out.println(valeurBellmanFord.calculerChemin("18,1"));

        Dijkstra dijkstra = new Dijkstra();
        Valeur valeurDijkstra = dijkstra.resoudre(grapheLabyrinthe, "1,1");
        System.out.println(valeurDijkstra.calculerChemin("18,1"));

    }

}
