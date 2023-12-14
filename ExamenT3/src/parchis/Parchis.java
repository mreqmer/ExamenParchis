package parchis;

import java.util.Random;

public class Parchis {

	// constante que determina el tamaño del tablero
	static final int TAM_TABLERO =20;
	// variable que guarda la posición actual del jugador 1 en el momento actual,
	// empieza en la casilla 0
	int fichaJ1 = 0;
	// variable que guarda la posición actual del jugador 2 en el momento actual,
	// empieza en la casilla 0
	int fichaJ2 = 0;

	static int dado1;
	static int dado2;

	String nomJ1;
	String nomJ2;

	public Parchis() {
	}

	public Parchis(String nomJ1, String nomJ2) {
		this.nomJ1 = nomJ1;
		this.nomJ2 = nomJ2;
	}

	static void tiraDados() {
		Random rand = new Random();
		dado1 = rand.nextInt(1, 7);
		dado2 = rand.nextInt(1, 7);
	}

	// ENTRADA: -
	// SALIDA: -
	// esta será la función de pintar el tablero de juego
	void pintaTablero(String nomJ1, String nomJ2) {
		// primero usamos un bucle que pinta la parte superior del tablero, la cual en
		// la posición 0 imprime una I de inicio y el posición que corresponde al final
		// del tablero imprime una F de final
		for (int i = 0; i <= TAM_TABLERO; i++) {
			if (i == 0) {
				System.out.print("\t" + "I");
			} else if (i == TAM_TABLERO) {
				System.out.println("\t" + "F");
			} else {
				System.out.print("\t" + i);
			} // fin de if else
		} // fin de bucle

		// este bucle pinta el nombre del jugador1 y la casilla en la que se encuentra,
		// señalandolo con un O para representar su ficha
		System.out.print(nomJ1 + " \tI");
		for (int i = 1; i <= TAM_TABLERO; i++) {
			System.out.print("\t");
			if (i == fichaJ1) {
				System.out.print("O");
			} else if (i == TAM_TABLERO) {
				System.out.println("F");
			} // FIN else if
		} // fin bucle

		// este bucle pinta el nombre del jugador2 y la casilla en la que se encuentra,
		// señalandolo con un O para representar su ficha
		System.out.print(nomJ2 + " \tI");
		for (int i = 1; i <= TAM_TABLERO; i++) {
			System.out.print("\t");
			if (i == fichaJ2) {
				System.out.print("O");
			} else if (i == TAM_TABLERO) {
				System.out.println("F");
			} // FIN else if
		} // fin bucle

	}

	// ENTRADA: turno, si es 1 modifica a J1 y si es 2 modifica a J2
	// SALIDA: -
	// modifica la variable fichaJ1 o fichaJ2, dependiendo de la entrada que indica
	// el turno del jugador, con la suma de los dos dados que se tiran en cada turno
	void avanzaPosiciones(int turno) {
		// guarda la suma de los dados para ver cuantas casillas ha de moverse, si
		// sobrepasa el tamaño del tablero entonces la ficha vuelve hacia atrás, por lo
		// que para ganar tiene que estar en la misma pos que el tamaó del tablero
		int movimiento;
		movimiento = dado1 + dado2;
		// si turno es 1 modifica a j1, si no modifica a j2

		switch (turno) {
		case 1 -> {
			fichaJ1 = fichaJ1 + movimiento;
			if (fichaJ1 > TAM_TABLERO) {
				fichaJ1 = TAM_TABLERO -(fichaJ1 - TAM_TABLERO);
			} // fin if
		}
		case 2 -> {
			fichaJ2 = fichaJ2 + movimiento;
			if (fichaJ2 > TAM_TABLERO) {
				fichaJ2 = fichaJ2 - (TAM_TABLERO - movimiento);
			} // fin if
		}
		}// fin switch

	}

	// ENTRADA: fichaJ1, fichaJ2
	// SALIDA: "Va ganando NombreDelJugador"
	// comprueba la ficha que va ganando en el momento y lo devuelve por pantalla
	String estadoCarrera(int fichaJ1, int fichaJ2) {

		return (fichaJ1 > fichaJ2) ? "Va ganando" + nomJ1 : "Va ganando" + nomJ2;
	}

	// ENTRADA:fichaJ1, fichaJ2
	// SALIDA:String con el nombre del jugador ganador o ""
	// comprueba si algún jugador ha llegado a la posición TAM_TABLERO, en caso de
	// que ninguno lo haya hecho guarda "", si llega alguno guarda el nombre del
	// jugador ganador
	String esGanador(int fichaJ1, int fichaj2) {
		//guarda la cadena con el nombre del jugador que gana o "" si no ha ganado nadie todavia
		String ganador;
		if (fichaJ1 == TAM_TABLERO) {
			ganador = nomJ1;
		} else if (fichaJ2 == TAM_TABLERO) {
			ganador = nomJ2;
		} else {
			ganador = "";
		}
		return ganador;
	}

	
}
