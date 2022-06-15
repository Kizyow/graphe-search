package algorithmes;

import graphes.Graphe;

/**
 * Une interface Algorithme afin d'avoir un Strategy Pattern
 */
public interface Algorithme {

    /**
     * Méthode de résolution de chemin minimale dans un graphe donné
     * @param g Un graphe quelquonque
     * @param depart Un noeud de départ
     * @return Les valeurs des noeuds minimaux
     */
    Valeur resoudre(Graphe g, String depart);

}
