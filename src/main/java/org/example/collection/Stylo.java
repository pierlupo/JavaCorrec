package org.example.collection;

public class Stylo extends ArticleUnitaire{
    private String couleur;

    public Stylo(String reference, String nom, int pu, String couleur) {
        super(reference, nom, pu);
        this.couleur = couleur;
    }

    public String getCouleur() {
        return couleur;
    }

    @Override
    public String toString() {
        return super.toString() + ";couleur=" + couleur;
    }
}
