import java.awt.BorderLayout;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.UnknownHostException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;

import javax.swing.Button;
import javax.swing.Frame;
import javax.swing.Label;
import javax.swing.Menu;
import javax.swing.MenuBar;
import javax.swing.MenuItem;
import javax.swing.OptionPane;
import javax.swing.Panel;
import javax.swing.ScrollPane;
import javax.swing.SplitPane;
import javax.swing.TabbedPane;
import javax.swing.Table;
import javax.swing.TextField;
import javax.swing.ToolBar;
import javax.swing.KeyStroke;
import javax.swing.border.Border;


public class Accueil extends JFrame {


	private static final MenuItem Bon_de_reservation = null;
	private MenuBar menuBar = new MenuBar();
	private Menu edition = new Menu("Edition");
	private Menu location = new Menu("Vehicule");
	private Menu clients = new Menu("Clients");
	private Menu facture = new Menu("Facture");
	private Menu reservation = new Menu("Réservation");
	private Menu contrat = new Menu("Contrat");
	private MenuItem bdd = new MenuItem("Base de données");
	private Menu aide = new Menu("Aide");
	private Menu user = new Menu("Utilisateurs");
	public static String adr;
	private Menu config = new Menu("Paramètres");
	private MenuItem serveur = new MenuItem("Envoyer message au serveur");
	private MenuItem factura = new MenuItem("Facture");
	private MenuItem aide_support = new MenuItem("Aide et Support");
	private static JMenuItem liste_poste = new MenuItem("Liste des membres CSL connectés");
	private MenuItem liste_tout = new MenuItem("Liste du groupe CSL");
	private MenuItem liste_client = new MenuItem("Liste de tout les clients");
	private MenuItem liste_client_attente = new MenuItem("Liste des clients en attente");
	private MenuItem liste_client_cours = new MenuItem("Liste des clients sous contrat");
	static MenuItem liste_voiture_libre = new MenuItem("Liste des vehicules disponible");
	static MenuItem liste_voiture_sorties = new MenuItem("Liste des vehicule sorties");
	static MenuItem liste_voiture_reserve = new MenuItem("Liste des vehicule réservés");
	private MenuItem liste_voiture_retard = new MenuItem("Liste des vehicule en retard");
	private MenuItem tout_voiture = new MenuItem("Liste de toutes les voitures");
	private MenuItem nouvelle_facture = new MenuItem("Nouvelle Facture");
	private MenuItem annuler_contrat = new MenuItem("Annuler un contrat");
	private MenuItem contrat_listes = new MenuItem("Liste des contrats");
	private MenuItem facture_listes = new MenuItem("Liste des factures");
	private MenuItem contrat_de_location = new MenuItem("Contrat de location");
	private MenuItem bon_de_reservation = new MenuItem("Bon de reservation");
	private MenuItem liste_des_reservation = new MenuItem("Liste des réservation");
	private MenuItem fermer = new MenuItem("Fermer");
	private Menu maj_voiture = new Menu("Mise à jour");
	private MenuItem consulter_vehicule = new MenuItem("Consulter");
	private MenuItem ajouter_vehicule = new MenuItem("Créer");
	private MenuItem modifier_vehicule = new MenuItem("Modifier");
	private MenuItem supprimer_vehicule = new MenuItem("Supprimer");
	private Menu maj_user = new Menu("Mise à jour");
	private MenuItem consulter = new MenuItem("Consulter");
	private MenuItem ajouter = new MenuItem("Créer");
	private MenuItem modifier = new MenuItem("Modifier");
	private MenuItem supprimer = new MenuItem("Supprimer");
	final Background contient= new Background();
	final Background2 contient2= new Background2();
	private static JSplitPane split;
	private static JPanel menu = new JPanel();
	private TabbedPane p;
	
	private static boolean ok =false, gauche=true, droite=false,haut=false,bas=false;
	private static String rowCount,rowCount2,rowCount3,rowCount4,rowCount5,rowCount6;
	private  int row1,row2,row3,row4,row6;
	private TextField text3,text1,text2,text4,text6;
	public static int onglet = TabbedPane.LEFT;
	
