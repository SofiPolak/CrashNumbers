package jueguito;

import java.util.Scanner;

public class CrashNumber {
	
	private static Scanner input = new Scanner (System.in);

	public static void main(String[] args) {
		
		System.out.println("Bienvenido a Crash Numbers!!");
		
		System.out.println("Elegi tu nivel: NOVATO, MEDIO o EXPERTO.");
		String nivel = input.nextLine();
		boolean estaOk = Metodo.validarNivel(nivel);
		
		while (!estaOk) {
			System.out.println("Recorda que debes elegir tu nivel entre: NOVATO, MEDIO o EXPERTO.");
			nivel = input.nextLine();
			estaOk = Metodo.validarNivel(nivel);
		}
		
		int chances = Metodo.asignarChances(nivel);
		
		System.out.println("Genial! Tenes "+ chances + " chances para adivinar el numero.");
		
		System.out.println("Ingrese un numero de 4 cifras (no podes repetir las cifras).");
		String numero = input.nextLine();
		boolean valido = Metodo.validarNumero(numero);
		
		while (!valido) {
			System.out.println("Recorda que debes ingresar un numero de 4 cifras y estas no se pueden repetir.");
			numero = input.nextLine();
			valido = Metodo.validarNumero(numero);
		}
		
		System.out.println("Vamos a jugar!!");
		
		int cifra1 = Character.getNumericValue(numero.charAt(0));
		int cifra2 = Character.getNumericValue(numero.charAt(1));
		int cifra3 = Character.getNumericValue(numero.charAt(2));
		int cifra4 = Character.getNumericValue(numero.charAt(3));
		
		int cont = 0;
		
		boolean intento = false;
		
		do {
			cont++;
			System.out.println("Esta es tu chances numero: "+cont);
			System.out.println("Intenta adivinar el numero de 4 cifras (no podes repetir las cifras)");
			String numeroAdivinado = input.nextLine();
			valido = Metodo.validarNumero(numeroAdivinado);
			
			while(!valido) {
				System.out.println("Recorda que debes ingresar un numero de 4 cifras y estas no se pueden repetir.");
				numeroAdivinado = input.nextLine();
				valido = Metodo.validarNumero(numeroAdivinado);
			}
			
			int cifra1Adivinada = Character.getNumericValue(numeroAdivinado.charAt(0));
			int cifra2Adivinada = Character.getNumericValue(numeroAdivinado.charAt(1));
			int cifra3Adivinada = Character.getNumericValue(numeroAdivinado.charAt(2));
			int cifra4Adivinada = Character.getNumericValue(numeroAdivinado.charAt(3));
			
			intento = Metodo.adivino(cifra1, cifra2, cifra3, cifra4, cifra1Adivinada, cifra2Adivinada, cifra3Adivinada, cifra4Adivinada);
			
		}while (cont<chances && !intento);
		
		if(cont == chances) {
			System.out.println("Perdiste!! Te quedaste sin chances para adivinar.");
		}else if (intento) {
			System.out.println("Ganaste!! Adivinaste el numero.");
		}
		
		input.close();

	}

}
