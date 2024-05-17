package Exercice1;

import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Tonneau {
    public static Scanner scanner = new Scanner(System.in);
    String Nom;
    int VolumeInit, VolumeMax;
    int DebitFuite;
    Tonneau TonneauFuite;
    Lock verrouAjout = new ReentrantLock();
    Lock verrouRetire = new ReentrantLock();

    public Tonneau(String Nom, int VolumeInit, int DebitFuite, Tonneau TonneauFuite) {
        this.Nom = Nom;
        this.VolumeInit = VolumeInit;
        this.VolumeMax = 12;
        this.DebitFuite = DebitFuite;
        this.TonneauFuite = TonneauFuite;
    }

    public int AjoutVolume(int Volume) {
        verrouAjout.lock();
        try {
            if (VolumeInit + Volume <= VolumeMax) {
                this.VolumeInit += Volume;
                System.out.println("Dans le tonneau " + this.Nom + " on a ajouté " + Volume
                        + " le volume du tonneau est maintenant de : " + this.VolumeInit);
                return Volume;
            } else {
                System.out.println(this.Nom + " déborde !");
                this.VolumeInit = VolumeMax;
                System.out.println("Le volume du tonneau est capé au maximum, soit " + this.VolumeInit);
                return Volume;
            }
        } finally {
            verrouAjout.unlock();
        }
    }

    public int RetireVolume(int Volume) {
        verrouRetire.lock();
        try {
            if (VolumeInit - Volume >= 0) {
                this.VolumeInit -= Volume;
                System.out.println("Dans le tonneau " + this.Nom + " on a retiré " + Volume
                        + " le volume du tonneau est maintenant de : " + this.VolumeInit);
            } else {
                this.VolumeInit = 0;
                System.out.println("Le tonneau " + this.Nom + " est vide.");
            }
            return Volume;
        } finally {
            verrouRetire.unlock();
        }
    }

    public void Bouchon() throws InterruptedException {
        while (this.VolumeInit != 0) {
            this.RetireVolume(this.DebitFuite);
            if (TonneauFuite != null) {
                this.TonneauFuite.AjoutVolume(this.DebitFuite);
            }
            Thread.sleep(1000);
        }

    }
}
