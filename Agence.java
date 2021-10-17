emplacement du package;
importer java.util.Vector;

 classe publique Agence {
	 
	 nom de chaîne privé;
	 adresse de chaîne privée ;
	 
	 / Attibuts deduits des relations
      privé Vecteur <Employer> employes ;
       Directeur directeur privé ;
      Privé Vector <Voiture> voiture ;
     
		
	agence publique (String nom, String adresse) {
		super();
		cefichier . nom = nom;
		cefichier . adresse = adresse;
	}

	public Agence(String nom, String adresse, Vector<Employe> employes, Directeur directeur, Vector<Voiture> voiture) {
		super();
		cefichier . nom = nom;
		cefichier . adresse = adresse;
		cefichier . employes = employes;
		cefichier . directeur = directeur;
		cefichier . voiture = voiture;
	}
	
	public Vector<Employer> getEmployes() {
		les employés de retour;
	}

	ensemble de vide publicEmployes(Vecteur<Employe> employes ) {
		cefichier . employes = employes;
	}

	directeur public  getDirecteur() {
		directeur du retour;
	}

	public void setDirecteur(Directeur directeur) {
		cefichier . directeur = directeur;
	}

	Public Vector<Voiture> getVoiture() {
		retour voiture;
	}

	public void setVoiture(Vector<Voiture> voiture) {
		cefichier . voiture = voiture;
	}

	 chaîne publique getNomNom() {
		nom de retour;
	}
	public void setNom(Nom de chaîne) {
		cefichier . nom = nom;
	}
	chaîne publique  getAdresse() {
		adresse de retour;
	}
	public void setAdresse(String adresse) {
		cefichier . adresse = adresse;
	}
	
	/ Les méthodes 
	afficher public voidVoitures () {
		/ on utilise boucle for afin d’afficher le vecteur des voitures
		for  ( Voiture v : voiture ) {
			Système. sortie. println( v. getMatricule()+" "  + v. getType()+  " "  + v. getMarque()+  " "+ v. getCarteGrise());
		}
	}

		afficher public voidVoituresLouees () {
			/ on utilise boucle for afin d’afficher le vecteur des voitures
			for  ( Voiture v : voiture ) {
				si ( v. isLouee()) {
				Système. sortie. println( v. getMatricule()+" "  + v. getType()+  " "  + v. getMarque()+  " "+ v. getCarteGrise());
				}
				
				}


	

		}	
	
