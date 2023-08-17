package tp5EJ4;

import java.util.ArrayList;

public class CircuitoATP {
	private String[] jugadores;
	private String[] torneos;
	private int[][] resultados;

	public CircuitoATP() {
		this.cargarData();
	}

	public void cargarData() {
		this.jugadores = new String[] { "Pella", "Del Potro", "Schwartzman", "Mayer", "Delbonis" };
		this.torneos = new String[] { "Australia", "USOpen", "RolandGarros", "Wimbledon", "Shangai" };
		this.resultados = new int[][] { { 1, 3, 4, 1, 3 }, { 3, 2, 3, 4, 1 }, { 2, 1, 5, 5, 2 }, { 4, 5, 1, 2, 5 },
				{ 5, 4, 2, 3, 4 } };

	}

	public ArrayList<Jugador> procesarInfo() {
		ArrayList<Jugador> jugadors = new ArrayList<>();
		Jugador jAux;
		for (int i = 0; i < jugadores.length; i++) {
			jAux = new Jugador(jugadores[i]);
			jugadors.add(jAux);
			for (int j = 0; j < torneos.length; j++) {
				jAux.procesarResultado(resultados[i][j]);
			}
		}
		this.imprimirResultadoFinal(jugadors);
		return jugadors;
	}

	public String procesarTorneosJugador(String Jugador) {
		String competencias = "";
		competencias += jugadores[buscoJugador(Jugador)];
		for (int i = 0; i < torneos.length; i++) {
			competencias += " " + torneos[i] + " : " + resultados[buscoJugador(Jugador)][i];
		}
		return competencias;
	}

	public String obtenerResultadoJugador(String jugador, String torneo) {
		int posJ = buscoJugador(jugador);
		int posT = buscoTorneo(torneo);
		String devolver = null;
		if (posJ != -1 && posT != -1) {
			devolver = "Resultado de: " + jugador + " en:  " + torneo + " : " + resultados[posJ][posT];
		}
		return devolver;
	}

	private int buscoJugador(String Jugador) {
		int posJugador = -1;
		int i = 0;
		while (i < jugadores.length && posJugador == -1) {
			if (jugadores[i].equals(Jugador)) {
				posJugador = i;
			} else {
				i++;
			}
		}
		return posJugador;
	}

	private int buscoTorneo(String torneo) {
		int posTorneo = -1;
		int i = 0;
		while (i < torneos.length && posTorneo == -1) {
			if (torneos[i].equals(torneo)) {
				posTorneo = i;
			} else {
				i++;
			}
		}
		return posTorneo;
	}

	public String procesarPeorPosTorneoJugador(String jugador) {
		String devolver = null;
		int posJ = buscoJugador(jugador);
		int peorPos = 0;
		if (posJ != -1) {
			peorPos = resultados[posJ][0];
			for (int i = 0; i < resultados[posJ].length; i++) {
				if (resultados[posJ][i] > peorPos) {
					peorPos = resultados[posJ][i];
				}
			}
			devolver = "Peor resultador de " + jugador + " en el año: " + peorPos;
		}
		return devolver;
	}

	public void imprimirResultadoFinal(ArrayList<Jugador> jugadores) {
		for (Jugador j : jugadores) {
			System.out.println(j);
		}
	}
}
