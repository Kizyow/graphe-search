import java.util.ArrayList;
import java.util.List;

public class Noeud {

    private String nom;
    private List<Arc> adj;


    /**
     * constructeur noeud
     * @param nom nom du noeud
     */
    public Noeud(String nom){
        this.nom = nom;
        adj = new ArrayList<Arc>();
    }

    /**
     * redefinition de la methode equals
     * @param n objet noeud
     * @return vrai si le nom est identique a l'objet passe en param
     */
    public boolean equals(Noeud n){
        return getNom().equals(n.getNom());
    }

    /**
     * @return le nom
     */
    public String getNom(){
        return nom;
    }

    /**
     * ajoute un arc
     * @param destination nom du noeud
     * @param cout cout pour acceder au noeud
     */
    public void ajouterArc(String destination, double cout){
        adj.add(new Arc(destination, cout));
    }
}