	public Accueil(boolean ok){
		this.ok=ok;
		
	}
	public Accueil(){
		
		this.setTitle("Chabanus Sheep Auto Location ");
		this.setSize(new Dimension(800, 600));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
	
		fermer.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}				
		});
		this.config.add(bdd);
		this.config.add(fermer);
		
	
		
		nouvelle_facture.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				
				facture();
				
			}
			
		});
		
		icone_facture.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				
				facture();
				
			}
			
		});
		
		
	
		contrat_de_location.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
			
				
				
				try {

					marques();
				} catch (RemoteException e) {
					
					e.printStackTrace();
				}
				
			
				
			
			}
			
		});
		
		icone_contrat.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
			
				
				
				try {

					marques();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
				
			
			}
			
		});
		annuler_contrat.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				
				annuler_contra();
				
			}

			
			
		});
		
		contrat_listes.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				String requete = "SELECT id,nom,prenom,nss,marque,modele FROM facture WHERE statut='sortie' ORDER BY id ";
				contrat_list(requete);
			}
			
		});
		
		liste_des_reservation.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				String requete = "SELECT id,nom,prenom,nss,marque,modele FROM facture WHERE statut='attente' ORDER BY id ";
				reservation_list(requete);
			}
			
		});
		
		connecte.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				String requete = "SELECT id,nom,prenom,nss,marque,modele FROM facture WHERE statut='sortie' ORDER BY id ";
				contrat_list(requete);
			}
			
		});
		
		facture1.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				String requete = "SELECT id,nom,prenom,nss,marque,modele FROM facture WHERE statut='regler' ORDER BY id ";
				facture_list(requete);
			}
			
		});
		
		bon_de_reservation.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				try {
					try {
						Reserva l = new Reserva(null, "Réservation : Informations Véhicule", true);
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		 			
		 		} catch (MalformedURLException e) {
		 			
		 			e.printStackTrace();
		 		} catch (SQLException e) {
		 
		 			e.printStackTrace();
		 		} catch (NotBoundException e) {
		 			
		 			e.printStackTrace();
		 		}
			}
			
		});
		
		icone_reserva.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				try {
					try {
						Reserva l = new Reserva(null, "Réservation : Informations Véhicule", true);
					} catch (RemoteException e) {
						
						e.printStackTrace();
					}
		 			
		 		} catch (MalformedURLException e) {
		 			
		 			e.printStackTrace();
		 		} catch (SQLException e) {
		 			
		 			e.printStackTrace();
		 		} catch (NotBoundException e) {
		 			
		 			e.printStackTrace();
		 		}
			}
			
		});
		
		reservee.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				String requete = "SELECT id,nom,prenom,nss,marque,modele FROM facture WHERE statut='attente' ORDER BY id ";
				reservation_list(requete);
			}
			
		});
		
		sortie1.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
		String requete = "SELECT marque,modele FROM vehicule WHERE statut = 'sortie'  ORDER BY marque";
		vehicule(requete);
		
	}
			
		});
		facture_listes.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				String requete = "SELECT id,nom,prenom,nss,marque,modele FROM facture WHERE statut='regler' ORDER BY id ";
				facture_list(requete);
			}
			
		});
		
		liste_client.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				String requete = "SELECT nom,prenom,nss,adresse,tel,permis,etat FROM client ORDER BY id ";
				clients(requete);
			}
			
		});
		
		client.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				String requete = "SELECT nom,prenom,nss,adresse,tel,permis,etat FROM client ORDER BY id ";
				clients(requete);
			}
			
		});
		liste_client_cours.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				String requete = "SELECT nom,prenom,etat FROM client WHERE etat='servis' ORDER BY id ";
				clients(requete);
			}
			
		});
		liste_client_attente.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				String requete = "SELECT nom,prenom,etat FROM client WHERE etat='reserve' ORDER BY id ";
				clients(requete);
			}
			
		});
		// LISTE VOITURES DISPONIBLE
		liste_voiture_libre.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				String requete = "SELECT marque,modele FROM vehicule WHERE statut = 'disponible'  ORDER BY marque ";
				vehicule(requete);
			}
			
		});
		
		disponible.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				String requete = "SELECT marque,modele FROM vehicule WHERE statut = 'disponible'  ORDER BY marque ";
				vehicule(requete);
			}
			
		});
		
		liste_voiture_sorties.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				String requete = "SELECT marque,modele FROM vehicule WHERE statut = 'sortie'  ORDER BY marque";
				vehicule(requete);
			}
			
		});
		
	
		liste_voiture_reserve.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				String requete = "SELECT marque,modele FROM vehicule WHERE statut = 'reserve'  ORDER BY marque";
vehicule(requete);
			}
			
		});
		
		reserve.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				String requete = "SELECT marque,modele FROM vehicule WHERE statut = 'reserve'  ORDER BY marque";
