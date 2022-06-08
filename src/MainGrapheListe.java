/**
 * La classe MainGraphe
 */
public class MainGrapheListe {

    /**
     * La méthode main permettant de recréer le graphe présenté dans la figure 1 du PDF
     * @param args
     */
    public static void main(String[] args) {

        GrapheListe grapheListe = new GrapheListe();
        grapheListe.ajouterArc("A", "B", 12);
        grapheListe.ajouterArc("A", "D", 87);
        grapheListe.ajouterArc("B", "E", 11);
        grapheListe.ajouterArc("C", "A", 19);
        grapheListe.ajouterArc("D", "C", 10);
        grapheListe.ajouterArc("D", "B", 23);
        grapheListe.ajouterArc("E", "D", 43);

    }

}
