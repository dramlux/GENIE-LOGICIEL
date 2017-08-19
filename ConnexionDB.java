package tp1;

import java.sql.*;

import java.util.Scanner;

public class ConnexionDB {
	String url="jdbc:mysql://localhost/tp1gl";
	String user="root";
	String password="";
	String sql;
	Connection cnx = null;
	Statement st = null;
	ResultSet rs = null;
	
	
	Scanner sc = new Scanner(System.in);
	
	 
	 public void connectDB(){
			
		 try{
			 
			 Class.forName("com.mysql.jdbc.Driver");
			 System.out.println("driver OK");
			 
			 cnx = DriverManager.getConnection(url,user,password);
			 st = cnx.createStatement();
			 System.out.println("connexion reussi");
		 }catch (ClassNotFoundException | SQLException e){
			 System.out.println("erreur  connexion");
	 }
 }

	 
        public void AfficherM(){
                System.out.println("");
                System.out.println("####AFFICHAGE DE LA BASE DE DONNEES####");
                System.out.println("");

                       try{
                               st = cnx.createStatement();
                               sql= "SELECT * FROM Membre;";
                               rs= st.executeQuery(sql);
                               System.out.println("MEMBRES : ");
                               System.out.println("|IDENTIFIANT DES MEMBRES|\t|NOM DES MEMBRE|");
                                       while (rs.next()){
                                       System.out.print("\t");
                                       System.out.print(rs.getInt("idmembre")+"\t");
                                       System.out.print("\t\t\t");
                                       System.out.print(rs.getString("nomMembre")+"\t");
                                       System.out.println("");
                               }

                               }
                               catch (SQLException e){
                               System.out.println("erreur de l'affichage");
                       }
               }
	 
        public void afficherT(){
                System.out.println("");
                try{
                        sql= "SELECT * FROM tache ";
                        rs= st.executeQuery(sql);
                         System.out.println("LES TACHES : ");
                        System.out.println("|ID TACHES|\t|NOM DES TACHES|\t\t| DESCRIPTION|\t\t\t\t\t| STATUS");
                                while (rs.next()){
                                System.out.print("\t");	
                                System.out.print(rs.getInt("idTache")+"\t");
                                System.out.print(rs.getString("nomTache")+"\t\t\t");
                                System.out.print(rs.getString("descriptTache")+"\t\t\t\t\t");
                                System.out.print(rs.getString("statusTache")+"\t\t");
                                System.out.println(" ");
                        }

                }
                catch (SQLException e){
                        System.out.println("erreur de l'affichage");
                }
        }

    

}