vehicule(requete);
			}
			
		});
		
		liste_voiture_retard.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				String requete = "SELECT marque,modele FROM vehicule WHERE statut = 'retard'  ORDER BY marque";
				vehicule(requete);
			}
			
		});
		
		tout_voiture.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				vehicule_tout();
			}
			
		});
		
		getListe_poste().addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				String requete = "SELECT log FROM utilisateurs WHERE statut = 'en ligne' ";
				user(requete);
			}
			
		});
		
		
		liste_tout.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				user();
			}
			
		});
		
		
	
		
		config.setMnemonic('P');
		menuBar.add(config);
		
		location.setMnemonic('V');
		menuBar.add(location);
		    	
		clients.setMnemonic('l');
		menuBar.add(clients);
		
		
		
		contrat.setMnemonic('C');
		menuBar.add(contrat);
		reservation.setMnemonic('R');
		menuBar.add(reservation);
		facture.setMnemonic('F');
		menuBar.add(facture);
		
		user.setMnemonic('U');
		menuBar.add(user);
		
	
		this.setVisible(true);
			
this.user.add(maj_user);
		
		maj_user.add(consulter);
		maj_user.add(ajouter);
		maj_user.add(modifier);
		maj_user.add(supprimer);
		maj_user.setBackground(Color.white);
		consulter.setBackground(Color.white);
		ajouter.setBackground(Color.white);
		modifier.setBackground(Color.white);
		supprimer.setBackground(Color.white);
		
		
		
		
		
		
		
		
		
		
		
		
	
		this.location.add(liste_voiture_libre);
		this.location.add(liste_voiture_sorties);
		this.location.add(liste_voiture_reserve);
		this.location.add(tout_voiture);
		this.location.addSeparator();
		this.location.add(maj_voiture);
	
		
		
		
		
		liste_voiture_libre.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4,
                KeyEvent.CTRL_MASK));
		liste_voiture_sorties.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_5,
                KeyEvent.CTRL_MASK));
		liste_voiture_reserve.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_6,
                KeyEvent.CTRL_MASK));
		liste_voiture_retard.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_7,
                KeyEvent.CTRL_MASK));
		tout_voiture.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_8,
                KeyEvent.CTRL_MASK));
		
		maj_voiture.add(consulter_vehicule);
		maj_voiture.add(ajouter_vehicule);
		maj_voiture.add(modifier_vehicule);
		maj_voiture.add(supprimer_vehicule);
	
		
		bdd.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,
                KeyEvent.CTRL_DOWN_MASK + KeyEvent.SHIFT_DOWN_MASK));
		fermer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2,
                KeyEvent.CTRL_DOWN_MASK + KeyEvent.SHIFT_DOWN_MASK));
		consulter_vehicule.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
                KeyEvent.CTRL_DOWN_MASK + KeyEvent.SHIFT_DOWN_MASK));
		ajouter_vehicule.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
                KeyEvent.CTRL_DOWN_MASK + KeyEvent.SHIFT_DOWN_MASK));
		modifier_vehicule.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,
                KeyEvent.CTRL_DOWN_MASK + KeyEvent.SHIFT_DOWN_MASK));
		supprimer_vehicule.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
                KeyEvent.CTRL_DOWN_MASK + KeyEvent.SHIFT_DOWN_MASK));
		
		consulter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
                KeyEvent.CTRL_DOWN_MASK + KeyEvent.ALT_DOWN_MASK));
		ajouter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
                KeyEvent.CTRL_DOWN_MASK + KeyEvent.ALT_DOWN_MASK));
		modifier.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,
                KeyEvent.CTRL_DOWN_MASK + KeyEvent.ALT_DOWN_MASK));
		supprimer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
                KeyEvent.CTRL_DOWN_MASK + KeyEvent.ALT_DOWN_MASK));
		
		this.clients.add(liste_client);
		this.clients.add(liste_client_attente);
		this.clients.add(liste_client_cours);
		
		
		liste_client.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,
                KeyEvent.CTRL_MASK));
		liste_client_attente.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2,
                KeyEvent.CTRL_MASK));
		liste_client_cours.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3,
                KeyEvent.CTRL_MASK));
		
			 contrat.addMouseMotionListener(new MouseMotionListener(){
					public void mouseDragged(MouseEvent e) {
						 try
						    {
							 p.setSelectedIndex(1);
						    }catch(Exception e11 ){}
					}

					@Override
					public void mouseMoved(MouseEvent arg0) {
						// TODO Stub de méthode généré automatiquement
						p.setSelectedIndex(1);
					}
					}
		 );
			 location.addMouseMotionListener(new MouseMotionListener(){
					public void mouseDragged(MouseEvent e) {
						 try
						    {
							 p.setSelectedIndex(5);
						    }catch(Exception e11 ){}
					}

					@Override
					public void mouseMoved(MouseEvent arg0) {
						// TODO Stub de méthode généré automatiquement
						p.setSelectedIndex(5);
					}
					}
		 );
			 
			 clients.addMouseMotionListener(new MouseMotionListener(){
					public void mouseDragged(MouseEvent e) {
						 try
						    {
							 p.setSelectedIndex(4);
						    }catch(Exception e11 ){}
					}

					@Override
					public void mouseMoved(MouseEvent arg0) {
						// TODO Stub de méthode généré automatiquement
						p.setSelectedIndex(4);
					}
					}
		 );
			 facture.addMouseMotionListener(new MouseMotionListener(){
					public void mouseDragged(MouseEvent e) {
						 try
						    {
							 p.setSelectedIndex(3);
						    }catch(Exception e11 ){}
					}

					@Override
					public void mouseMoved(MouseEvent arg0) {
						// TODO Stub de méthode généré automatiquement
						p.setSelectedIndex(3);
					}
					}
		 );
				
			 reservation.addMouseMotionListener(new MouseMotionListener(){
					public void mouseDragged(MouseEvent e) {
						 try
						    {
							 p.setSelectedIndex(2);
						    }catch(Exception e11 ){}
					}

					@Override
					public void mouseMoved(MouseEvent arg0) {
						// TODO Stub de méthode généré automatiquement
						p.setSelectedIndex(2);
					}
					}
		 );
			
			
			
		this.facture.add(nouvelle_facture);
		this.facture.add(facture_listes);
		this.contrat.add(contrat_de_location);
		this.reservation.add(bon_de_reservation);
		this.reservation.add(liste_des_reservation);
		this.contrat.add(annuler_contrat);
		this.contrat.add(contrat_listes);
	
		
			
	
		
		   

		this.menuBar.add(contrat);
		this.menuBar.add(reservation);
		this.menuBar.add(facture);
			
			this.menuBar.add(clients);
			this.menuBar.add(location);
			this.menuBar.add(user);
			
	
			
			this.setJMenuBar(menuBar);
			
			bon_de_reservation.setBackground(Color.white);
	
			nouvelle_facture.setBackground(Color.white);
			facture_listes.setBackground(Color.white);
			contrat_de_location.setBackground(Color.white);
			annuler_contrat.setBackground(Color.white);
			liste_des_reservation.setBackground(Color.white);
			contrat_listes.setBackground(Color.white);
			
			annuler_contrat.setIcon(new ImageIcon("images/annula.jpg"));
			bon_de_reservation.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,
                    KeyEvent.CTRL_MASK));
			liste_des_reservation.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,
                    KeyEvent.CTRL_MASK));
			
			nouvelle_facture.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,
                    KeyEvent.CTRL_MASK));
			facture_listes.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
                    KeyEvent.CTRL_MASK));
			
			contrat_de_location.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,
                    KeyEvent.CTRL_MASK));
			contrat_listes.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
                    KeyEvent.CTRL_MASK));
			annuler_contrat.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
                    KeyEvent.CTRL_MASK));
			facture.add(nouvelle_facture);
			
			
		
			rowCount = "SELECT id FROM facture WHERE statut = 'sortie' ";
			nombre_vehicule(rowCount);

			rowCount2 = "SELECT modele FROM vehicule WHERE statut = 'disponible' ";
			nombre_vehicule(rowCount2);
			
			rowCount3 = "SELECT modele FROM vehicule WHERE statut = 'sortie' ";
			nombre_vehicule(rowCount3);

			rowCount4 = "SELECT modele FROM vehicule WHERE statut = 'reserve' ";
			nombre_vehicule(rowCount4);
			
			rowCount5 = "SELECT modele FROM vehicule WHERE statut = 'retard' ";
			nombre_vehicule(rowCount5);
			rowCount6 = "SELECT id FROM facture WHERE statut = 'attente' ";
			
		
			 row1 = nombre_vehicule(rowCount);
			row2 = nombre_vehicule(rowCount2);
			 row3 = nombre_vehicule(rowCount3);
			row4 = nombre_vehicule(rowCount4);
		
			 row6 = nombre_vehicule(rowCount6);

			 Button actualiser = new Button("Actualiser");
			 actualiser.setPreferredSize(new Dimension(200, 20));
			 
			 actualiser.addActionListener(new ActionListener(){

			 	public void actionPerformed(ActionEvent arg0) {
			 		
			 		 row1 = nombre_vehicule(rowCount);
			 			row2 = nombre_vehicule(rowCount2);
			 			 row3 = nombre_vehicule(rowCount3);
			 			text3.setText(""+row3);
			 			text2.setText(""+row2);
			 			text1.setText(""+row1);
			 			row4 = nombre_vehicule(rowCount4);
			 			 row6 = nombre_vehicule(rowCount6);
			 			text4.setText(""+row4);
			 			text6.setText(""+row6);
			 			 System.out.println(row4);
			 	}
			 	
			 });
		
	

