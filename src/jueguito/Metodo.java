package jueguito;

public class Metodo {
	
	private static final int EXPERTO = 10;
	private static final int MEDIO = 20;
	private static final int NOVATO = 30;
	
	public static boolean validarNumero (String numero) {
		boolean respuesta = false;
		
		if(validarEntre0Y9(numero) && validarCantCifras(numero)) {
			int cifra1 = numero.charAt(0);
			int cifra2 = numero.charAt(1);
			int cifra3 = numero.charAt(2);
			int cifra4 = numero.charAt(3);
			
			if (cifra1 != cifra2 && cifra1 != cifra3 && cifra1 != cifra4 && cifra2 != cifra3 && cifra2 != cifra4 && cifra3 != cifra4) {
				respuesta = true;
			}
		}
		return respuesta;
	}
	
	public static boolean validarEntre0Y9 (String numero) {
		boolean respuesta = false;
		if (numero.charAt(0) == '0' || numero.charAt(0) == '1' || numero.charAt(0) == '2' || numero.charAt(0) == '3' || numero.charAt(0) == '4' || numero.charAt(0) == '5' || numero.charAt(0) == '6' ||numero.charAt(0) == '7' ||numero.charAt(0) == '8' ||numero.charAt(0) == '9') {
			if(numero.charAt(1) == '0' || numero.charAt(1) == '1' || numero.charAt(1) == '2' || numero.charAt(1) == '3' || numero.charAt(1) == '4' || numero.charAt(1) == '5' || numero.charAt(1) == '6' ||numero.charAt(1) == '7' ||numero.charAt(1) == '8' ||numero.charAt(1) == '9') {
				if(numero.charAt(2) == '0' || numero.charAt(2) == '1' || numero.charAt(2) == '2' || numero.charAt(2) == '3' || numero.charAt(2) == '4' || numero.charAt(2) == '5' || numero.charAt(2) == '6' ||numero.charAt(2) == '7' ||numero.charAt(2) == '8' ||numero.charAt(2) == '9') {
					if(numero.charAt(3) == '0' || numero.charAt(3) == '1' || numero.charAt(3) == '2' || numero.charAt(3) == '3' || numero.charAt(3) == '4' || numero.charAt(3) == '5' || numero.charAt(3) == '6' ||numero.charAt(3) == '7' ||numero.charAt(3) == '8' ||numero.charAt(3) == '9') {
						respuesta = true;
					}
				}
			}
		}
		
		return respuesta;
	}
	
	public static boolean validarCantCifras (String numero) {
		boolean respuesta = false;
		if (numero.length()==4) {
			respuesta = true;
		}
		return respuesta;
	}
	
	public static boolean validarNivel (String nivel) {
		boolean respuesta = false;
		if (nivel.equals("EXPERTO") || nivel.equals("MEDIO") || nivel.equals("NOVATO")){
			respuesta = true;
		}
		return respuesta;
	}
	
	public static int asignarChances (String nivel) {
		int respuesta = NOVATO;
		if (nivel.equals("EXPERTO")) {
			respuesta = EXPERTO;
		}else if (nivel.equals("MEDIO")){
			respuesta = MEDIO;
		}
		return respuesta;
	}
	
	public static boolean adivino (int cifra1, int cifra2, int cifra3, int cifra4, int cifra1Adivinada, int cifra2Adivinada, int cifra3Adivinada, int cifra4Adivinada) {
		boolean respuesta = false;
		int contPosicion = 0;
		int contNumero = 0;
		
		if(cifra1 == cifra1Adivinada) {
			contPosicion++;
		}else if (cifra1Adivinada == cifra2 || cifra1Adivinada == cifra3 || cifra1Adivinada == cifra4) {
			contNumero++;
		}
		if(cifra2 == cifra2Adivinada) {
			contPosicion++;
		}else if (cifra2Adivinada == cifra1 || cifra2Adivinada == cifra3 || cifra2Adivinada == cifra4) {
			contNumero++;
		}
		if(cifra3 == cifra3Adivinada) {
			contPosicion++;
		}else if (cifra3Adivinada == cifra1 || cifra3Adivinada == cifra2 || cifra3Adivinada == cifra4) {
			contNumero++;
		}
		if(cifra4 == cifra4Adivinada) {
			contPosicion++;
		}else if (cifra4Adivinada == cifra1 || cifra4Adivinada == cifra2 || cifra4Adivinada == cifra3) {
			contNumero++;
		}
		
		if(contPosicion == 4) {
			respuesta = true;
		}
		imprimirResultado (contNumero, contPosicion);
		return respuesta;
	}
	
	public static void imprimirResultado (int contNumero, int contPosicion) {
		System.out.println("Acertaste "+contNumero+ " numeros, pero no en la posicion correcta.");
		System.out.println("Acertaste "+contPosicion+ " numeros en la posicion correcta.");
	}

}
