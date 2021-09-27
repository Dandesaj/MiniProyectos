package Logic;

import java.util.regex.Pattern;

public class Validador {
	//Constructor
	public Validador() {
		
	}
	
	//true si s = numero entre min y max
	public static boolean esNum(String s, int min, int max) {
		String numValido = "(["+min+"-"+max+"])";
		try {
			return Pattern.matches(numValido, s);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	
}
