package tp1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Assignation {
	String url="jdbc:mysql://localhost/tp1gl";
	 String user="root";
	 String password="";
	 Connection cn = null;
	 Statement st = null;
	 ResultSet rs = null;
	int idassign;
	int idTache;
	int idMembre;
	String sql;
	String sqlTache;
	String sqlMembre;
	Scanner sc = new Scanner(System.in);

	public void connectDB(){
		
		 try{
			 
			 Class.forName("com.mysql.jdbc.Driver");
			 System.out.println("driver OK");
			 
			 cn = DriverManager.getConnection(url,user,password);
			 st = cn.createStatement();
			 System.out.println("connexion effectuer");
		 }catch (ClassNotFoundException | SQLException e){
			 System.out.println(" Erreur de la connexion");
		 }
		
	}
	
	public void afficherTachAssign(){
		System.out.println("");
		System.out.println("*****LES TACHES ASSIGNEES A CHAQUE MEMBRE******");
		try{
			sql= "SELECT tache.nomTache , membre.nomMembre FROM tp1gl.tache, tp1gl.membre, tp1gl.assignation  WHERE membre.idMembre = assignation.idMembre AND tache.idTache = assignation.idTache ";
			rs= st.executeQuery(sql);
			System.out.println("|Les Taches|\t\t|Les Membres|");
			while (rs.next()){
				System.out.println(rs.getString("nomTache")+"\t\t"+ rs.getString("nomMembre"));
				
			}
			System.out.println("");
			System.out.println("#####FIN DE LA RECHERCHE#####");
			}catch (SQLException e){
			System.out.println("taches assignes introuvables");
		}
	}
	
	public void afficherAssign(){
		System.out.println("");
		System.out.println("###Tache assigner a membre###");
		
		try{
			sql= "SELECT  assignation.idtache, assignation.idmembre FROM gestiontachetp1.assignation ";
			rs= st.executeQuery(sql);
			System.out.println("|TACHES|\t|MEMBRES|");
			while (rs.next()){
				System.out.println(rs.getInt("assignation.idtache")+"\t\t"+ rs.getInt("assignation.idmembre"));
				
			}
			System.out.println("");
			
			}
			catch (SQLException e){
			System.out.println("taches assignes introuvables");
		}
	}
	public void modification(){
		
		System.out.print("Entrer l'identication du membre modifier: ");
		idMembre =sc.nextInt();
		
		System.out.print("Entrer le nouvel identication correspondant du membre modifier: ");
		int newIdMembre =sc.nextInt();
		try{
			sql = "UPDATE asignation SET `idmembre` = '"+newIdMembre+"' WHERE nom ='"+idMembre+"'";
			st.executeUpdate(sql);
			System.out.println("modification d'assignation effectue avec succes");
			
		}catch(SQLException e){
			System.out.println("echec de modification d'assignation");
		}finally{
			try{
				cn.close();
				st.close();
			}catch (SQLException e){
				System.out.println("deconnexion echoue");
			}
		}
		
	}
	
        public void assignation(){

                        System.out.print("ENTRER IDENTIFIANT DU MEMBRE : ");
                        idMembre=sc.nextInt();
                        System.out.print("ENTRER IDENTIFIANT DU TACHE : ");
                        idTache=sc.nextInt();
                         try{
                                        sql = "INSERT INTO tp1gl.assignation  VALUES ('"+ idassign +"','"+idMembre+"','"+idTache+"')";
                                        st.executeUpdate(sql);
                                        System.out.println("Assignation reussie");
                         }catch (SQLException e){
                                 System.out.println("Echec d'assignation");
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
}