Label lib = new Label("Nombre de contrat:");
Label lib2 = new Label("Vehicule disponible:");
Label lib4 = new Label("Vehicule reservés:");
Label lib3 = new Label("Vehicule sorties:" );
Label lib6 = new Label("Nombre de réservation:");

Button facture = new Button("Nouvelle facture");
facture.setPreferredSize(new Dimension(200, 20));
Button contra = new Button("Nouveau contrat");
contra.setPreferredSize(new Dimension(200, 20));
Button reserva = new Button("Nouvelle reservation");
reserva.setPreferredSize(new Dimension(200, 20));



facture.addActionListener(new ActionListener(){

	public void actionPerformed(ActionEvent arg0) {
		
		facture();
		
	}
	
});

reserva.addActionListener(new ActionListener(){

	public void actionPerformed(ActionEvent arg0) {
		
		reserva();
		
	}

	private void reserva() {
		// TODO Stub de méthode généré automatiquement
		try {
			try {
				Reserva l = new Reserva(null, "Réservation : Informations Véhicule", true);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 			
 		} catch (MalformedURLException e) {
 			// Bloc de capture TODO généré automatiquement
 			e.printStackTrace();
 		} catch (SQLException e) {
 			// Bloc de capture TODO généré automatiquement
 			e.printStackTrace();
 		} catch (NotBoundException e) {
 			// Bloc de capture TODO généré automatiquement
 			e.printStackTrace();
 		}
	}
	
});
Panel panlib = new Panel();
lib.setPreferredSize(new Dimension(160, 20));
panlib.setBorder(listBorder[0]);
lib.setAlignmentX(Label.CENTER);
text1 =  new TextField(""+row1);
text1.setPreferredSize(new Dimension(50, 20));

JButton boutonlib = new Button("Voir");
panlib.add(iconlib);
panlib.add(lib);
panlib.add(text1);
panlib.add(boutonlib);
panlib.setBackground(Color.white);



Panel panlib2 = new Panel();
lib2.setPreferredSize(new Dimension(160, 20));
panlib2.setBorder(listBorder[1]);
lib2.setAlignmentX(Label.CENTER);
text2 =  new TextField(""+row2);
text2.setPreferredSize(new Dimension(50, 20));

Button boutonlib2 = new Button("Voir");
panlib2.add(iconlib2);
panlib2.add(lib2);
panlib2.add(text2);
panlib2.add(boutonlib2);
panlib2.setBackground(Color.white);


Panel panlib3 = new Panel();
lib3.setPreferredSize(new Dimension(160, 20));
panlib3.setBorder(listBorder[3]);
lib3.setAlignmentX(Label.CENTER);
text3 =  new TextField(""+row3);
text3.setPreferredSize(new Dimension(50, 20));

Button boutonlib3 = new Button("Voir");
panlib3.add(iconlib3);
panlib3.add(lib3);
panlib3.add(text3);
panlib3.add(boutonlib3);
panlib3.setBackground(Color.white);

Panel panlib4 = new Panel();
lib4.setPreferredSize(new Dimension(160, 20));
panlib4.setBorder(listBorder[2]);
lib4.setAlignmentX(Label.CENTER);
text4 =  new TextField(""+row4);
text4.setPreferredSize(new Dimension(50, 20));

Button boutonlib4 = new Button("Voir");
panlib4.add(iconlib4);
panlib4.add(lib4);
panlib4.add(text4);
panlib4.add(boutonlib4);
panlib4.setBackground(Color.white);

Panel panlib6 = new Panel();
lib6.setPreferredSize(new Dimension(160, 20));
panlib6.setBorder(listBorder[0]);
lib6.setAlignmentX(JLabel.CENTER);
text6 =  new TextField(""+row6);
text6.setPreferredSize(new Dimension(50, 20));
JLabel iconlib6 = new Label(new ImageIcon("images/reservee.jpg"));
Button boutonlib6 = new Button("Voir");
panlib6.add(iconlib6);
panlib6.add(lib6);
panlib6.add(text6);
panlib6.add(boutonlib6);
panlib6.setBackground(Color.white);

Panel premiere_couche = new Panel();
premiere_couche.setPreferredSize(new Dimension(350, 380));
premiere_couche.setBackground(Color.white);
if(row1 == 0) {
			boutonlib.setEnabled(false);
			getListe_poste().setEnabled(false);
			facture1.setEnabled(false);
		
}
if(row2 == 0){
			boutonlib2.setEnabled(false);
			liste_voiture_libre.setEnabled(false);
			disponible.setEnabled(false);
}
if(row3== 0){
			boutonlib3.setEnabled(false);
liste_voiture_reserve.setEnabled(false);

sortie1.setEnabled(false);}
if(row4 == 0){
			boutonlib4.setEnabled(false);
liste_voiture_sorties.setEnabled(false);
reserve.setEnabled(false);}

if(row6 == 0) {
	boutonlib.setEnabled(false);
	Accueil.getListe_poste().setEnabled(false);
}

Label vide = new Label("                                    ");
vide.setPreferredSize(new Dimension(600, 20));
premiere_couche.add(vide);
premiere_couche.add(contra);
premiere_couche.add(reserva);
premiere_couche.add(facture);
premiere_couche.add(actualiser);
premiere_couche.add(panlib);
premiere_couche.add(panlib6);
premiere_couche.add(panlib2);
premiere_couche.add(panlib4);
premiere_couche.add(panlib3);





// LISTE VOITURES DISPONIBLE
boutonlib2.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				String requete = "SELECT marque,modele FROM vehicule WHERE statut = 'disponible' ORDER BY marque ";
				vehicule(requete);
			}
			
});

