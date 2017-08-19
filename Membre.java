package tp1;

import java.sql.*;
import java.util.Scanner;

public class Membre {
	
	private int idMembre;
	private String nomMembre;
	private String sql;
	
	String url="jdbc:mysql://localhost/tp1gl";
	String user="root";
	String password="";
	Statement st = null;
	ResultSet rs = null;
	Connection cn = null;
	 
	Scanner sc = new Scanner(System.in);
	public int getidMembre() {
		return idMembre;
	}
	public void setID(int iD, int idMembre) {
		this.idMembre = idMembre;
	}
	public String getNom() {
		return nomMembre;
	}
	public void setNom(String nom) {
		this.nomMembre = nom;
	}
	
	 public void connectDB(){
		//s System.out.println("driver OKi");
		 try{
			 
			 Class.forName("com.mysql.jdbc.Driver");
			 
			 cn = DriverManager.getConnection(url,user,password);
			 st = cn.createStatement();
			 System.out.println("connexion etablie");
		 }catch (Exception e){
			 System.out.println("delai depasser");
	 }
 }
	
	public void modifier(){
		System.out.print("Entre le nom du membre a modifier: ");
		nomMembre=sc.nextLine();
		System.out.print("Entre le nouveau nom du membre modifier: ");
		String newNamMembre=sc.nextLine();
		try{
			sql = "UPDATE membre SET `nomMembre` = '"+newNamMembre +"' WHERE nomMembre ='"+nomMembre+"'";
			st.executeUpdate(sql);
			System.out.println("modification effectue avec succes");
			
		}catch(Exception e){
			System.out.println("echec de modification");
		}finally{
			try{
				cn.close();
				st.close();
			}catch (Exception e){
				System.out.println("deconnexion echoue");
			}
		}
		
	}
	
	public void supprimer(){
		System.out.println("");
		System.out.print("Entrer l'identifiant du membre supprimer : ");
		idMembre=sc.nextInt();
		try{
			sql ="DELETE FROM membre WHERE membre.idMembre='"+idMembre+"'";
			st.executeUpdate(sql);
			System.out.print("membre supprime");
		}
		catch(Exception e){
			System.out.print("echec de suppression de ce membre");
		}
		
	}
	public void ajouter(){
		
		System.out.print("Entrer le nom du membre : ");
		nomMembre=sc.nextLine();
		 try{
			 	sql = "INSERT INTO Membre(`idMembre`,`nomMembre`) VALUES ('"+ idMembre +"','"+nomMembre+"')";
			 	st.executeUpdate(sql);
			 	System.out.println("ajout reussi");
		 }catch (SQLException e){
			 System.out.println("error d'ajout de membre");
		 }finally{
				try{
					cn.close();
					st.close();
					System.out.println("deconnexion reussie");
				}catch (SQLException e){
					System.out.println("deconnexion echoue");
				}
			}
		
           
	}
	public void selectionner(){
		
		System.out.println("");
		System.out.println("Recherche de toutes les taches assignees un membre : ");
		System.out.println("Saisir l'id du membre : ");
		idMembre=sc.nextInt();
		System.out.println("Resultat de la recherche : ");
		try{
			sql= "SELECT nomTache, nomMembre FROM tache, membre, assignation  WHERE assignation.idMembre = membre.idMembre AND assignation.idtache = tache.idTache AND assignation.idMembre='"+idMembre+"'";
			rs= st.executeQuery(sql);
			System.out.println("|TACHES|\t\t|MEMBRE|");
			while (rs.next()){
				System.out.println(rs.getString("tache.nomTache")+"\t\t"+ rs.getString("membre.nomMembre"));
				//System.out.print(rs.getString("membre.nommembre")+"\t");
				//System.out.print(rs.getString("gestiontachetp1.tache.nomtache ")+"\t");
				//System.out.println("");
			}
			
			System.out.println("####FIN#####");
			}catch (Exception e){
			System.out.println("taches assignees introuvables");
		}finally{
			try{
				cn.close();
				st.close();
				System.out.println("deconnexion reussie");
			}catch (Exception e){
				System.out.println("deconnexion echoue");
			}
		}
		
		
	}
        
        public void afficherDB(){
		
		System.out.println("");
		System.out.println("BASE DE DONNEE : ");
		System.out.println(" ");
                connectDB();
		try{
		
			sql= "SELECT * FROM Membre";
                        System.out.println(" ");    
			rs= st.executeQuery(sql);
                        System.out.println(" ");
			System.out.println("|idMembre|\t\t|MEMBRE|");
			while (rs.next()){
                            
				System.out.println(rs.getInt("idMembre")+"\t\t"+ rs.getString("nomMembre"));
                               
				
			}
			
			System.out.println(" ");
			}catch (SQLException e){
			System.out.println("echec");
		}
        }
        

}
