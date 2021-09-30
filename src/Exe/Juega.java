package Exe;

import java.util.Scanner;
import java.util.regex.Pattern;

//importar packetes de juego
import Gato.JuegaGato;
import Colgado.JuegaColgado;
import Pizza.JuegaPizza;
import BlackJack.JuegaBlackJack;

public class Juega {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		String menu = "1";
		
		while(!menu.equals("0")) {
			
			printMenu();
			menu = sc.nextLine();
			//menu="5";
			
			//String elije = "2";
			
			switch(menu) {
			case "0": 
				System.out.println("Adios ");
				break;
				
			case "1": 
				JuegaColgado j1 = new JuegaColgado();
				j1.run();
				break;
				
			case "2":
				JuegaGato j2 = new JuegaGato();
				j2.run();
				break;
				
			case "3":
				JuegaBlackJack j3 = new JuegaBlackJack();
				j3.run();
			break;
			
			case "4":
				System.out.println("nica...");
				break;
				
			case "5":
				JuegaPizza j5 = new JuegaPizza();
				j5.run();
				break;
				
			default: 
				System.out.println("opcion no valida");
			}			
		}		
	}
	
	
	
	//imprime menu a la consola
	public static void printMenu() {
		System.out.println("Elije un juego");		
		System.out.println("1.- Colgado");
		System.out.println("2.- Gato");
		System.out.println("3.- Blackjack");
		System.out.println("4.- Duke Nukem");
		System.out.println("5.- Pizza");
		
		System.out.println("0.- Salir");
	}
	
}
