package dechets;

/**
 * Created by BelSi1731422 on 2018-04-26.
 */
public abstract class  Matiere {
    protected String nom;
    protected int masseVolumique;
    protected int pourcentage;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getMasseVolumique() {
        return masseVolumique;
    }

    public void setMasseVolumique(int masseVolumique) {
        this.masseVolumique = masseVolumique;
    }

    public int getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(int pourcentage) {
        this.pourcentage = pourcentage;
    }

}
