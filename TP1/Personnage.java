import java.util.Random;

public class Personnage {
	private String name;
	private Informations initial;
	private Informations actuel;

    public Personnage(String name, Informations initial, Informations actuel) {
        this.name = name;
        this.actuel = actuel;
        this.initial = initial;
    }

    public String toString() {
        return "Personnage nommé " + this.name + ". Informations initiales : " + initial.toString() + ". Informations actuelles : " + actuel.toString() + ".";
    }

    public boolean estVivant() {
        if (this.actuel.getVitalite() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void rebirth() {
        this.actuel.setAgility(this.initial.getAgility());
        this.actuel.setVitalite(this.initial.getVitalite());
        this.actuel.setForce(this.initial.getForce());
    }

    public void attaque(Personnage def) {
        int max = (1 >= this.actuel.getForce()-def.actuel.getForce())? 1 : this.actuel.getForce()-def.actuel.getForce();
        Random rd = new Random();
        int n = rd.nextInt(max);
        if(def.actuel.getAgility() < this.actuel.getAgility()) def.actuel.setVitalite(def.actuel.getVitalite()-n);
        if(def.actuel.getAgility() > this.actuel.getAgility()) {
            def.actuel.setVitalite(def.actuel.getVitalite()-n/2);
            def.actuel.setAgility(def.actuel.getAgility()/3);
        }
    }

    public void lutte(Personnage p2) {
        while(p2.actuel.getVitalite() >= 0 && this.actuel.getVitalite() >= 0 ) {
            System.out.println("Le Personnage 1 attaque.");
            this.attaque(p2);
        }

        if(this.actuel.getVitalite() == 0) {
            System.out.println("Le Personnage 2 a gagné.");
        } else {
            System.out.println("Le Personnage 1 a gagné.");
        }

        System.out.println();
        System.out.println(this.toString());
        System.out.println(p2.toString());
        System.out.println("Le combat est terminé.");
    }
}