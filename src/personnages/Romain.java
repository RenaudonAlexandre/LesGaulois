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
	    default:
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
		
//	public void recevoirCoup(int forceCoup) {
//		assert forceSup();
//		int coup = force;
//		force -= forceCoup;
//		if (force > 0) {
//			parler("Aïe");
//		} else {
//			parler("J'abandonne...");
//		}
//		assert forceDiminue(coup);
//	}
	
	public Equipement[] recevoirCoup(int forceCoup) { 
		Equipement[] equipementEjecte = null; 
		// précondition 
		assert force > 0; 
		int oldForce = force; 
		forceCoup = calculResistanceEquipement(forceCoup); 
		force -= forceCoup; 
		// if (force > 0) { 
		// parler("Aïe"); 
		// } else { 
		// equipementEjecte = ejecterEquipement(); 
		// parler("J'abandonne..."); 
		// } 
		if (force==0) {
			parler("Aïe");
		} else {
			equipementEjecte = ejecterEquipement(); 
			parler("J'abandonne..."); 
		} 
		// post condition la force a diminuée 
		assert force < oldForce; 
		return equipementEjecte;
	}

	private int calculResistanceEquipement(int forceCoup) { 
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup; 
		int resistanceEquipement = 0; 
		if (nbEquipement != 0) { 
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de "; 
			for (int i = 0; i < nbEquipement; i++) { 
				if (equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) { 
					resistanceEquipement += 8; 
					} else { 
						System.out.println("Equipement casque"); 
						resistanceEquipement += 5; 
					}  
			} 
			texte += resistanceEquipement + "!"; 
		} 
		parler(texte); 
		forceCoup -= resistanceEquipement; 
		return forceCoup; 
	}
	
	private Equipement[] ejecterEquipement() { 
		Equipement[] equipementEjecte = new Equipement[nbEquipement]; 
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup."); 
		//TODO 
		int nbEquipementEjecte = 0; 
		int i = 0;
		while (i < nbEquipement) {
			if (equipements[i] != null) { 
				equipementEjecte[nbEquipementEjecte] = equipements[i]; 
				nbEquipementEjecte++; equipements[i] = null;
			i++;
			} 
		} 
		return equipementEjecte; 
	}
	
	private boolean forceDiminue(int coup) {
		if (force < coup) {
			return true;
		} else {
			return false;
		}
	}
	
	public int getForce() {
		return force;
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
