package Gato;

import java.util.regex.Pattern;

public class GatoLogic {
	
	//   VARIABLES GLOBALES
	static char[] tablero = new char [9];
	int[][] lineas = new int [8][3];
	final static String coordenadasValidas = "([0-9]?)";
	String marcasDeJugador = "OX";
	char[] marcas = marcasDeJugador.toCharArray();
	
	//-------CONSTRUCTOR Y INICIALIZACION-------
	public GatoLogic() {
		initializaTablero();
		imprimirInstrucciones();
		imprimirMenu();		
	}
	
	//inicializa el tablero
	public void initializaTablero() {
		for (int i = 0; i<tablero.length;i++) {
			tablero[i]=' ';
		}
	}
		
	
	
	
	//-------LOGICA DE TURNOS-------
	
	public void turno(int p, String s, boolean pVp) {
		//coordenada ya sabemos que es valida y no se ha usado
		int coord = Integer.parseInt(s);
		tablero[coord-1] = marcas[p-1];
				
		if(!pVp) {
			turnoPC();
			//imprimirTablero();
		}
		imprimirTablero();
	}
	
	public void turnoPC() {
		int coord =(int) (Math.random()*9+1);
		while(coordenadaUsada(String.valueOf(coord))) {
			coord =(int) (Math.random()*9+1);
		}
		tablero[coord-1] = marcas[2-1];
	}
	
	
	//revisa las condiciones para seguir el juego
	public boolean continuar() {
		boolean flag = false; 
		for (int i=0;i<tablero.length;i++) {
			if(tablero[i]==' ') {
				flag = true;
			}			
		}
		if (!flag) {
			System.out.println("Se termino");
		}
		return flag;
	}
	
	//revisa si alguien ha ganado
	public boolean hayGanador(int p, boolean pVp) {
		String linea="";
		boolean flag = false;
        for (int i=0; i<8;i++) {
        	switch(i) {
            case 0:
                linea=tablero[0]+""+tablero[1]+""+tablero[2];
                break;
            case 1:
            	linea=tablero[3]+""+tablero[4]+""+tablero[5];
                break;
            case 2:
            	linea=tablero[6]+""+tablero[7]+""+tablero[8];
                break;
            case 3:
            	linea=tablero[0]+""+tablero[3]+""+tablero[6];
                break;
            case 4:
            	linea=tablero[1]+""+tablero[4]+""+tablero[7];
                break;
            case 5:
            	linea=tablero[2]+""+tablero[5]+""+tablero[8];
                break;
            case 6:
            	linea=tablero[0]+""+tablero[4]+""+tablero[8];
                break;
            case 7:
            	linea=tablero[2]+""+tablero[4]+""+tablero[6];
                break;
            }
            
            if (pVp) {
            	if(linea.equals("XXX")||linea.equals("OOO")){
            		System.out.println("Gano Jugador " + 1 );
            		flag=true;
            	}
            }else {
            	if(linea.equals("OOO")){
            		System.out.println("Ganaste!!");
            		flag=true;
            	}else if(linea.equals("XXX")) {
            		System.out.println("Perdiste!!");
            		flag=true;
            	}
        	}  	 
        }
        if(flag==false) {
        	System.out.println("aun nadie");
        	flag = !continuar();
        }
        return flag;
        
	}
	
	
	
	
	//-------CONSOLA------- 
	
	//imprime el tablero a la consola
	public void imprimirTablero() {
		System.out.println("***********************");
		System.out.println("       Tablero");
		System.out.println("***********************");
		
		for (int i = 0; i<3;i++) {
			System.out.print("\n       |");
			
			for (int j=0; j<3; j++) {
				//System.out.print(tablero[i][j]+"|");
				System.out.print(tablero[(j+i*3)]+"|");
			}
			
		}
		System.out.println("\n\n***********************\n");
	}
	
	//imprime el mapa de coordenadas restantes
	public void imprimirCoordenadas() {
		System.out.println("***********************");
		System.out.println("      Coordenadas");
		System.out.println("***********************");
		
		for (int i = 0; i<3;i++) {
			System.out.print("\n       |");
			for (int j=1; j<4; j++) {
				System.out.print((j+i*3)+"|");
			}
		}
		System.out.println("\n\n***********************\n");
	}
	
	//imprime instrucciones
	public void imprimirInstrucciones() {
		System.out.println("\n\n***********************");
		System.out.println("Bienvenidos a Gato");
		System.out.println("***********************");
		System.out.println("Jugadores toman turno elijiendo coordenadas"
					+" donde colacan sus fichas.\n"
					+"O para jugador 1, X para jugador 2. \nAquel que logre 3 en linea gana!");
		System.out.println("***********************");
	}
	
	//imprime menu
	public void imprimirMenu() {
		System.out.println("   Menu de juego   ");		
		System.out.println("1.- PvP");
		System.out.println("2.- PvC");
		System.out.println("3.- mostrar instrucciones");
		System.out.println("0.- Salir");
	}
	
	//-------VALIDACIONES-------
	
	//valida logica de las coordenas ingresadas
	public static boolean Valido(String s) {
			if (!Length(s)) {
				 System.out.println("largo de la coordenada es invalida");
				 return false;
			 }else if(!coordenadaValida(s)) {
				 System.out.println("caracter invalido");
				 return false;
			 }else if(coordenadaUsada(s)) {
				 System.out.println("Posicion ya tomada");			   
				 return false;
			 }else {
				 return true;
			 }
		 }
		 
	//que la coordenada sea int 1-9
	public static boolean coordenadaValida(String s) {
		 try {
			return Pattern.matches(coordenadasValidas, s);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
		
	//revisa que la coordenada este vacia
	public static boolean coordenadaUsada(String s) {
	   int coord = Integer.parseInt(s);
	   if(tablero[coord-1] =='X'||tablero[coord-1]=='O') {
		   return true;
	   }		  
	   return false; 
	}
	
	//valida el largo de la coordenada
	public static boolean Length(String s) {
			if(s.length()==1) {
				return true;
			}else {
				return false;
			}
		}


}
