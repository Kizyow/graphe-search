package algorithmes;

import graphes.Arc;
import graphes.Graphe;

import java.util.ArrayList;
import java.util.List;

public class Dijkstra implements Algorithme {

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
     * algorithmes.Algorithme de algorithmes.Dijkstra
     *
     * @param g      graphes.Graphe
     * @param depart graphes.Noeud de départ
     * @return Les valeurs
     */
    public Valeur resoudre(Graphe g, String depart) {

        Valeur valeur = new Valeur();
        List<String> liste = new ArrayList<>();

        for (String gNom : g.listeNoeuds()) {
            if (gNom.equalsIgnoreCase(depart)) {
                valeur.setValeur(gNom, 0);
                // sinon L(X) = +inf
            } else {
                valeur.setValeur(gNom, Double.MAX_VALUE);
            }
            liste.add(gNom);

        }

//        System.out.println("Dijsktra - Initialisation -> : \n" + valeur);

        while (!liste.isEmpty()) {

            String petitNoeud = liste.get(0);

            for (String noeudNom : liste) {
                if (valeur.getValeur(noeudNom) < valeur.getValeur(petitNoeud)) {
                    petitNoeud = noeudNom;
                }
            }

            liste.remove(petitNoeud);

            List<Arc> listeArc = g.suivants(petitNoeud);
            for (Arc arc : listeArc) {

                double D = valeur.getValeur(petitNoeud) + arc.getCout();

                if (D < valeur.getValeur(arc.getDest())) {
                    valeur.setValeur(arc.getDest(), D);
                    valeur.setParent(arc.getDest(), petitNoeud);
                }

//                System.out.println("Dijsktra - graphes.Noeud " + petitNoeud + " -> : \n" + valeur);

            }

        }

        return valeur;

    }

}
