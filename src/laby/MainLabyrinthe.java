package laby;

import algorithmes.Algorithme;
import algorithmes.BellmanFord;
import algorithmes.Valeur;
import graphes.GrapheListe;

import java.io.IOException;

public class MainLabyrinthe {

    public static void main(String[] args) throws IOException {

        Labyrinthe labyrinthe = new Labyrinthe("labySimple/laby1.txt");
        GrapheListe grapheListe = labyrinthe.genererGraphe();
        System.out.println(grapheListe.toGraphviz());

        Algorithme algorithme = new BellmanFord();
        Valeur valeur = algorithme.resoudre(grapheListe, "(1,1)");
        System.out.println(valeur.calculerChemin("(8,5)"));

    }

}
