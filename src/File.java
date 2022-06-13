/**
 * interface qui represente le TAD File(Description)
 *
 * @author vthomas
 */
public interface File {
    /**
     * verifie si la file est vide ou non
     *
     * @return true si et seulement si la file est vide
     */
    public boolean estVideFile();

    /**
     * ajoute une String dans la file
     *
     * @param c String a ajouter
     */
    public void adjfil(String c);

    /**
     * @return la premiere String de la file
     */
    public String premier();

    /**
     * retire le premier element de la file
     */
    public void supfil();

}
