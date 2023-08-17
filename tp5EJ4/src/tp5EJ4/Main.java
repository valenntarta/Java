package tp5EJ4;

public class Main {

	public static void main(String[] args) {
		
		CircuitoATP c = new CircuitoATP();
		c.procesarInfo();
		System.out.println("-----------------------");
		System.out.println(c.procesarTorneosJugador("Delbonis"));
		System.out.println("-----------------------");
		System.out.println(c.obtenerResultadoJugador("Schwartzman", "RolandGarros"));
		System.out.println("-----------------------");
		System.out.println(c.procesarPeorPosTorneoJugador("Pella"));
	}

}
