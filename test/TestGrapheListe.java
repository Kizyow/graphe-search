import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestGrapheListe {

    /**
     * verifie le toString
     */
    @Test
    public void testToString(){
        GrapheListe grapheListe = new GrapheListe();
        grapheListe.ajouterArc("A", "B", 12);
        grapheListe.ajouterArc("A", "D", 87);

        String res ="A ->  B(12.0) D(87.0)\n" +
                "B -> \n" +
                "D -> \n";
        System.out.println(grapheListe.toString());
        assertEquals(res, grapheListe.toString());
    }

    /**
     * verifie le toString avec plusieurs noeuds
     */
    @Test
    public void testToStringV2(){
        GrapheListe grapheListe = new GrapheListe();
        grapheListe.ajouterArc("A", "B", 12);
        grapheListe.ajouterArc("A", "D", 87);
        grapheListe.ajouterArc("B", "E", 11);
        grapheListe.ajouterArc("C", "A", 19);
        grapheListe.ajouterArc("D", "C", 10);
        grapheListe.ajouterArc("D", "B", 23);
        grapheListe.ajouterArc("E", "D", 43);

        String res ="A ->  B(12.0) D(87.0)\n" +
                "B ->  E(11.0)\n" +
                "D ->  C(10.0) B(23.0)\n" +
                "E ->  D(43.0)\n" +
                "C ->  A(19.0)\n";
        //System.out.println(grapheListe.toString());
        assertEquals(res, grapheListe.toString());
    }

    /**
     * verifie le toGraphViz
     */
    @Test
    public void testToGraphViz(){
        GrapheListe grapheListe = new GrapheListe();
        grapheListe.ajouterArc("A", "B", 12);
        grapheListe.ajouterArc("A", "D", 87);

        String res ="digraph {\n" +
                "\n" +
                "A ->  B [label = 12.0]\n" +
                "A ->  D [label = 87.0]\n" +
                "B\n" +
                "D\n" +
                "\n" +
                "}";
        //System.out.println(grapheListe.toGraphviz());
        assertEquals(res, grapheListe.toGraphviz());
    }

    /**
     * verifie le toGraphViz
     */
    @Test
    public void testToGraphVizV2(){
        GrapheListe grapheListe = new GrapheListe();
        grapheListe.ajouterArc("A", "B", 12);
        grapheListe.ajouterArc("A", "D", 87);
        grapheListe.ajouterArc("B", "E", 11);
        grapheListe.ajouterArc("C", "A", 19);
        grapheListe.ajouterArc("D", "C", 10);
        grapheListe.ajouterArc("D", "B", 23);
        grapheListe.ajouterArc("E", "D", 43);

        String res ="digraph {\n" +
                "\n" +
                "A ->  B [label = 12.0]\n" +
                "A ->  D [label = 87.0]\n" +
                "B ->  E [label = 11.0]\n" +
                "D ->  C [label = 10.0]\n" +
                "D ->  B [label = 23.0]\n" +
                "E ->  D [label = 43.0]\n" +
                "C ->  A [label = 19.0]\n" +
                "\n" +
                "}";
        //System.out.println(grapheListe.toGraphviz());
        assertEquals(res, grapheListe.toGraphviz());
    }



}
