package personnages;

public class Romain {
	private String nom;
	private int force;
	private int nbEquipement = 0;
	private Equipement[] equipements = new Equipement[2];
	
	public Romain (String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert forceSup();
	}
	
	private boolean forceSup() {
		if (force > 0) {
			return true;
		}else {
			return false;
		}
	}
	
	private boolean forceDuRomain(Romain romain) 
	{
		if (force >= 0)
		{
			return true;
		} else {
			return false;
		}
	}
	
	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "<<" + texte + ">>");
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 2: 
			afficherMessageDejaProtege();
			break;
	    case 1:
	        if (equipements[0] == equipement) {
	        	afficherMessageDejaEquipe(equipement);
	        } else {
	        	ajouterEquipement(equipement);
	        }
	        break;
	    case 0:
	    	ajouterEquipement(equipement);
	    	break;	
		}
	}

	private void ajouterEquipement(Equipement equipement) {
	    equipements[nbEquipement] = equipement;
	    nbEquipement++;
	    System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement + ".");
	}

	
    private void afficherMessageDejaProtege() {
       System.out.println("Le soldat " + nom + " est déjà bien protégé !");
    }

	
	private void afficherMessageDejaEquipe(Equipement equipement) {
	    System.out.println("Le soldat " + nom + " possède déjà un " + equipement + " !");
	}
		
	public void recevoirCoup(int forceCoup) {
		assert forceSup();
		int coup = force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
		assert forceDiminue(coup);
	}
	
	private boolean forceDiminue(int coup) {
		if (force < coup) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		Romain remus = new Romain("remus",6);
		remus.recevoirCoup(2);
        remus.sEquiper(Equipement.CASQUE);
        remus.sEquiper(Equipement.CASQUE);
        remus.sEquiper(Equipement.BOUCLIER);
        remus.sEquiper(Equipement.CASQUE);
	}
}
