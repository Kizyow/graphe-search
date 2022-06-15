package laby;

import graphes.Arc;
import graphes.Graphe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe adaptateur de la classe Labyrinthe afin d'en faire un graphe
 */
public class GrapheLabyrintheRicochet implements Graphe {

    /**
     * Attribut représentant le labyrinthe et qui servira de donnée
     */
    private LabyrintheRicochet labyrintheRicochet;

    /**
     * Constructeur du GrapheLabyrinthe qui va lire le labyrinthe sur un fichier
     *
     * @param nomFichier Le nom du fichier
     * @throws IOException Exception
     */
    public GrapheLabyrintheRicochet(String nomFichier) throws IOException {
        this.labyrintheRicochet = new LabyrintheRicochet(nomFichier);
    }

    /**
     * Méthode qui permet de récupérer tout les emplacements libres du labyrinthe
     *
     * @return Liste des noeuds sous forme de leur coordonnée x,y (String)
     */
    @Override
    public List<String> listeNoeuds() {
        List<String> casesLibre = new ArrayList<>();
        for (int i = 0; i < labyrintheRicochet.getLength(); i++) {
            for (int j = 0; j < labyrintheRicochet.getLengthY(); j++) {
                if (!labyrintheRicochet.getMur(i, j)) {
                    casesLibre.add(i + "," + j);
                }
            }
        }
        return casesLibre;
    }

    /**
     * Méthode qui permet de récupérer tout les arcs d'un noeud dont le deplacement est possible
     *
     * @param n Le nom du noeud
     * @return La liste des arcs du noeud passé en paramètre
     */
    @Override
    public List<Arc> suivants(String n) {

        List<Arc> arcs = new ArrayList<>();
        String[] noeudSplit = n.split(",");

        int x = Integer.parseInt(noeudSplit[0]);
        int y = Integer.parseInt(noeudSplit[1]);

        List<int[]> suivants = new ArrayList<>();
        suivants.add(labyrintheRicochet.deplacerPerso(x, y, Labyrinthe.HAUT));
        suivants.add(labyrintheRicochet.deplacerPerso(x, y, Labyrinthe.BAS));
        suivants.add(labyrintheRicochet.deplacerPerso(x, y, Labyrinthe.GAUCHE));
        suivants.add(labyrintheRicochet.deplacerPerso(x, y, Labyrinthe.DROITE));

        for (int[] dest : suivants) {
            String destString = dest[0] + "," + dest[1];
            if (!destString.equalsIgnoreCase(n)) {
                arcs.add(new Arc(destString, 1));
            }

        }

        return arcs;
    }

    /**
     * retourne une chaine correspond a toute les liasons dans le graphe
     *
     * @return une chaine
     */
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

    /**
     * retourne une chaine correspond a toute les liasons dans le graphe sous la forme d'un Graphviz
     *
     * @return une chaine
     */
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

    /**
     * Permet d'accéder à l'objet Labyrinthe
     *
     * @return Labyrinthe
     */
    public LabyrintheRicochet getLabyrintheRicochet() {
        return labyrintheRicochet;
    }

}
