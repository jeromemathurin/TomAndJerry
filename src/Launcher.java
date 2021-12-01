import java.util.Random;
import java.util.Scanner;

public class Launcher {
	
	static int initialTx = 0;
	static int initialTy = 0;
	static int initialJx = 0;
	static int initialJy = 0;
	static int i = 0;
	static int j = 0;
	static Random rand = new Random();
	static boolean victoire = false;
	static boolean endGame = false;
	static boolean continuer = false;
	static String choixmenu = null;
	static String dir = null ;
	static int  remainingTurns = -1;
	static boolean stop = false;
	static String choixAxe = null;
	static int carteAxeX = -1;
	static int carteAxeY = -1;
	
	public static void main(String[] args) {
		
			// afficher menu + choix jouer ou quitter 
			endGame = AffichageMenu();	
		do {
			if (!endGame) {
				do {
					//afficher "choisir le niveau de la carte" petit "1" ou moyen"2"
					menuNiveauCarte();
					
				
					
				//coordonnée de Jerry
					do {
						for (i=0 ; i<30; i++) {
							initialJx = rand.nextInt(carteAxeX);		
						}
					} while (initialJx == 0 || initialJx == (carteAxeX - 1));
					
					do {
						for (i=0 ; i<30; i++) {
							initialJy = rand.nextInt(carteAxeY);			
						}
					} while (initialJy == 0 || initialJy == (carteAxeY - 1));
//						//test
//						System.out.print(" # Position de Jerry " + initialJx + " et ");
//						//test
//						System.out.println(initialJy);
			
						
				//coordonnée de Tom				
						do {
							for (i=0 ; i<30; i++) {
								initialTx =rand.nextInt(carteAxeX);		
							}
						} while (initialTx == 0 || initialTx == (carteAxeX - 1)); // creation de la position x tant qu'elle est sur la bordure de la carte
						
						do {
							for (i=0 ; i<30; i++) {
								initialTy = rand.nextInt(carteAxeY);			
							}
						} while (initialTy == 0 || initialTy == (carteAxeY - 1)); // creation de la position y tant qu'elle est sur la bordure de la carte
						
						
//						//test
//						System.out.print(" * Position de Tom " + initialTx + " et ");
//						//test
//						System.out.println(initialTy);
				
				//Faire une condition en cas de coordonnées identiques
				}while(initialJx == initialTx && initialJy == initialTy);
	
	
			//creation grille de jeu
	
				AfficherCarte(initialTx, initialTy, initialJx, initialJy);
	        
		        try {
		        	for (i=2 ; i < 50 ; i++) {
		        	remainingTurns = rand.nextInt(100);
		        	}
		        } catch (Exception e) {
			        }
			        System.out.println("Nombres de tours restant: " + remainingTurns);
			}
	        
	
	        while(!endGame) {      	
		        try {
		        	Scanner in = new Scanner(System.in);
			        System.out.println("Choisissez la diection que Tom doit prendre !");
			        System.out.println("     N     ");
			        System.out.println("  NO   NE"  );
			        System.out.println("O         E");
			        System.out.println("  SO   SE  ");
			        System.out.println("     S     ");
			        System.out.println("     8     ");
			        System.out.println("  7     9"  );
			        System.out.println("4         6");
			        System.out.println("  1     3  ");
			        System.out.println("     2     ");
			        dir = in.next() ;
	
			        //System.out.println( dir ); //test de saisie
	
		        } catch( Exception e) {
		        	System.out.println("Mauvaise saisie");
		        	
		        }
		        
	
		        
//		        System.out.print(" # Position de Jerry " + initialJx + " et ");
//				//test
//				System.out.println(initialJy);
		        
		        switch(dir) {
		        case "1":
		        	System.out.println("SO");
		        	if (initialTx - 1 > 0 && initialTy + 1 < 9) {
			        	initialTx--;
			        	initialTy++;
		        	}
		        	//System.out.println( initialTx + initialTy ); //test
		        	break;
		        case "2":
			        System.out.println("S");
			        // empecher la sortie de Tom de la carte et/ou d'aller sur la bordure
			        if ( initialTy+1 < 9) {
			        	initialTy++;
			        }		        
			        //System.out.println(initialTy); //test
			        break;
		        case "3":
		        	System.out.println("SE");
		        	if (initialTx + 1 < 19 && initialTy + 1 < 9) {
			        	initialTx++;
			        	initialTy++;
		        	}
		        	//System.out.println( initialTx + initialTy ); //test
		        	break;
		        case "4":
			        System.out.println("O");
			        if (initialTx - 1 > 0 ) {
			        	initialTx--;
			        }
			        //System.out.println(initialTx); //test
			        break;
		        case "6":
			        System.out.println("E");
			        if (initialTx + 1 < 19) {
			        	initialTx++;
			        }
			        //System.out.println(initialTx); //test
			        break;
		        case "7":
		        	System.out.println("NO");
		        	if (initialTx - 1 > 0 && initialTy - 1 > 0) {
			        	initialTx--;
			        	initialTy--;
		        	}
			        //System.out.println(initialTx + initialTy ); //test
			        break;
		        case "8":
			        System.out.println("N");
			        if (initialTy - 1 > 0) {
			        	initialTy--;
			        }
			        //System.out.println(initialTy); //test
			        break;
		        case "9":
		        	System.out.println("NE");
		        	if (initialTx + 1 < 19 && initialTy - 1 > 0) {
			        	initialTx++;
			        	initialTy--;
		        	}
			        //System.out.println(initialTx + initialTy); //test
			        break;
		        default:
		        	System.out.println("Erreur mauvaise saisie.");
		    }
		        
		        
//		        System.out.print(" # Position de Jerry " + initialJx + " et ");
//				//test
//				System.out.println(initialJy);
				
		        //mise à jour de la carte
		        AfficherCarte(initialTx, initialTy, initialJx, initialJy);
		        
		        //contrôle des positions
		        endGame = Victoire(initialTx, initialTy, initialJx, initialJy);	        
		        
		        
		        //contrôle si le compteur n'est pas à 0
		        remainingTurns--;
		        if (remainingTurns == 0 && !endGame) {
		        	endGame = true ;
					System.out.println("                               ");
					System.out.println("                               ");
					System.out.println("*******************************");
					System.out.println("            Dommage            ");
					System.out.println("*******************************");
					System.out.println("                               ");
					System.out.println("    Jerry à échapper à Tom !   ");
					System.out.println("                               ");
					System.out.println("*******************************");
					System.out.println("                               ");
					System.out.println("                               ");
		        }
	    }
	        if (endGame && remainingTurns != -1) {
	        	stop = AffichageMenu();
	        	if (!stop) {
	        		endGame = false;
	        	}
	        }
	        
	} while(!stop);
    System.out.println("fin du jeu");
	}




	
	
