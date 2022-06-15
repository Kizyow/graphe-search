package laby;

import algorithmes.Algorithme;
import algorithmes.BellmanFord;
import algorithmes.Valeur;
import graphes.GrapheListe;

import java.io.IOException;

public class MainLabyrinthe {

    public static void main(String[] args) throws IOException {

        Labyrinthe labyrinthe = new Labyrinthe("labySimple/laby2.txt");
        GrapheListe grapheListe = labyrinthe.genererGraphe();
        System.out.println(grapheListe.toGraphviz());

        GrapheLabyrinthe grapheLabyrinthe = new GrapheLabyrinthe("labySimple/laby2.txt");
        System.out.println(grapheLabyrinthe.toGraphviz());

        Algorithme algorithme = new BellmanFord();
        Valeur valeur = algorithme.resoudre(grapheListe, "1,1");
        System.out.println(valeur.calculerChemin("18,1"));

        valeur = algorithme.resoudre(grapheLabyrinthe, "1,1");
        System.out.println(valeur.calculerChemin("18,1"));


    }

}
