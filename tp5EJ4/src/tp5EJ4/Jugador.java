package tp5EJ4;

public class Jugador {
	private String nombre;
    private int puntos;
    private int mejor_resultado;
    private int peor_resultado;

    public String getNombre() {
        return nombre;
    }
    public int getPuntos() {
        return puntos;
    }
    public void sumarPuntos(int resultado) {
        switch (resultado) {
            case 1:
                this.puntos += 50;
                break;
            case 2:
                this.puntos += 25;
                break;
            case 3:
                this.puntos += 10;
                break;
            case 4:
                this.puntos += 5;
                break;
            default:puntos+=0;
                break;
        }
    }

    public int getMejorResultado() {
        return mejor_resultado;
    }
    public void calcularMejorResultado(int resultado) {
           if(resultado < mejor_resultado)mejor_resultado=resultado;
    }
    public int getPeorResultado() {
        return peor_resultado;
    }
    public void calcularPeorResultado(int resultado) {
        if(resultado > peor_resultado) peor_resultado=resultado;
    }
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntos = 0;
        this.mejor_resultado = Integer.MAX_VALUE;
        this.peor_resultado = 0;
    }
    public void procesarResultado(int resultado) {
        this.sumarPuntos(resultado);
        this.calcularMejorResultado(resultado);
        this.calcularPeorResultado(resultado);
    }
	@Override
	public String toString() {
		return "Jugador=" + nombre + ", puntos=" + puntos + ", mejor_resultado=" + mejor_resultado
				+ ", peor_resultado=" + peor_resultado + "]";
	}
}