boutonlib3.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				String requete = "SELECT marque,modele FROM vehicule WHERE statut = 'sortie'  ORDER BY marque";
				vehicule(requete);
			}
			
});

boutonlib.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				String requete = "SELECT id,nom,prenom,nss,marque,modele FROM facture WHERE statut='sortie' ORDER BY id ";
				contrat_list(requete);
			}
			
});

boutonlib6.addActionListener(new ActionListener(){

	public void actionPerformed(ActionEvent arg0) {
		String requete = "SELECT id,nom,prenom,nss,marque,modele FROM facture WHERE statut='attente' ORDER BY id ";
		reservation_list(requete);
	}
	
});
boutonlib4.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				String requete = "SELECT marque,modele FROM vehicule WHERE statut = 'reserve' ORDER BY marque";
				vehicule(requete);
			}
			
});











  
contra.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
			
				
				try {
					marques();
				} catch (RemoteException e) {
					// Bloc de capture TODO généré automatiquement
					e.printStackTrace();
				}
				
			
				
			
			}
			
});

client_contrat.addActionListener(new ActionListener(){

	public void actionPerformed(ActionEvent arg0) {
	
		
		String requete = "SELECT nom,prenom FROM client WHERE etat = 'servis' ORDER BY id ";
		try {
			vehicule(requete);
		} catch (Exception e) {
			// Bloc de capture TODO généré automatiquement
			e.printStackTrace();
		}
		
	
		
	
	}
	
});

