package laby;

import algorithmes.BellmanFord;
import algorithmes.Dijkstra;
import algorithmes.Valeur;

import java.io.IOException;

public class MainLabyrintheRicochet {

    /**
     * Le main pour générer un labyinrthe ricochet et rechercher le chemin le plus court
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        // solution de type adaptateur
        GrapheLabyrintheRicochet grapheLabyrintheRicochet = new GrapheLabyrintheRicochet("labySimple/laby1.txt");
        System.out.println(grapheLabyrintheRicochet.toGraphviz());

        BellmanFord bellmanFord = new BellmanFord();
        Valeur valeurBellmanFord = bellmanFord.resoudre(grapheLabyrintheRicochet, "1,1");
        System.out.println(valeurBellmanFord.calculerChemin("8,4"));

        Dijkstra dijkstra = new Dijkstra();
        Valeur valeurDijkstra = dijkstra.resoudre(grapheLabyrintheRicochet, "1,1");
        System.out.println(valeurDijkstra.calculerChemin("8,4"));

    }

}
