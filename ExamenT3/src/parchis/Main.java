package parchis;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// guarda el nombre del jugador 1 que se introduce por consola
		String nomJ1;
		// guarda el nombre del jugador 2 que se introduce por consola
		String nomJ2;
		// guarda el ganador
		String ganador;
		// recoge la posiión de la ficha del J1
		int fichaJ1;
		// recoge la posicion de la ficha del J2
		int fichaJ2;
		// guarda el numero del dado 1
		int dado1 = 0;
		// guarda el numero del dado 2
		int dado2 = 0;
		// guarda el turno actual
		int turno = 1;
		// llama a la funcion parchis
		Parchis parchis;
		parchis = new Parchis();

		// recoge la posición de las fichas
		fichaJ1 = parchis.fichaJ1;
		fichaJ2 = parchis.fichaJ2;

		// Pide el nombre de J1
		System.out.println("Introduce el nombre del J1: ");
		nomJ1 = sc.nextLine();
		// Bucle para pedir el nombre a J2 para que no sea igual que J1, si son iguales
		// sigue preguntando
		do {
			System.out.println("Introduce el nombre del J2: ");
			nomJ2 = sc.nextLine();
		} while (nomJ1 == nomJ2);

		// recoge en ganador quien deberia de ganar, como es el principio deberia estar
		// vacio "".
		ganador = parchis.esGanador(fichaJ1, fichaJ2);
		// hace un bucle hasta que haya un ganador, es decir hasta que la variable
		// agnador sea distinta de la cadena vacia ""
		do {
			System.out.println("¿Continuar?");
			sc.nextLine();
			// se tiran los dados llamando a la función tira dados, que genera dos númros
			// aleatorios del 1 al 6, los cuales moverán al jugador
			Parchis.tiraDados();
			dado1 = Parchis.dado1;
			dado2 = Parchis.dado2;
			System.out.println("La tirada es de: " + dado1 + " y " + dado2 + "\n");
			// llamamos a avanzaPosiciones para calculaer e imprimir cuanto debe avanzar el
			// jugador con el turno correspondiente
			parchis.avanzaPosiciones(turno);
			System.out.println();
			if (turno == 1) {
				System.out.println("Turno de: " + nomJ1);
			} else {
				System.out.println("Turno de: " + nomJ2);
			}
			System.out.println("");
			// tablero con el jugador movido
			parchis.pintaTablero(nomJ1, nomJ2);
			System.out.println("");
			// si los dados son iguales tira otra vez y se mueve sino cambia turno
			while (dado1 == dado2) {
				Parchis.tiraDados();
				dado1 = Parchis.dado1;
				dado2 = Parchis.dado2;
				System.out.println("La tirada es de: " + dado1 + " y " + dado2 + "\n");
				// tablero con el jugador movido
				parchis.pintaTablero(nomJ1, nomJ2);
				System.out.println("");
				System.out.println("¿Continuar?");
				sc.nextLine();
				// if que cambia de turno, si es turno de j1 suma 1 para indicar que ahora es
				// turno de J2 y cuando termina el turno de J2 resta 1 para indicar que es turno
				// de J1
			} // fin while
			if (turno == 1) {
				turno++;
			} else {
				turno--;
			} // fin if
			ganador = parchis.esGanador(fichaJ1, fichaJ2);
		} while (ganador.equals(""));

		// Cuando sale del bucle quiere decir que tenemos ganador, por lo que lo
		// imprimimos

		System.out.println("ENHORABUENA " + ganador + "HAS GANADO!!");

		
		sc.close();
	}
	

}