public class FileContigue implements File {

    private int nb;
    private String[] tab;

    /**
     * constructeur de file (avec 200 places possibles)
     */
    public FileContigue() {
        this.nb = 0;
        this.tab = new String[200];
    }

    /**
     * true si la file est vide
     */
    public boolean estVideFile() {
        return this.nb == 0;
    }

    /**
     * on ajoute l'element en queue - en fin de file
     */
    public void adjfil(String c) {
        this.tab[nb] = c;
        this.nb += 1;
    }

    /**
     * retourne le premier element de la file
     */
    public String premier() {
        return this.tab[0];
    }

    /**
     * supprime le premier element insere dans la file
     */
    public void supfil() {
        if (estVideFile()) {
            throw new Error("File vide !");
        } else {
            for (int i = 1; i < nb; i++) {
                this.tab[i - 1] = this.tab[i];
            }
            this.nb -= 1;
        }
    }

}
