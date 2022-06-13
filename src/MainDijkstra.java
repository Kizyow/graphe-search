import java.io.IOException;
import java.util.List;

public class MainDijkstra {

    public static void main(String[] args) {

        try {
            GrapheListe graphe = new GrapheListe("exemples/Graphe25.txt");
            System.out.println(graphe.toString());
            System.out.println(graphe.toGraphviz());

            Algorithme algorithme = new Dijkstra();
            Valeur solution = algorithme.resoudre(graphe, "1");
            System.out.println(solution);

            List<String> chemin = solution.calculerChemin("14");
            System.out.println(chemin);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
