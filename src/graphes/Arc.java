package graphes;

/**
 * Une classe Arc permettant de représenter un arc dans un graphe
 * partant d'un noeud vers un noeud destination avec un coût défini
 */
public class Arc {

    /**
     * Attribut qui représente le nom du noeud de destination
     */
    private String dest;
    /**
     * Attribut qui représente le coût (strictement positif) de l'arc
     */
    private double cout;

    /**
     * Constructeur permettant de créer un arc
     *
     * @param noeudDest Le noeud de destination de l'arc
     * @param arcCout   Le coût/poids de l'arc
     */
    public Arc(String noeudDest, double arcCout) {
        this.dest = noeudDest;
        this.cout = arcCout;

        if (arcCout < 1) {
            this.cout = 1;
        }

    }

    /**
     * Méthode permettant de récuperer le nom du noeud de destination
     *
     * @return le nom du noeud de destination
     */
    public String getDest() {
        return dest;
    }

    /**
     * Méthode permettant de récupérer le coût de l'arc
     *
     * @return le coût/poids
     */
    public double getCout() {
        return cout;
    }

}
