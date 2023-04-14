package org.example.collection;

import java.util.HashMap;
import java.util.NoSuchElementException;

/**
 * Un article vendu dans le magasin.
 * On suppose que tout article a une rÃ©fÃ©rence.
 */
public abstract class Article {
    private String reference;

    // Base de donnÃ©es des articles
    private static HashMap<String,Article> bdd = new HashMap<>();


    /**
     * CrÃ©e un article qui n'a qu'une rÃ©fÃ©rence. Son Ã©tat sera
     * initialisÃ© ensuite.
     */
    protected Article(String reference) {
        this.reference = reference;
        // Enregistrement dans la base de donnÃ©es des articles
        bdd.put(reference, this);
    }

    public String getReference() {
        return reference;
    }

    /**
     * Renvoie un article de la base de donnÃ©e.
     * @param reference rÃ©fÃ©rence de l'article
     * @return l'article cherchÃ©
     */
    public static Article getArticle(String reference) {
        Article article = bdd.get(reference);
        if (article == null) {
            throw new NoSuchElementException("Pas d'article de rÃ©fÃ©rence "
                    + reference);
        }
        else {
            return article;
        }
    }

    // Les méthodes suivantes correspondent Ã  des attributs de tout
    // article, mais qui sont "calculées" dans la classe Lot,
    // et pas associées Ã  une variable d'Ã©tat privée
    public abstract String getNom();

    public abstract double getPU();

    @Override
    public String toString() {
        return this.getClass().getName() + ":reference="
                + reference + "; nom=" + getNom() + ";PU=" + getPU();
    }

}