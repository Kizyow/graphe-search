import java.util.List;

/**
 * Classe de l'algorithme du point fixe
 */
public class BellmanFord {

    /*
    fonction pointFixe(g : Graphe InOut, depart : Noeud)
    début
        Pour x dans g faire
            L(X) <- +inf
        Fpour
        L(depart) <- 0

        Tant que non point fixe faire
            Pour x dans g faire
                Pour arcX dans x faire
                    si L(x) + d(arcX, x) < L(arcX) alors
                        L(arcX) <- L(x) + d(arcX, x)
                        parent(arcX) <- x
                    Fsi
                Fpour
            Fpour
        Ftant
     Fin
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

        // initialisation
        for (String gNom : g.listeNoeuds()) {
            // si X = depart, alors L(X) = 0
            if (gNom.equalsIgnoreCase(depart)) {
                valeur.setValeur(gNom, 0);
                // sinon L(X) = +inf
            } else {
                valeur.setValeur(gNom, Double.MAX_VALUE);
            }
        }

        // étapes
        String valeurPrec = "";
        while (!valeurPrec.equalsIgnoreCase(valeur.toString())) {

            valeurPrec = valeur.toString();

            for (String gNom : g.listeNoeuds()) {

                List<Arc> arcs = g.suivants(gNom);
                for (Arc arc : arcs) {

                    double nouveauCout = valeur.getValeur(gNom) + arc.getCout();
                    if (nouveauCout < valeur.getValeur(arc.getDest())) {
                        valeur.setValeur(arc.getDest(), nouveauCout);
                        valeur.setParent(arc.getDest(), gNom);
                    }

                }

            }

        }

        // retourne valeur
        return valeur;

    }

}