client_attente.addActionListener(new ActionListener(){

	public void actionPerformed(ActionEvent arg0) {
	
		
		String requete = "SELECT nom,prenom FROM client WHERE etat = 'reserve'  ORDER BY id";
		try {
			vehicule(requete);
		} catch (Exception e) {
			// Bloc de capture TODO généré automatiquement
			e.printStackTrace();
		}
		
	
		
	
	}
	
});

//AJOUTER VEHICULE
ajouter_vehicule.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent arg0) {
		Ajouter zd = new Ajouter(null, "Ajouter un vehicule", true);
	}				
});

//CONSULTER VEHICULE

consulter_vehicule.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent arg0) {
		Consulter c = new Consulter();
		c.setVisible(true);
	}				
});

//MODIFIER VEHICULE
modifier_vehicule.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent arg0) {
		try {
			Modifier_vehicule m = new Modifier_vehicule();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}				
});

//SUPPRIMER VEHICULE
supprimer_vehicule.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent arg0) {
		try {
			Supprimer_vehicule s = new Supprimer_vehicule();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}				
});

//FERMER VEHICULE

fermer.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent arg0) {
		System.exit(0);
	}				
});

//CONFIGURATION VEHICULE
bdd.addActionListener(new ActionListener(){

	public void actionPerformed(ActionEvent arg0) {
		BDD zd = new BDD(null, "Paramètres : Informations base de donnée", true);
		
	
	}
	
});


