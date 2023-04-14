package org.example.collection;

    /**
     * Une facture.
     * Remarque : maintenant que vous connaissez les collections,
     * vous pouvez remplacer le tableau de lignes par une liste de lignes,
     * ce qui Ã©viterait d'avoir Ã  passer le nombre de lignes maximum
     * d'une facture.
     */
    public class Facture {
        // Nombre maximum de lignes par dÃ©faut
        private static int NB_MAX_LIGNES = 10;
        private static int numeroCourant = 0;
        private String client, date;
        private Ligne[] lignes;
        /** Nombre de lignes dans la facture */
        private int nbLignes = 0;
        /** NumÃ©ro de la facture */
        private int numero = 0;


        public Facture(String client, String date, int nbLignes) {
            this.client = client;
            this.date = date;
            this.lignes = new Ligne[nbLignes];
            numero = ++numeroCourant;
        }

        public Facture(String client, String date) {
            this(client, date, NB_MAX_LIGNES);
        }

        public void ajouterLigne(String referenceArticle, int quantite) {
            lignes[nbLignes++] = new Ligne(Article.getArticle(referenceArticle), quantite);
        }

        public int getPrixTotal() {
            int pt = 0;
            for (int i = 0; i < nbLignes; i++) {
                pt += lignes[i].prixTotal();
            }
            return pt;
        }

        /**
         * Affichage de la facture sous une forme plus lisible.
         * Utilisation de printf "comme dans le langage C" (pas Ã©tudiÃ© dans le cours).
         */
        public void afficheToi() {
            System.out.printf("Facture numÃ©ro %d ; Client : %s ; Date : %s %n",
                    numero, client, date);
            System.out.printf("%7s | %6s | %22s | %10s | %10s %n",
                    "Quant.", "RÃ©f.", "Nom", "PU", "PT");
            for (int i = 0; i < nbLignes; i++) {
                lignes[i].afficheToi();
            }
            System.out.printf("%35s Prix total facture : %10d", "", getPrixTotal());
        }

        @Override
        public String toString() {
            String descript =
                    "Facture " + numero + ";Client=" + client + ";Date=" + date + "\n";
            for (int i = 0; i < nbLignes; i++) {
                descript += lignes[i] + "\n";
            }
            descript += "Prix total Facture=" + getPrixTotal();
            return descript;
        }
    }

    /*
     * Si les classes internes ont dÃ©jÃ  Ã©tÃ© Ã©tudiÃ©es, il est prÃ©fÃ©rable
     * que Ligne soit une classe interne static private de Facture. Testez-le.
     */
    class Ligne {
        private Article article;
        private int quantite;

        Ligne(Article article, int quantite) {
            this.article = article;
            this.quantite = quantite;
        }

        Article getArticle() {
            return article;
        }

        int getQuantite() {
            return quantite;
        }

        void afficheToi() {
            System.out.printf("%7d | %6s | %22s | %10d | %10d %n",
                    quantite, article.getReference(),
                    article.getNom(),
                    article.getPU(), prixTotal());
        }

        double prixTotal() {
            return article.getPU() * quantite;
        }

        @Override
        public String toString() {
            return quantite + " " + article;
        }
    }
