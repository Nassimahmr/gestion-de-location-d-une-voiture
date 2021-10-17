import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.sql.*;


public class Ajouter extends Dialog {
	
	private Label marque_Label, modele_Label, statut_Label,numero_meneralogique_Label, prix_Label, prix2_Label, kilometrage1_Label, kilometrage2_Label;
	private TextField marque, modele, numero_meneralogique, kilometre, prix;
	private static String marque1=null, modele1=null, numero_meneralogique1=null, kilometre1=null, prix1=null;
	private static int id = 0;
	public static String adr;
	public static Inet_Address ip;
	private ComboBox statut;
	
	public Ajouter(Frame parent, String title, boolean modal){
		super(parent, title, modal);
		this.setSize(700, 270);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		this.information();
		this.setVisible(true);
		
	}
	
	public static String getKilometre1() {
		return kilometre1;
	}

	public static String getPrix1() {
		return prix1;
	}

	public Ajouter(String marque, String modele, String numero_meneralogique, String kilometre, String prix, int id) {
		
		marque1 = marque;
		modele1 = modele;
		numero_meneralogique1 = numero_meneralogique;
		kilometre1=kilometre;
		prix1=prix;
		this.id = id;
	}
	public Ajouter(String marque, String modele, String numero_meneralogique, String kilometre, String prix) {
		
		marque1 = marque;
		modele1 = modele;
		numero_meneralogique1 = numero_meneralogique;
		kilometre1=kilometre;
		prix1=prix;
		
	}


	public String getMarque1() {
		return marque1;
	}



	public String getModele1() {
		return modele1;
	}



	public String getNumero_meneralogique1() {
		return numero_meneralogique1;
	}
	
