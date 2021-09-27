package Gato;

import java.util.Scanner;
import Logic.Validador;

public class JuegaGato {
	
	
	public static void run() {
		
		GatoLogic juego = new GatoLogic();
		Scanner sc = new Scanner(System.in);
		String coord;
		
		//Seleccione modo de juego		
		int players;
		
		System.out.println("Ingrese numero de jugadores");
		String p = sc.nextLine();
		
		while(!p.equals("1") && !p.equals("2")){
			System.out.println("Ingrese numero valido (1 o 2) ");
			System.out.println("p: "+ p);
			p = sc.nextLine();
		}
		
		players = Integer.parseInt(p);
		boolean pVp;
		if (players==2) {
			pVp = true;
		}else {
			pVp=false;
		}
				
		boolean play = juego.continuar();
		
		while(play) {
			for(int i = 1;i<players+1;i++) {
				System.out.println("turno de: jugador "+i );
				coord=sc.nextLine();
				while(!juego.Valido(coord)){
					coord=sc.nextLine();
				}
				juego.turno(i, coord,pVp);
								
				if(juego.hayGanador(players,pVp)) {
					play=false;
					break;
				}					
			}
		}
	}

}
