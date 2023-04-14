package org.example.exception;

import java.util.Scanner;

public class SommeTableau {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] tableau = new int[6];
        int sum = 0;
        try {
            System.out.print("Entrez les éléments du tableau : ");
            for (int i = 0; i < tableau.length; i++) {
                try {
                    tableau[i] = Integer.parseInt(input.next());
                    sum += tableau[i];
                } catch (NumberFormatException e) {
                    System.out.println("Erreur : l'élément n°" + (i+1) + " n'est pas un nombre valide.");
                }
            }
            if (sum == 0) {
                System.out.println("Erreur : le tableau est vide.");
            } else {
                System.out.println("La somme des éléments du tableau est : " + sum);
            }
        } catch (Exception e) {
            System.out.println("Erreur : impossible de lire à partir de la console.");
        }
    }
}

