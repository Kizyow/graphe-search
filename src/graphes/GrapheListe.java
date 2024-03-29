package graphes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Une classe GrapheListe permettant de représenter les données associé à un graphe
 */
public class GrapheListe implements Graphe {

    /**
     * Attribut représentant la liste des noms de noeuds
     */
    private List<String> ensNom;
    /**
     * Attribut représentant la liste des Noeud
     */
    private List<Noeud> ensNoeuds;

    /**
     * Constructeur par défaut de GrapheListe
     */
    public GrapheListe() {
        this.ensNom = new ArrayList<>();
        this.ensNoeuds = new ArrayList<>();
    }

    /**
     * Constructeur de GrapheListe et chargement d'un graphe à partir d'un fichier
     *
     * @param nomFichier Le nom du fichier contenant le graphe
     * @throws IOException Une exception quand le fichier est mal lu
     */
    public GrapheListe(String nomFichier) throws IOException {
        this.ensNom = new ArrayList<>();
        this.ensNoeuds = new ArrayList<>();

        // lecture du fichier
        FileReader fileReader = new FileReader(nomFichier);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        // lecture de la ligne courante
        String line = bufferedReader.readLine();

        // tant qu'il y a encore une ligne a lire
        while (line != null) {
            String[] ligneSplit = line.split("\t");
            String depart = ligneSplit[0];
            String destination = ligneSplit[1];
            double cout = Double.parseDouble(ligneSplit[2]);

            // ajout des noeuds et de l'arc au graphe à partir des informations de la ligne
            this.ajouterArc(depart, destination, cout);

            line = bufferedReader.readLine();
        }

        // fermeture du flux
        bufferedReader.close();

    }

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
            ensNom.add(depart);
        }

        // si le noeud de destination n'existe pas, le créer et l'ajouter au graphe
        if (noeudDest == null) {
            noeudDest = new Noeud(destination);
            ensNoeuds.add(noeudDest);
            ensNom.add(destination);
        }

        //si l'arc entre le noeud de depart et de destination existe deja, ne rien faire
        for (Arc arc : noeudDep.getAdj()) {
            if (arc.getDest().equalsIgnoreCase(destination)) {
                return;
            }
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
        Noeud noeudSelect = new Noeud(n);

        for (Noeud noeud : ensNoeuds) {
            if (noeud.equals(noeudSelect)) {
                noeudSelect = noeud;
            }
        }

        return noeudSelect.getAdj();
    }

    /**
     * retourne une chaine correspond a toute les liasons dans le graphe
     *
     * @return une chaine
     */
    @Override
    public String toString() {
        String ch = "";
        for (Noeud noeud : ensNoeuds) {
            ch += noeud.getNom() + " -> ";
            for (Arc arc : noeud.getAdj()) {
                ch += " " + arc.getDest() + "(" + arc.getCout() + ")";
            }
            ch += "\n";
        }
        return ch;
    }

    /**
     * retourne une chaine correspond a toute les liasons dans le graphe sous la forme d'un Graphviz
     *
     * @return une chaine
     */
    public String toGraphviz() {
        String ch = "digraph {\n\n";
        for (Noeud noeud : ensNoeuds) {
            String temp = "";
            temp += noeud.getNom() + " -> ";
            for (Arc arc : noeud.getAdj()) {
                ch += temp + " " + arc.getDest() + " [label = " + arc.getCout() + "]\n";
            }
            if (noeud.getAdj().isEmpty()) {
                ch += noeud.getNom() + "\n";
            }
        }

        ch += "\n}";
        return ch;
    }

    /**
     * Permet de générer un graphe aleatoirement avec n noeuds donnés
     *
     * @param taille Le nombre de noeuds dans le graphe
     * @return GrapheListe
     */
    public static GrapheListe genererGraphe(int taille) {

        GrapheListe grapheListe = new GrapheListe();
        Random random = new Random();

        // on créé tout les noeuds (de 1 à taille) et on les relies avec leur noeud suivant (n -> n+1)
        // cela garantira qu'il existe au moins un chemin passant par tout les noeuds
        for (int i = 1; i < taille; i++) {
            grapheListe.ajouterArc(String.valueOf(i), String.valueOf(i + 1), random.nextInt(100) + 1);
        }

        // on relie le dernier noeud du graphe au premier noeud afin d'avoir une boucle
        grapheListe.ajouterArc(String.valueOf(taille), "1", random.nextInt(100) + 1);

        // on ajoute d'autres arcs aléatoirement dans le graphe pour plus de diversité
        for (int i = 1; i <= taille; i++) {
            int dep = random.nextInt(taille) + 1;
            int dest = random.nextInt(taille) + 1;
            grapheListe.ajouterArc(String.valueOf(dep), String.valueOf(dest), random.nextInt(100) + 1);
        }

        return grapheListe;

    }

}
