import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * La classe MainGraphe
 */
public class MainGrapheListe {

    /**
     * La méthode main permettant de recréer le graphe présenté dans la figure 1 du PDF
     * et de générer un graphe a partir d'un fichier
     *
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
        System.out.println(grapheListe.toString());
        System.out.println(grapheListe.toGraphviz());

        try {
            GrapheListe grapheListeFichier = new GrapheListe("exemples/Graphe1.txt");
            System.out.println(grapheListeFichier.toString());
            System.out.println(grapheListeFichier.toGraphviz());
        } catch (IOException e) {
            e.printStackTrace();
        }

//        GrapheListe grapheListe = new GrapheListe();
//        grapheListe.ajouterArc("A", "B", 1);
//        grapheListe.ajouterArc("A", "C", 5);
//        grapheListe.ajouterArc("B", "C", 3);
//        grapheListe.ajouterArc("B", "D", 1);
//        grapheListe.ajouterArc("C", "E", 3);
//        grapheListe.ajouterArc("D", "C", 1);
//        grapheListe.ajouterArc("D", "E", 9);
//        System.out.println(grapheListe.toString());
//        System.out.println(grapheListe.toGraphviz());

//        System.out.println(Arrays.toString(pointFixe(grapheListe, new Noeud("A"))));

    }

    /**
     * algorithme du point fixe (A ECRIRE EN ALGO D'ABORD)
     * @param graphe
     * @param depart
     * @return
     */
    public static double[] pointFixe(Graphe graphe, Noeud depart) {

        double[] poidsNoeud = new double[graphe.listeNoeuds().size()];


        for (int i = 0; i < poidsNoeud.length; i++) {
            String nomNoeud = graphe.listeNoeuds().get(i);
            if (nomNoeud.equals(depart.getNom())) {
                poidsNoeud[i] = 0;
            } else {
                poidsNoeud[i] = Double.MAX_VALUE;
            }

        }

        double[] precPoidsNoeud = new double[graphe.listeNoeuds().size()];

        while (!Arrays.equals(precPoidsNoeud, poidsNoeud)) {

            precPoidsNoeud = poidsNoeud.clone();

            for (int i = 0; i < poidsNoeud.length; i++) {
                String nomNoeud = graphe.listeNoeuds().get(i);

                List<Arc> arcs = graphe.suivants(nomNoeud);


                for (int j = 0; j < arcs.size(); j++) {
                    Arc arc = arcs.get(j);

                    int arcIndex = 0;
                    for (int k = 0; k < poidsNoeud.length; k++) {
                        String ezr = graphe.listeNoeuds().get(k);
                        if (ezr.equals(arc.getDest())) {
                            arcIndex = k;
                        }

                    }

                    if (poidsNoeud[i] + arc.getCout() < poidsNoeud[arcIndex]) {
                        poidsNoeud[arcIndex] = poidsNoeud[i] + arc.getCout();
                    }

                }

            }
        }

        return poidsNoeud;

    }

}
