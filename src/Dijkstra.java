import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class Dijkstra {

    /**
     * Entrees :
     * G un graphe oriente avec une ponderation (poids) positive des arcs
     * A un sommet (d´epart) de G
     *
     * Debut
     * Q <- {} // utilisation d’une liste de noeuds a traiter
     * Pour chaque sommet v de G faire
     * v.distance <- Infini
     * v.parent <- Indefini
     * Q <- Q U {v} // ajouter le sommet v a la liste Q
     * Fin Pour
     * A.distance <- 0
     * Tant que Q est un ensemble non vide faire
     * u <- un sommet de Q telle que u.distance est minimale
     * Q <- Q \ {u} // enlever le sommet u de la liste Q
     * Pour chaque sommet v de Q tel que l’arc (u,v) existe faire
     * D <- u.distance + poids(u,v)
     * Si D < v.distance
     * Alors v.distance <- D
     * v.parent <- u
     * Fin Si
     * Fin Pour
     * Fin Tant que
     * Fin
     */

    /**
     * Algorithme du point fixe
     *
     * @param g      Graphe
     * @param depart Noeud de départ
     * @return Les valeurs
     */
    public Valeur resoudre(Graphe g, String depart) {

        Valeur valeur = new Valeur();
        File file = new FileContigue();

        for (String gNom : g.listeNoeuds()) {
            if (gNom.equalsIgnoreCase(depart)) {
                valeur.setValeur(gNom, 0);
                // sinon L(X) = +inf
            } else {
                valeur.setValeur(gNom, Double.MAX_VALUE);
            }
            file.adjfil(gNom);

        }

        while(!file.estVideFile()){

            int u = 0;
            file.adjfil(u);


        }

    }

}