//AJOUTER UN UTILISATEUR
ajouter.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent arg0) {
		Ajouter_user c = new Ajouter_user(null, "Ajouter un utilisateur", true);
		c.setVisible(true);
	}				
});

//CONSULTER UTILISATEUR

consulter.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent arg0) {
		Consulter_user c = new Consulter_user();
		c.setVisible(true);
	}				
});

// MODIFIER UTILISATEUR
modifier.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent arg0) {
		
		try {
			Modifier_user c1 = new Modifier_user();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	
	
});

supprimer.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent arg0) {
		try {
			Supprimer_user s = new Supprimer_user();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}				
});

change_onglet.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent arg0) {
		if(gauche) {
		p.setTabPlacement(1);
		gauche=false;
		haut = true;
		
		}
		else if(haut){
			p.setTabPlacement(2);
			haut=false;
			gauche=false;
			droite=false;
			bas=true;
			
		}
		else if(bas){
			p.setTabPlacement(3);
			bas=false;
			haut=false;
			gauche=false;
			droite=true;
			
		}
		else if(droite){
			p.setTabPlacement(4);
			droite=false;
			bas=false;
			haut=false;
			gauche=true;
			
		}
	}				
});



lb.setPreferredSize(new Dimension(300, 320));
contient.setBackground(Color.white);
Panel doubl = new Panel();
doubl.add(lb);
doubl.add(premiere_couche);

initToolBar();
contient.add(doubl,  BorderLayout.CENTER);
contient.setBackground(Color.white);



p = new TabbedPane(onglet);

p.add("",contient);
p.add("", new Contrat());

p.add("", new Onglet_reservation());

p.add("", new Onglet_facture());

p.add("", new Onglet_Client());

p.add("", new Onglet_Voiture());


split = new JSplitPane(JSplitPane.VERTICAL_SPLIT, menu,p);
split.setOneTouchExpandable(true);



