import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TestBellmanFord {
    @Test
    public void testPointFixe() {
        // preparation des donnees
        GrapheListe grapheListe = new GrapheListe();
        grapheListe.ajouterArc("A", "B", 1);
        grapheListe.ajouterArc("A", "C", 5);
        grapheListe.ajouterArc("B", "C", 3);
        grapheListe.ajouterArc("B", "D", 1);
        grapheListe.ajouterArc("C", "E", 3);
        grapheListe.ajouterArc("D", "C", 1);
        grapheListe.ajouterArc("D", "E", 9);

        // test de la methode
        BellmanFord bellmanFord = new BellmanFord();
        Valeur valeur = bellmanFord.resoudre(grapheListe, "A");

        // validation
        String resultatAttendu = "A ->  V:0.0 p:null\n" +
                "B ->  V:1.0 p:A\n" +
                "C ->  V:3.0 p:D\n" +
                "D ->  V:2.0 p:B\n" +
                "E ->  V:6.0 p:C\n";

        assertEquals(resultatAttendu, valeur.toString());

    }
}
