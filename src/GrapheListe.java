import java.util.List;

/**
 * Une classe GrapheListe permettant de représenter les données associé à un graphe
 */
public class GrapheListe implements Graphe {

    private List<String> ensNom;
    private List<Noeud> ensNoeuds;

    /**
     * Méthode permettant d'ajouter des noeuds et des arcs au graphe
     *
     * @param depart      Le nom du noeud de départ
     * @param destination Le nom du noeud de destination
     * @param cout        Le coût/poids de l'arc
     */
    public void ajouterArc(String depart, String destination, double cout) {
        Noeud noeudDep = null;
        Noeud noeudDest = null;

        // vérifier si le noeud existe déjà dans le graphe
        for (Noeud noeud : ensNoeuds) {
            if (noeud.getNom().equals(depart)) {
                noeudDep = noeud;
            }
            if (noeud.getNom().equals(destination)) {
                noeudDest = noeud;
            }
        }

        // si le noeud de départ n'existe pas, le créer et l'ajouter au graphe
        if (noeudDep == null) {
            noeudDep = new Noeud(depart);
            ensNoeuds.add(noeudDep);
        }

        // si le noeud de destination n'existe pas, le créer et l'ajouter au graphe
        if (noeudDest == null) {
            noeudDest = new Noeud(destination);
            ensNoeuds.add(noeudDest);
        }

        // ajouter l'arc partant du noeud de départ vers le noeud de destination pour un cout
        noeudDep.ajouterArc(destination, cout);

    }

    /**
     * Méthode qui permet de récupérer tout les noeuds du graphe
     *
     * @return Liste des noeuds sous forme de leur nom (String)
     */
    @Override
    public List<String> listeNoeuds() {
        return this.ensNom;
    }

    /**
     * Méthode qui permet de récupérer tout les arcs d'un noeud passé en paramètre
     *
     * @param n Le nom du noeud
     * @return La liste des arcs du noeud passé en paramètre
     */
    @Override
    public List<Arc> suivants(String n) {
        return null;
    }

}