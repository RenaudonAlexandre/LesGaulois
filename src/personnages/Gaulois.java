package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "<<" + texte + ">>");
	}

    private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

    public void frapper(Romain romain) {
		int forceCoup = (force /3) * effetPotion;
    	System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom ());
		romain.recevoirCoup (forceCoup);		
	}
    
    @Override
    public String toString() {
    	return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
    }
    
    public void boirePotion(int forcePotion) {
		this.effetPotion = forcePotion;
		System.out.println(prendreParole() + "<<Merci Druide, je sens que ma force est " + effetPotion + " fois décuplée>>");
		
	}
	
    public static void main(String[] args) {
    	Gaulois asterix = new Gaulois("Astérix",8); 
    	Romain remus = new Romain("remus",2);
    	asterix.boirePotion(0);
    	asterix.frapper(remus);
    }
}