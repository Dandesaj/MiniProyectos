package BlackJack;

public class JuegaBlackJack {
	
	public void run() {
		imprimirMenu();
		
		
		printSpade((int)Math.random());
		printDiamond((int)Math.random());
		printClub((int)Math.random());
		printHeart((int)Math.random());
	}
	
	public void imprimirMenu() {
		System.out.println("\n•••••••••••••••••••••••••••");		
		System.out.println(" -Bienvenido a Blackjack-  ");
		System.out.println("•••••••••••••••••••••••••••");
		
		
		
	}
	
	public void printSpade(int value) {
	
		System.out.println(" _____");
		System.out.println("|"+value+" .  |");
		System.out.println("| /.\\ |");
		System.out.println("|(_._)|");
		System.out.println("|  |  |");
		System.out.println("|____"+value+"|");
	}
	
	public void printDiamond(int value) {
		
		System.out.println(" _____");
		System.out.println("|"+value+" ^  |");
		System.out.println("| / \\ |");
		System.out.println("| \\ / |");
		System.out.println("|  .  |");
		System.out.println("|____"+value+"|");
	}
	
	public void printClub(int value) {
		
		System.out.println(" _____");
		System.out.println("|"+value+" _  |");
		System.out.println("| ( ) |");
		System.out.println("|(_'_)|");
		System.out.println("|  |  |");
		System.out.println("|____"+value+"|");
	}

	public void printHeart(int value) {		
		System.out.println(" _____");
		System.out.println("|"+value+"_ _ |");
		System.out.println("|( v )|");
		System.out.println("| \\ / |");
		System.out.println("|  .  |");
		System.out.println("|____"+value+"|");	
	}
}