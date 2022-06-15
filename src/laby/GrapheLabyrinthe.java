package laby;

import graphes.Arc;
import graphes.Graphe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GrapheLabyrinthe implements Graphe {

    private Labyrinthe labyrinthe;

    public GrapheLabyrinthe(String nomFichier) throws IOException {
        this.labyrinthe = new Labyrinthe(nomFichier);
    }

    @Override
    public List<String> listeNoeuds() {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < labyrinthe.getLength(); i++) {
            for (int j = 0; j < labyrinthe.getLengthY(); j++) {
                if (!labyrinthe.getMur(i, j)) {
                    strings.add(i + "," + j);
                }
            }
        }
        return strings;
    }

    @Override
    public List<Arc> suivants(String n) {

        List<Arc> arcs = new ArrayList<>();
        String[] ss = n.split(",");

        int x = Integer.parseInt(ss[0]);
        int y = Integer.parseInt(ss[1]);

        List<int[]> suivants = new ArrayList<>();
        suivants.add(labyrinthe.deplacerPerso(x, y, Labyrinthe.HAUT));
        suivants.add(labyrinthe.deplacerPerso(x, y, Labyrinthe.BAS));
        suivants.add(labyrinthe.deplacerPerso(x, y, Labyrinthe.GAUCHE));
        suivants.add(labyrinthe.deplacerPerso(x, y, Labyrinthe.DROITE));

        for (int[] dest : suivants) {
            String d = dest[0] + "," + dest[1];
            if (!d.equalsIgnoreCase(n)) {
                arcs.add(new Arc(d, 1));
            }

        }

        return arcs;
    }


    @Override
    public String toString() {
        String ch = "";
        for (String noeud : listeNoeuds()) {
            ch += noeud + " -> ";
            for (Arc arc : suivants(noeud)) {
                ch += " " + arc.getDest() + "(" + arc.getCout() + ")";
            }
            ch += "\n";
        }
        return ch;
    }

    public String toGraphviz() {
        String ch = "digraph {\n\n";
        for (String noeud : listeNoeuds()) {
            String temp = "";
            temp += noeud + " -> ";
            for (Arc arc : suivants(noeud)) {
                ch += temp + " " + arc.getDest() + " [label = " + arc.getCout() + "]\n";
            }
            if (suivants(noeud).isEmpty()) {
                ch += noeud + "\n";
            }
        }

        ch += "\n}";
        return ch;
    }

}
