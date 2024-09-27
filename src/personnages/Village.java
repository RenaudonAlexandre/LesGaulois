package personnages;

public class Village {
	private String nom;
	private int nbVillageois = 0;
	private Gaulois villageois[];
	private Chef chef;

	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		this.villageois = new Gaulois[nbVillageoisMaximum];
	}

	public void ajouterHabitant(Gaulois gaulois) {
		villageois[nbVillageois] = gaulois;
		nbVillageois += 1;
	}

	public Gaulois trouverHabitant(int nbVillageois) {
		return villageois[nbVillageois];
	}

	public String getNom() {
		return nom;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public void afficherVillageois(Chef chef) {
		System.out.println(("dans le village du chef"+chef+" vivent les légendaires gaulois :"));
		for (int i = 0; i < nbVillageois; i++) {
			System.out.println(villageois[i]);
			}
	}


	public static void main(String[] args) {
		Village village= new Village("Village des Irréductibles",30);
		//Gaulois gaulois = village.trouverHabitant(30);
		//On obtient l'execption car on sort du tableau
		Chef chef=new Chef("Abraracourcix",6,village);
		village.setChef(chef);
		Gaulois asterix = new Gaulois("Astérix",8);
		village.ajouterHabitant(asterix);
		//Gaulois gaulois = village.trouverHabitant(1);
		//System.out.println(gaulois);
		// on veut voir l'élément d'indice 1 alors que le seul gaulois à avoir été ajouter au tableau est d'indice 0
		Gaulois obelix = new Gaulois("Obélix",25);
		village.ajouterHabitant(obelix);
		village.afficherVillageois(chef);
	}

}
