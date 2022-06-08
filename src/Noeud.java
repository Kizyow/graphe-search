import java.util.ArrayList;
import java.util.List;

public class Noeud {

    /**
     * Attribut représentant le nom du Noeud
     */
    private String nom;
    /**
     * Attribut représentant la liste d'adjacente du Noeud
     */
    private List<Arc> adj;


    /**
     * Constructeur du Noeud
     *
     * @param nom nom du noeud
     */
    public Noeud(String nom) {
        this.nom = nom;
        adj = new ArrayList<Arc>();
    }

    /**
     * Redéfinition de la methode equals
     *
     * @param n objet noeud
     * @return vrai si le nom est identique a l'objet passe en param
     */
    public boolean equals(Noeud n) {
        return getNom().equals(n.getNom());
    }

    /**
     * Méthode permettant de récupérer le nom du noeud
     *
     * @return le nom
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Méthode permettant de récupérer la liste d'adjacente du Noeud
     *
     * @return la liste d'adjacente sous forme d'arcs
     */
    public List<Arc> getAdj() {
        return this.adj;
    }

    /**
     * ajoute un arc
     *
     * @param destination nom du noeud
     * @param cout        cout pour acceder au noeud
     */
    public void ajouterArc(String destination, double cout) {
        adj.add(new Arc(destination, cout));
    }

}
