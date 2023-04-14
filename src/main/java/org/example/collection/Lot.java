package org.example.collection;

public class Lot extends Article{
    /**
     * Article dont le lot est constituÃ©
     */
    private Article article;
    private int nb, pourcentage;

    public Lot(String reference, String referenceArticle, int nb, int pourcentage) {
        super(reference);
        // Remarque : on pourrait vÃ©rifier que la rÃ©fÃ©rence n'est pas celle du lot
        // lui-mÃªme, ce qui conduirait Ã  une rÃ©cursivitÃ© sans fin dans getNom().
        this.article = Article.getArticle(referenceArticle);
        this.nb = nb;
        this.pourcentage = pourcentage;
    }

    @Override
    public String getNom() {
        return "Lot de " + nb + " " + article.getNom();
    }

    @Override
    public double getPU() {
        return nb * article.getPU() * (100 - pourcentage) / 100;
    }

    public int getNbArticles() {
        return nb;
    }

    public int getPourcentage() {
        return pourcentage;
    }

    public Article getArticle() {
        return article;
    }

    @Override
    public String toString() {
        return super.toString() + ";%rÃ©duction=" + pourcentage
                + ";composÃ© de " + nb + " [" + article + "]";
    }
}
