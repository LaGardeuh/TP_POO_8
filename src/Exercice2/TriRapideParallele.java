package Exercice2;

import java.util.Arrays;

public class TriRapideParallele {
    public static void main(String[] args) throws InterruptedException {
        int[] tableau = { 5, 3, 7, 2, 8, 4, 9, 1, 6 };

        System.out.println("Tableau avant le tri : " + Arrays.toString(tableau));

        TriRapideThread thread = new TriRapideThread(tableau, 0, tableau.length - 1);
        thread.start();
        thread.join();

        System.out.println("Tableau après le tri : " + Arrays.toString(tableau));
    }
}