	public int getId() {
		return id;
	}
	private void information(){

		
	System.out.println(getMarque1());
		
		Panel panmarque = new JPanel();
		panmarque.setBackground(Color.white);
		panmarque.setPreferredSize(new Dimension(220, 60));
		panmarque.setBorder(BorderFactory.createTitledBorder("Marque du vehicule"));
		marqueLabel = new JLabel("Marque : ");
		marque = new Text_Field(getMarque1());
		marque.setPreferredSize(new Dimension(90, 25));
		panmarque.add(marqueLabel);
		panmarque.add(marque);
		
    
		Panel panmodele = new Panel();
		panmodele.setBackground(Color.white);
		panmodele.setPreferredSize(new Dimension(220, 60));
		panmodele.setBorder(BorderFactory.createTitledBorder("Modèle du vehicule"));
		modeleLabel = new Label("Modèle : ");
		modele = new TextField(getModele1());
		modele.setPreferredSize(new Dimension(90, 25));
		panmodele.add(modeleLabel);
		panmodele.add(modele);
		
	
		Panel pannumero_meneralogique = new Panel();
		pannumero_meneralogique.setBackground(Color.white);
		pannumero_meneralogique.setPreferredSize(new Dimension(220, 60));
		pannumero_meneralogique.setBorder(BorderFactory.createTitledBorder("Matricule du vehicule"));
		numero_meneralogiqueLabel = new Label("Matricule : ");
		numero_meneralogique = new TextField(getNumero_meneralogique1());
		numero_meneralogique.setPreferredSize(new Dimension(90, 25));
		pannumero_meneralogique.add(numero_meneralogiqueLabel);
		pannumero_meneralogique.add(numero_meneralogique);

		Panel panStatut = new Panel();
		panStatut.setBackground(Color.white);
		panStatut.setPreferredSize(new Dimension(220, 60));
		panStatut.setBorder(BorderFactory.createTitledBorder("Statut vehicule"));
		statut = new ComboBox();
		statut.addItem("disponible");
		statut.addItem("reserve");
		statut.addItem("sortie");
		statutLabel = new Label("Etat : ");
		panStatut.add(statutLabel);
		panStatut.add(statut);
	
		Panel panKilometrage1 = new Panel();
		panKilometrage.setBackground(Color.white);
		panKilometrage.setPreferredSize(new Dimension(220, 60));
		panKilometrage.setBorder(BorderFactory.createTitledBorder("Kilometrage du vehicule"));
		kilometrage1_Label = new Label("Kilometrage : ");
		kilometrage2_Label = new Label(" KM");
		kilometre= new TextField(getKilometre1());
		kilometre.setPreferredSize(new Dimension(90, 25));
		panKilometrage.add(kilometrage_Label);
		panKilometrage.add(kilometre);
		panKilometrage.add(kilometrage2Label);
		

		Panel panPrix = new Panel();
		panPrix.setBackground(Color.white);
		panPrix.setPreferredSize(new Dimension(220, 60));
		panPrix.setBorder(BorderFactory.createTitledBorder("Prix du vehicule"));
		prixLabel = new Label("Prix : ");
		prix2Label = new Label(" Da");
		prix= new TextField(getPrix1());
		prix.setPreferredSize(new Dimension(90, 25));
		panPrix.add(prixLabel);
		panPrix.add(prix);
		panPrix.add(prix2Label);
		
		
		
		Panel content = new Panel();
		content.setBackground(Color.white);
		content.add(panmarque);
		content.add(panmodele);
		content.add(pannumero_meneralogique);
		content.add(panKilometrage);
		content.add(panPrix);
	if(marque1 != null) {
			
		content.add(panStatut);
		this.setSize(700, 270);
		}
		

		
		Panel control = new Panel();
		Button okBouton = new Button("Valider");
	
		okBouton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {				

				
				if(marque1 == null) {
			
				try {
				
					
					Statement state = Connect.getInstance()
					.createStatement();
				String requete = "INSERT INTO vehicule(marque,modele,numero_meneralogique,statut,kilometrage,prix) VALUES ('"+marque.getText()+"', '"+modele.getText()+"', '"+numero_meneralogique.getText()+"','disponible','"+kilometre.getText()+"', '"+prix.getText()+"')";
					 int resultat = state.executeUpdate(requete);
							
					 marque1=null; modele1=null; numero_meneralogique1=null; kilometre1=null; prix1=null;
					 Ajouter a = new Ajouter(marque1,modele1,numero_meneralogique1,kilometre1,prix1);
					 OptionPane confirmation = new OptionPane();
						confirmation.showMessageDialog(null, "Le vehicule a été ajouter ", "Mise à ajour", JOptionPane.INFORMATION_MESSAGE, null);

						
			
			 state.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			 catch (Exception e) {
				e.printStackTrace();
			}
			 setVisible(false);
				}
				else {

					try {
					
						
						Statement state = Connect.getInstance().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
						String query = "UPDATE vehicule SET marque = '"+marque.getText()+"', modele = '"+modele.getText()+"', numero_meneralogique = '"+numero_meneralogique.getText()+"', statut = '"+(String)statut.getSelectedItem()+"', kilometrage='"+kilometre.getText()+"', prix='"+prix.getText()+"' WHERE id = '"+id+"'";
						
					
						state.executeUpdate(query);

			                        state.close();
			                        OptionPane confirmation = new OptionPane();
									confirmation.showMessageDialog(null, "Le vehicule a été modifier ", "Mise à ajour", JOptionPane.INFORMATION_MESSAGE, null);

						
							
					
					}  catch (Exception e) {
			            				e.printStackTrace();
			            			}
			            			 setVisible(false);
					}            				
					}
	
		
		
		);
		
		JButton cancelBouton = new JButton("Annuler");
		cancelBouton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					setVisible(false);
				}catch(NullPointerException n) {
					System.exit(0);	
					
				}
			}			
		});
		
		control.add(okBouton);
		control.add(cancelBouton);
		JLabel icon = new JLabel(new ImageIcon("images/vehicule.jpg"));
		JPanel panIcon = new JPanel();
		panIcon.setBackground(Color.white);
		panIcon.setLayout(new BorderLayout());
		panIcon.add(icon);

		this.getContentPane().add(panIcon, BorderLayout.WEST);
		this.getContentPane().add(content, BorderLayout.CENTER);
		this.getContentPane().add(control, BorderLayout.SOUTH);
		
	
	}

}

