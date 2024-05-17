package Exercice1;

public class Main {
    public static void main(String args[]) throws InterruptedException {
        Tonneau Tonneau1 = new Tonneau("SuperTono", 5, 1, null);
        Tonneau Tonneau2 = new Tonneau("HyperTono", 11, 4, Tonneau1);
        // Tonneau2.AjoutVolume(1);
        // Tonneau2.RetireVolume(2);
        Tonneau2.Bouchon();
        Tonneau1.Bouchon();
    }
}