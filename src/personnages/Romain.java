package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements;
	int nbEquipement=0;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		assert(force >= 0);
		this.force = force;
		equipements= new Equipement[2];
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
		
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		int avantforce=force;
		force -= forceCoup;
		
		if (force > 0) {
			parler("Aie");
			
		} else {
			parler("J'abandonne...");
		}
	assert(force <= avantforce);
	}
	
	private void mettreEquipement(Equipement equipement) {
		equipements[nbEquipement]=equipement;
		nbEquipement+=1; 
		System.out.println("Le soldat " + nom + " s’équipe avec un " + equipement.toString()+".");
	}
	
	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 2:
			System.out.println("Le soldat "+nom+ " est déjà bien protégé !");
			break;
		case 1:
			if(equipements[nbEquipement-1].toString()==equipement.toString()) {
				System.out.println("« Le soldat "+nom+" possède déjà "+equipement.toString()+".");}
			else {
				mettreEquipement(equipement);
			}
			break;
		default:
			
			mettreEquipement(equipement);
		}
		
	}

	
	public static void main(String[] args) {		
		Romain minus=new Romain("Minus",6);
		minus.recevoirCoup(2);
		System.out.println(Equipement.CASQUE);
		System.out.println(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.BOUCLIER);
	}
	
	
}
