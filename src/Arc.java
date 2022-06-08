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
     * @param noeudDest Le noeud de destination de l'arc
     * @param arcCout Le coût/poids de l'arc
     */
    public Arc(String noeudDest, double arcCout) {
        this.dest = noeudDest;
        this.cout = arcCout;
    }

}
