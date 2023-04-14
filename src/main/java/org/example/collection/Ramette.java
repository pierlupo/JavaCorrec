package org.example.collection;

public class Ramette extends ArticleUnitaire {
    private int grammage;

    public Ramette(String reference, String nom, int pu, int grammage) {
        super(reference, nom, pu);
        this.grammage = grammage;
    }

    public int getGrammage() {
        return grammage;
    }

    @Override
    public String toString() {
        return super.toString() + ";grammage=" + grammage;
    }
}
