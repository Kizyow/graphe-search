public class Main {

    /**
     * Le main pour tester l'algorithme du point fixe
     *
     * @param args
     */
    public static void main(String[] args) {

        GrapheListe grapheListe = new GrapheListe();
        grapheListe.ajouterArc("A", "B", 1);
        grapheListe.ajouterArc("A", "C", 5);
        grapheListe.ajouterArc("B", "C", 3);
        grapheListe.ajouterArc("B", "D", 1);
        grapheListe.ajouterArc("C", "E", 3);
        grapheListe.ajouterArc("D", "C", 1);
        grapheListe.ajouterArc("D", "E", 9);
        System.out.println(grapheListe.toString());
        System.out.println(grapheListe.toGraphviz());

        BellmanFord bellmanFord = new BellmanFord();
        Valeur valeur = bellmanFord.resoudre(grapheListe, "A");
        System.out.println(valeur);
        System.out.println(valeur.calculerChemin("E"));

    }

}
