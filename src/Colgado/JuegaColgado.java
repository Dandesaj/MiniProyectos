package Colgado;

import java.util.Scanner;
import java.util.regex.Pattern;

public class JuegaColgado {
	final static String caracteresValidos = "([0-9a-zA-Zñ]*)";
 public static void run() {
	 
	 Scanner sc = new Scanner(System.in);
	 
	 System.out.println("Jugador 1, como te llamas?");
	 String p1 = sc.nextLine();
	 System.out.println("Jugador 2, como te llamas?");
	 String p2 = sc.nextLine();
	 
	 String sigueJugando = "si";
	 
	 while(sigueJugando.equals("si")){ 
		 System.out.println(p1+", ingrese palabra a adivinar");
		 String palabra = sc.nextLine();
		 
		 try {
			while(!Valido(palabra)) {
				 System.out.println("Intente Denuevo");
				 palabra = sc.nextLine();
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		ColgadoLogic juego1 = new ColgadoLogic(palabra,p1,p2);
		
		String adivino;
		juego1.imprime();
		while(juego1.continua()) {
			System.out.println(p2+", ingresa caracter");
			adivino = sc.nextLine();
			juego1.Adivina(adivino);
			if(juego1.ganar()) {
				break;
			}else {
				juego1.imprime();
			}
		}
		System.out.println("Desean jugar denuevo?? ingrese \"si\"");		
		sigueJugando = sc.nextLine();
	}	
 }
 
 
 public static boolean Valido(String s) {
	 if (!Length(s)) {
		 return false;
	 }else if(!letraNum(s)) {
		 System.out.println("caracter invalido");
		 return false;
	 }else {
		 return true;
	 }
 }
 
 public static boolean Length(String s) {
		int length = s.length();
		if (length >= 3 && length<10) {
			return true;
		}else {
			System.out.println("largo invalido");
			return false;
		}
	}

 
 public static boolean letraNum(String s) {
	 try {
		return Pattern.matches(caracteresValidos, s);
	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}
}
 
 
}
