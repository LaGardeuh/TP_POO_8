package Exercice2;

class TriRapideThread extends Thread {
    private int[] tableau;
    private int premier;
    private int dernier;

    public TriRapideThread(int[] tableau, int premier, int dernier) {
        this.tableau = tableau;
        this.premier = premier;
        this.dernier = dernier;
    }

    public void run() {
        tri_rapide(tableau, premier, dernier);
    }

    private int partitionner(int[] T, int premier, int dernier) {
        int pivot = T[dernier];
        int j = premier;

        for (int i = premier; i < dernier; i++) {
            if (T[i] <= pivot) {
                int temp = T[i];
                T[i] = T[j];
                T[j] = temp;
                j++;
            }
        }

        int temp = T[dernier];
        T[dernier] = T[j];
        T[j] = temp;

        return j;
    }

    private void tri_rapide(int[] T, int premier, int dernier) {
        if (premier < dernier) {
            int pivot = partitionner(T, premier, dernier);
            tri_rapide(T, premier, pivot - 1);
            tri_rapide(T, pivot + 1, dernier);
        }
    }
}