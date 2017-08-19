package tp1;

import java.util.Scanner;

public class Principal {

	private static Scanner sc;
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Membre mbre=new Membre();
		Tache tach = new Tache();
		ConnexionDB cnx = new ConnexionDB();
		sc = new Scanner(System.in);
		Assignation as=new Assignation();
		
		Menu men = new Menu();
		
            OUTER:
            while (true) {
                men.menu();
                int choix1 = sc.nextInt();
                
                
                
                switch (choix1) {
                    case 5:
                        System.out.println("  ");
                        System.out.println("1 : Modifier l'assignation d'une tache  ");
                        System.out.println("2 : Assigner une tache a un membre  ");
                        System.out.print("choix : ");
                        int choixassign = sc.nextInt();
                        switch (choixassign) {
                            case 1:
                                cnx.connectDB();
                                //cnx.affficherM();
                                cnx.afficherT();
                                as.connectDB();
                                as.afficherTachAssign();
                                as.afficherAssign();
                                as.modification();
                                break;
                            case 2:
                                cnx.connectDB();
                                // cnx.afficheBD();
                                cnx.afficherT();
                                as.connectDB();
                                //as.afficherTachAssign();
                                //as.afficherAssign();
                                as.assignation();
                                break;
                            default:
                                System.out.println("Faites le bon choix : ");
                                break;
                        }   break;
                    case 6:
                        System.out.println("AU REVOIR!");
                        //System.exit(0);
                        break OUTER;
                        
                    case 7:
                        System.out.println("ERREUR DE SAISIE!");
                        //System.exit(0);
                        break OUTER;    
                        
                    default:
                        System.out.println("  ");
                        System.out.println("---veuillez faire votre choix---");
                        System.out.println("1 : pour tache ");
                        System.out.println("2 : pour Membre");
                        System.out.print("choix : ");
                        int choix = sc.nextInt();
                        if (choix1==1 && choix==1){
                            tach.connectDB();
                            tach.afficherTacheDB();
                            tach.ajoutertache();
                            tach.afficherTacheDB();
                            
                            
                        }
                        else if( choix1==1 && choix==2){
                            mbre.connectDB();
                            mbre.ajouter();
                            mbre.afficherDB();
                            tach.afficherTacheDB();
                            
                        }
                        else if (choix1==2 && choix==1){
                            tach.connectDB();
                            tach.modifier();
                            mbre.selectionner();
                            mbre.afficherDB();
                            tach.afficherTacheDB();
                            
                            
                        }
                        else if (choix1==2 && choix==2){
                            mbre.connectDB();
                            mbre.modifier();
                            mbre.afficherDB();
                            tach.afficherTacheDB();
                            
                        }
                        else if (choix1==3 && choix==1){
                            tach.connectDB();
                            tach.supprimer();
                            tach.selectionner();
                            mbre.afficherDB();
                            tach.afficherTacheDB();
                            
                            
                        }
                        else if (choix1==3 && choix==2){
                            
                            mbre.connectDB();
                            mbre.supprimer();
                            mbre.afficherDB();
                            tach.afficherTacheDB();
                            
                        }
                        else if (choix1==4 && choix==1){
                            
                            tach.connectDB();
                            tach.selectionner();
                            mbre.afficherDB();
                            //tach.afficherTacheDB();
                            
                        }
                        else if (choix1==4 && choix==2){
                            tach.connectDB();
                            mbre.connectDB();
                            //mbre.afficherDB();
                            tach.afficherTacheDB();
                            
                        }       break;
                }
            }

        }
}