	//*********************************************************************************
	//*********************************************************************************
	//******************************FONCTIONS******************************************
	//*********************************************************************************
	//*********************************************************************************

	private static boolean AffichageMenu() {
		//fonction menu choix switch() case
		do {
		Scanner scanMenu = new Scanner(System.in);
		System.out.println("              ");
		System.out.println("**************");
		System.out.println("*****Menu*****");
		System.out.println("**************");
		System.out.println("              ");
		System.out.println("  1 - Jouer   ");
		System.out.println("  2 - Quitter ");
		System.out.println("              ");
		System.out.println("**************");
		System.out.println("              ");
		choixmenu = scanMenu.next();
		} while ((!choixmenu.equalsIgnoreCase("1")) && (!choixmenu.equalsIgnoreCase("2")));
		
		if ( choixmenu.equalsIgnoreCase("2")) {
			endGame = true;
			stop = true;
		} else {
			endGame = false;
		}
		return endGame;
	}
		

	private static void menuNiveauCarte() {
		do {
		System.out.println("*******************************");
		System.out.println(" choisir le niveau de la carte ");
		System.out.println("*******************************");
		System.out.println("                               ");
		System.out.println("         1 - Facile            ");
		System.out.println("         2 - Moyen             ");
		System.out.println("                               ");
		System.out.println("*******************************");
		@SuppressWarnings("resource")
		Scanner scAxeX = new Scanner(System.in);
		choixAxe = scAxeX.next();
		} while ((!choixAxe.equalsIgnoreCase("1")) && (!choixAxe.equalsIgnoreCase("2")));
		if(choixAxe.equalsIgnoreCase("1")) {
			carteAxeX = 15;
			carteAxeY = 7;
			System.out.println(" Niveau facile choisi ");//Test
		} else if (choixAxe.equalsIgnoreCase("2")){
			carteAxeX = 20;
			carteAxeY = 10;
			System.out.println(" Niveau moyen choisi ");//Test
		}
	}
	
	
	// Afficher la carte et positionner Tom et Jerry
	public static void AfficherCarte(int tomX, int tomY, int jerryX, int jerryY) {
		//Création de la grille de jeu
				for(i=0 ; i<carteAxeY; i++) {
					for(j=0 ; j<carteAxeX ; j++) {
						if(tomX == j && tomY == i) {
							System.out.print(" T ");
						} else if (jerryX == j && jerryY == i) { 
							System.out.print(" J ");
						}
						
						// creation des bordure de la carte
						else if (j==0 || i ==0 || j==(carteAxeX - 1) || i==(carteAxeY-1)) {
							
							switch (j) {
							case 0:
								System.out.print(" #");
								break;
							case 14:
								if((carteAxeX-1) == 14) {
									System.out.print("#");
								}
									break;																
							case 19:
								System.out.print("#");
								break;							
							default:
								System.out.print("###");
								break;
							}										
						} else						
							{
								System.out.print("   ");
							}
					}
					System.out.println();
					}
	}
	
	//controle coordonnées Tom & Jerry pour une victoire
	public static boolean Victoire(int tomX, int tomY, int jerryX, int jerryY) {
		if (tomX == jerryX && tomY == jerryY) {
			System.out.println("                               ");
			System.out.println("                               ");
			System.out.println("*******************************");
			System.out.println("          Félicitation         ");
			System.out.println("*******************************");
			System.out.println("                               ");
			System.out.println("     Tom a ratrappé Jerry !    ");
			System.out.println("                               ");
			System.out.println("*******************************");
			System.out.println("                               ");
			System.out.println("                               ");
			victoire = true;
		} else {victoire = false ;}
		return victoire;
	}

}
