package Colgado;

import java.util.regex.Pattern;

public class ColgadoLogic {
 String palabra;
static String adivino;
 final static String caracteresValidos = "([0-9a-zA-Zñ]*)";
 char[] p,a;
 final static int turnos = 4;
 int turno = 1;
 String p1,p2;
 
 	//COSTRUCTOR	(palabra y nombre de jugadores)
	public ColgadoLogic (String s, String p1, String p2) {
		this.palabra = s;
		this.p1 = p1;
		this.p2 = p2;
		this.p = palabra.toCharArray();
		this.a = new char[p.length];
		iniciaAdivina();
	}
	
	//METODO LLAMADO DESDE FUERA CON CADA ADIVINO
	public void Adivina(String s) {
		
		this.adivino = s;
		if (Validar()) {
			//System.out.println("\n en juego \n ");
			char caracter = adivino.charAt(0);
			coincide(caracter);
		}
		
	}
	
	//BUSCA SI HAY COINCIDENCIA DEL CARACTER EN LA PALABRA
	public void coincide(char caracter) {
		for(char c : this.a) {
			if(c == caracter) {
				System.out.println("Ya adivinaste eso");
				break;
			}
		}
		
		if(palabra.indexOf(caracter)==-1) {
			this.turno++;
			System.out.println("Incorrecto, intentos restates: "+ (turnos-turno));		
		}else {
			for(int i = 0;i<p.length;i++) {
				if(p[i]==caracter) {
					a[i]=caracter;
				}
			}
		}
	}
	
	//IMPRIME LO ADIVINADO A CONSOLA
	public void imprime() {
		for(int i =0; i<p.length;i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
	//INICIALIZA ADIVINADO CON '_' 
	public void iniciaAdivina() {
		for(int i = 0;i<a.length;i++) {
			a[i]='_';
		}
	}
		
	//REVISA SI HAY TURNOS RESTANTES PARA ADIVINAR
	public boolean continua() {
		if(this.turno<turnos) {
			return true;
		}else {
			System.out.println(p2+" se te acabaron los intentos! PERDISTE \n"+
							"la palabra era: "+palabra +
							"\nGANA "+	p1);			
			return false;			
		}
	}
	
	//COMPILA LA VALIDACION DEL LARGO Y CARACTERS VALIDOS
		public boolean Validar() {
			if(Largo()&&letraNum()) {
				return true;
			}
			return false;
		}
	
	//VALIDA EL LARGO DEL ADIVINO
	public boolean Largo() {
		int length = adivino.length();
		if (length==1) {
			return true;
		}else {
			System.out.println("largo invalido");
			return false;
		}
	}
	
	//VALIDA LOS CARACTERES DEL ADIVINO
	public static boolean letraNum() {
		 try {
			boolean v = Pattern.matches(caracteresValidos, adivino);
			if (v) {
				return true;
			}else {
				return false;
			}
		 } catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//REVISA SI EL JUGADOR GANO
	public boolean ganar() {
		int falta = 0;
		for(char c : this.a) {
			if(c =='_') {
				//queda por adivinar
				falta++;
			}
		}
		
		if (falta==0) {
			System.out.println("\n"+p2+" GANA!!!! \n  LO SIENTO "+
						p1 +", MEJOR SUERTE PARA LA PROXIMA");
			turno=this.turnos;
			return true;
		}else {
			//imprime();
			return false;			
		}
		
		
	}
}