this.setContentPane(split);

	
	}
	public class Background extends JPanel {
		 
	    public void paintComponent(Graphics g){
	            try {
	                    Image img = ImageIO.read(new File("images/fond2.jpg"));
	                     g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	            } catch (IOException e) {
	                    // TODO Auto-generated catch block
	                    e.printStackTrace();
	            }
	            
	    }               
	}	
	
	public class Background2 extends JPanel {
		 
	                
	}	
	public static void main(String[] args) throws UnknownHostException, MalformedURLException, RemoteException, NotBoundException, InterruptedException{
		BDD zd = new BDD(null, "Etape 1/2 : Configuration de la base de donnée", true);
		new Client(null, "Etape 2/2 : Informations utilisateur", true);
		if(true){
	chargement wind = new chargement();
		wind.setVisible(true);
		Thread.sleep(4500);
		wind.setVisible(false);
		
		
	
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
			
				new Accueil();
			}
		});
		}
	}
	  private ToolBar toolBar = new ToolBar();
	
	  
	

	 private void initToolBar(){
	    
	    	
		 icone_facture.setToolTipText("Faire une nouvelle facture");
		 icone_contrat.setToolTipText("Faire une nouveau contrat");
		 icone_reserva.setToolTipText("Faire une nouvelle réservation");
		 change_onglet.setToolTipText("Changer la position de l'onglet");
		 reservee.setToolTipText("Afficher la liste des réservation");
		 facture1.setToolTipText("Afficher la liste des factures");
		 client_attente.setToolTipText("Afficher la liste des clients ayant réservé");
		 client_contrat.setToolTipText("Afficher la liste des clients sous contrats");
		 reserve.setToolTipText("Afficher la liste des vehicules en réservation");
		 sortie1.setToolTipText("Afficher la liste des vehicules non disponible");
		 disponible.setToolTipText("Afficher la liste des vehicules disponible");
		 
		 this.toolBar.add(icone_contrat);
	    	this.toolBar.add(icone_reserva);
	    	this.toolBar.add(icone_facture);
		
	    	this.toolBar.addSeparator();
	    	this.toolBar.addSeparator();
	    	this.toolBar.addSeparator();
		
	    	
	    	
	   	this.toolBar.add(change_onglet);
		 
	
		 this.change_onglet.setBackground(fondBouton);
	   	
			this.toolBar.addSeparator();
	    	this.toolBar.addSeparator();
	    	this.toolBar.addSeparator();
	    	this.toolBar.add(connecte);
	    	this.toolBar.add(reservee);
	    	this.toolBar.add(facture1);
	    	this.toolBar.addSeparator();
	    	this.toolBar.addSeparator();
	    	this.toolBar.addSeparator();
	    	this.connecte.setBackground(fondBouton);
	    	this.reservee.setBackground(fondBouton);
	    	this.facture1.setBackground(fondBouton);
	    	this.disponible.setBackground(fondBouton);
	    	this.toolBar.add(disponible);
	    
	    	
	    	//Ajout des Listeners
	    	
	    	this.reserve.setBackground(fondBouton);
	    	this.toolBar.add(reserve);
	    	
	    	this.sortie1.setBackground(fondBouton);
	    	this.toolBar.add(sortie1);
	    	
	    	
	    	
	    	this.toolBar.addSeparator();
	    	this.toolBar.addSeparator();
	    	this.toolBar.addSeparator();
	    	
	    	
	    	this.toolBar.add(client);
	    	
	    	this.toolBar.add(client_contrat);
	 
	    	this.toolBar.add(client_attente);
	
	    	
	    
	    	menu.add(toolBar, BorderLayout.CENTER);
	    	menu.setPreferredSize(new Dimension(600, 50));
   }

 	 synchronized static public  int nombre_vehicule(String requete)  {
 	 	// À FAIRE Stub de méthode généré automatiquement
 	 	Statement state;
 	 	int rowCount = 0;
 	 	try {
 	 		state = Connect.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

 	 	ResultSet res = state.executeQuery(requete);
 	 	res.last();
 	 	rowCount = res.getRow();                    
 	 	res.close();
 	 	state.close();
 	 	} catch (SQLException e) {
 	 		// À FAIRE Bloc catch généré automatiquement
 	 		e.printStackTrace();
 	 	}
 	 	return rowCount;
 	 }
 	 
 	synchronized public void marques() throws RemoteException {
 		// TODO Stub de méthode généré automatiquement
 		
 		try {
 			Location l = new Location(null, "Contrat : Informations Véhicule", true);
 			
 		} catch (MalformedURLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		} catch (NotBoundException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}

 	}
 	synchronized public void user(String requete) {
 		// TODO Auto-generated method stub
 	Liste_connecte c = new Liste_connecte(requete);
 		
 		
 		c.setVisible(true);
 	}
 	synchronized public static void vehicule(String requete)  {
 		// TODO Auto-generated method stub
 		
 		Liste_vehicule c = new Liste_vehicule(requete);
 		
 		
 		c.setVisible(true);
 	}
 	synchronized public void clients(String requete)  {
 		// TODO Stub de méthode généré automatiquement
 		
 		Liste_clients c = new Liste_clients(requete);
 		
 		
 		c.setVisible(true);
 	}
 	synchronized public void user()  {
 		// TODO Stub de méthode généré automatiquement
 		Liste_user c = new Liste_user();
 		c.setVisible(true);
 	}


 	synchronized public void vehicule_tout()  {
 		// TODO Auto-generated method stub
 		Liste_vehicule c = new Liste_vehicule();
 		c.setVisible(true);
 		
 	}
 	
 	synchronized public static void facture()  {
 		// TODO Auto-generated method stub
 		try {
			facture c = new facture();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 	
 		
 	}
 	synchronized public static void annuler_contra() {
 	// TODO Stub de méthode généré automatiquement
 		try {
			annule_contrat c = new annule_contrat();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
 	synchronized static public void contrat_list(String requete)  {
 		contrat_liste c = new contrat_liste(requete);
 		c.setVisible(true);
 		
 	}
 	synchronized static public void facture_list(String requete)  {
 		facture_liste c = new facture_liste(requete);
 		c.setVisible(true);
 		
 	}

	synchronized static public void reservation_list(String requete)  {
		reservation_liste c = new reservation_liste(requete);
 		c.setVisible(true);
 		
 	}
 	
	public void setListe_poste(JMenuItem liste_poste) {
		this.liste_poste = liste_poste;
	}




	public static JMenuItem getListe_poste() {
		return liste_poste;
	}
	
	 }
