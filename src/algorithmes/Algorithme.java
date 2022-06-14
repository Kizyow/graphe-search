package algorithmes;

import graphes.Graphe;

/**
 * Une interface algorithmes.Algorithme afin d'avoir un Strategy Pattern
 */
public interface Algorithme {

    /**
     * Méthode de résolution de chemin minimale dans un graphe donné
     * @param g Un graphe quelquonque
     * @param depart Un noeud de départ
     * @return Les valeurs minimaux
     */
    Valeur resoudre(Graphe g, String depart);

}
