import java.util.List;

/**
 * Une interface Graphe (TAD)
 */
public interface Graphe {

    /**
     * Méthode qui permet de récupérer tout les noeuds du graphe
     * @return Liste des noeuds sous forme de leur nom (String)
     */
    List<String> listeNoeuds();

    /**
     * Méthode qui permet de récupérer tout les arcs d'un noeud passé en paramètre
     * @param n Le nom du noeud
     * @return La liste des arcs du noeud passé en paramètre
     */
    List<Arc> suivants(String n);

}
