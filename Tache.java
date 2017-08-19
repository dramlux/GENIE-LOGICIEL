package tp1;

import java.sql.*;

import java.util.Scanner;

public class Tache {
	private int idTache;
	private String nomTache;
	private String descripTache;
	private String statusTache;
	private int idMembre;
	String sql;
	
	 String url="jdbc:mysql://localhost/tp1gl";
	 String user="root";
	 String password="";
	 Connection cn = null;
	 Statement st = null;
	 ResultSet rs = null;
	 Scanner sc = new Scanner(System.in);
	 
	
	public Tache(   String statusTache, String descripTache, String nomTache) {
		super();
		this.nomTache = nomTache;
		this.descripTache = descripTache;
		this.statusTache = statusTache;
	}
	
	
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
	
	 public Tache() {
			super();
			// TODO Auto-generated constructor stub
		}
		
	 
	
	public int getidTache() {
		return idTache;
	}
	public void setidTache(int idTach) {
		idTache = idTach;
	}
	public String getNom() {
		return nomTache;
	}
	public void setNom(String nomTach) {
		this.nomTache = nomTach;
	}
	public String getDescription() {
		return descripTache;
	}
	public void setDescription(String descript) {
		this.descripTache = descript;
	}
	public String getStatus() {
		return statusTache;
	}
	public void setStatut(String status) {
		this.statusTache = status;
	}
		
	public String getNomTache() {
		return nomTache;
	}

	public void setNomTache(String nomTache) {
		this.nomTache = nomTache;
	}

	public int getIdmembre() {
		return idMembre;
	}

	public void setIdmembre(int idMembre) {
		this.idMembre = idMembre;
	}

	
	public void modifier( ){
		System.out.println("old Tache");
		String oldNamTache=sc.nextLine();
		System.out.println("new Tache");
		String newNamTache = sc.nextLine();
		System.out.println("old description");
		String oldDescript = sc.nextLine();
		System.out.println("new description");
		String newDescript = sc.nextLine();
		System.out.println("old status");
		String oldStatus = sc.nextLine();
		System.out.println("new Tache");
		String newStatus=sc.nextLine();
		try{
			 
			sql = " UPDATE tache SET  nomTache='"+newNamTache+"',descriptTache='"+newDescript+"',statusTache='"+newStatus+"' WHERE nomTache ='"+oldNamTache+"'AND descripTache='"+oldDescript+"'AND statusTache='"+oldStatus+"'";
			st.executeUpdate(sql);
			System.out.println("status modifier");
		}catch (SQLException e){
			System.out.println("modification echoue !");
		}finally{
			try{
				
				cn.close();
				st.close();
				System.out.println("deconnexion");
			}catch (SQLException e){
				System.out.println("erreur deconnexion");
			}
		}
	}

	public void supprimer(){
		System.out.println("");
		System.out.println("id de Tache a supprimer : ");
		idTache=sc.nextInt();
		try{
			sql ="DELETE FROM tache WHERE idTache='"+nomTache+"'";
			st.executeUpdate(sql);
			System.out.println("Suppression reussi");
		}
		catch(SQLException e){
			System.out.println("echec de suppression ");
		}
	}
	
	
    
        
        
        
        
        
        public void ajoutertache(){
		
		System.out.print("Entrer le nom de la tache : ");
		nomTache=sc.nextLine();
                System.out.print("Entrer la description de la tache : ");
                descripTache=sc.nextLine();
                System.out.print("Entrer le status de la tache : ");
                statusTache=sc.nextLine();
                //connectDB();
		 try{
			 	sql = "INSERT INTO tache VALUES ('"+idTache+"','"+nomTache+"','"+descripTache+"','"+statusTache+"')";
			 	st.executeUpdate(sql);
			 	System.out.println("ajout reussi");
		 }catch (SQLException e){
			 System.out.println("error d'ajout de tache");
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
		System.out.println("RECHERCHE DE TACHE SUIVANT STATUS");
		System.out.println("Veillez entrer le status des taches : ");
		statusTache=sc.nextLine(); 
		System.out.println("Resultat de la recherche : ");
		try{
			
		
			sql= "SELECT `nomTache` ,`statusTache` FROM tache WHERE statusTache ='"+statusTache+"' ";
			
			rs= st.executeQuery(sql);
			System.out.println("|TACHES|\t\t|STATUS|");
			while (rs.next()){
				System.out.println(rs.getString("nomTache")+"\t\t"+ rs.getString("statustache"));
			}
			System.out.println("");
			
			}catch (SQLException e){
			System.out.println("taches  not found");
		}finally{
			try{
				
				cn.close();
				st.close();
				System.out.println("reussite");
			}catch (SQLException e){
				System.out.println("echec deconnexion");
			}
		}
	}
        
    
    public void afficherTacheDB(){
		
		System.out.println("");
		System.out.println("BASE DE DONNEE : ");
		System.out.println(" ");
                connectDB();
		try{
		
			sql= "SELECT * FROM tache";
                        System.out.println(" ");    
			rs= st.executeQuery(sql);
                        System.out.println(" ");
			System.out.println("|idTache|\t|nomTache|\t|statusTache|\t|descripTache|");
			while (rs.next()){
                            
				System.out.println(rs.getInt("idTache")+"\t\t"+ rs.getString("nomTache")+"\t\t"+ rs.getString("descripTache")+"\t\t"+ rs.getString("statusTache"));
                               
				
			}
			
			System.out.println(" ");
			}catch (SQLException e){
			System.out.println("echec");
		}
        }

}
