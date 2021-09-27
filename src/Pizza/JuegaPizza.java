package Pizza;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

//pizza base de 5 ingredientes 
//usuario puede cambiar, quitar o añadir ingredientes ( sin repetir) 	


public class JuegaPizza {

	ArrayList<String> ingredientes = new ArrayList<String>(Arrays.asList(
			"Tomate", //0
			"Queso", //1
			"Peperoni", //2
			"Oregano",  //3
			"Mozarella",  //4
			"Piña",  //5
			"Choricillo",  //6
			"Pollo",  //7
			"Jamon", //8
			"Carne", //9
			"Doble Queso" //10
			));
	
	ArrayList<String> pizza = new ArrayList<String>();
	
	ArrayList<String> hawaiana = new ArrayList<String>(Arrays.asList(
			"Jamon",
			"Piña",
			"Tomate",
			"Queso"
			));
	
	//INICIALIZADOR
	public JuegaPizza(){
		int r;
		String ing;

		for(int i=1;i<=5;i++) {
			r=(int) ((Math.random()*ingredientes.size()));		
			
			ing = ingredientes.get(r);
			if (!pizza.contains(ing)) {
				//System.out.println("rand: " + r);
				this.pizza.add(ing);
			}else {
				i--;
			}
		}
		//Collections.sort(pizza);
	}
	
	// PSEUDO MAIN
	public void run() {
		System.out.println("\n\n\n**************************");
		System.out.println("Bienvenidos a PAPA RORRI'S");
		System.out.println("**************************");
		
		Scanner sc = new Scanner(System.in);
		String p = "1";
		
		while(!p.equals("0") ){
			System.out.println("Su pizza es:");			
			System.out.println(pizza);
			System.out.println("\n\n**************************");
			System.out.println("       Menu de Pedido     ");
			System.out.println("**************************");
			System.out.println("1.- Agregar Ingrediente");	
			System.out.println("2.- Eliminar Ingrediente");	
			System.out.println("3.- Modificar Ingrediente");
			System.out.println("0.- Confirmar Pedido");
			
			p = sc.nextLine();
			
			
			switch(p) {
			case "1":
				agregarIngrediente();
				//System.out.println(pizza);				
				break;				
			case "2":
				eliminarIngrediente();
				//System.out.println(pizza);
				break;
			case "3":
				modificarIngrediente();
				break;
			case "0":
				revisarPizza();				
				System.out.println("Vuelva Pronto");
				break;	
			default:
				System.out.println("Opcion no valida");
				
			}
		}
		
	}
	
	public void revisarPizza() {
		Collections.sort(pizza);
		Collections.sort(hawaiana);
		
		if(pizza.equals(hawaiana)) {
			System.out.println("Armaste una Hawaiana, Aloha!");
		}
		
	
	}
	
	public void agregarIngrediente() {
		Scanner sc = new Scanner(System.in);
		String ing;
		boolean flag = true;
		
		while(flag) {
			System.out.println("Que ingrediente desea agregar?");
			System.out.println(ingredientes);
			
			ing = sc.nextLine();		
			if(ingredientes.contains(ing)) {
				if (!pizza.contains(ing)) {
					pizza.add(ing);
					flag=false;
				}else {
					System.out.println("Ya tienes ese ingrediente agregado");
				}
			}else {
				System.out.println("Ingrediente Invalido");
			}		
		}
	
	}
	
	public void eliminarIngrediente() {
		Scanner sc = new Scanner(System.in);
		String ing;
		boolean flag = true;
		
		while(flag) {
			System.out.println("Que ingrediente desea eliminar?");
			System.out.println(pizza);
			
			ing = sc.nextLine();		
			if(pizza.contains(ing)) {
				flag=false;
				System.out.println(ing + " se quito de la pizza");
				pizza.remove(pizza.indexOf(ing));
			}else {
				System.out.println("Ingrediente Invalido");
			}		
		}	
	}
	
	public void modificarIngrediente() {
		Scanner sc = new Scanner(System.in);
		String ing = "";
		String ing2;
		boolean flag = true;
		boolean valid = false;
		while(flag){
			
			if(!valid) {
				System.out.println("Que ingrediente desea modificar?");
				System.out.println(pizza);
				ing = sc.nextLine();
			}else {
				System.out.println("Ingrediente Invalido");				
			}				
			
			if(pizza.contains(ing)) {
				valid=true;
				System.out.println("\nCon que desea remplazar "+ing);
				ArrayList<String> ingredientesDisponibles = new ArrayList<String>(ingredientes);
				ingredientesDisponibles.removeAll(pizza);
				System.out.println(ingredientesDisponibles);
				ing2 = sc.nextLine();
				if(ingredientesDisponibles.contains(ing2)) {
					Collections.replaceAll(pizza, ing, ing2);
					System.out.println(ing + " se reemplazó con "+ing2);
					flag=false;
				}else if(pizza.contains(ing2)){
					System.out.println("ya tienes ese ingrediente");
				}else {
					System.out.println("Ingrediente Invalido");
				}					
				
			}	
		}	
	}
	
	
	
}
