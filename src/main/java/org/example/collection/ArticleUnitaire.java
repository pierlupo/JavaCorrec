package org.example.collection;

/**
 * Articles unitaires (en opposition aux lots).
 * Le prix n'est pas une "variable calculÃ©e".
 */
public abstract class ArticleUnitaire extends Article {
    private String nom;
    private double pu;

    public ArticleUnitaire(String reference, String nom, double pu) {
        super(reference);
        this.nom = nom;
        this.pu = pu;
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public double getPU() {
        return pu;
    }

    public void setPU(int pu) {
        this.pu = pu;
    }

    // Inutile de redÃ©finir toString() car le PU et le nom
    // sont dÃ©jÃ  affichÃ©s par la classe mÃ¨re (Article)

}
