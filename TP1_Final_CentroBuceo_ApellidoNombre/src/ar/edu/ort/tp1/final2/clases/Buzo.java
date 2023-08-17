package ar.edu.ort.tp1.final2.clases;

import java.util.ArrayList;

public abstract class Buzo implements BuceoProfundo {

	private static final int EDAD_MIN = 18;
	private static final String NOMBRE_INVALIDO = "Nombre invalido";
	private static final String NACIONALIDAD_INVALIDA = "Nacionalidad invalida";
	private static final String EDAD_INVALIDA = "Un buzo no puede ser menor de edad";
	private String nombre;
	private String nacionalidad;
	private int edad;
	private ArrayList<Buceo> bitacora;
	// TODO Descomentar y completar
//	private ... bitacora;

	/**
	 * Constructor del buzo, los buzos deben tener al menos de 18 años.
	 * 
	 * @param nombre       - No puede estar vacio ni ser nulo.
	 * @param nacionalidad - No puede estar vacio ni ser nulo.
	 * @param edad         debe ser valida.
	 */
	public Buzo(String nombre, String nacionalidad, int edad) {
		this.setNombre(nombre);
		this.setNacionalidad(nacionalidad);
		this.setEdad(edad);
		this.bitacora = new ArrayList<>();
	}

	private void setNombre(String nombre) {
		if (nombre.isBlank() || nombre == null) {
			throw new IllegalArgumentException(NOMBRE_INVALIDO);
		} else {
			this.nombre = nombre;
		}
		
	}

	private void setNacionalidad(String nacionalidad) {
		if (nacionalidad == null || nacionalidad.isBlank()) {
			throw new IllegalArgumentException(NACIONALIDAD_INVALIDA);
		} else {
			this.nacionalidad = nacionalidad;
		}
		
	}

	private void setEdad(int edad) {
		if (edad < EDAD_MIN) {
			throw new IllegalArgumentException(EDAD_INVALIDA);
		} else {
			this.edad = edad;
		}
		
	}

	public String getNombre() {
		return nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public int getEdad() {
		return edad;
	}

	@Override
	public String toString() {
		return "Buzo [nombre=" + nombre + ", nacionalidad=" + nacionalidad + ", edad=" + edad + "]";
	}

	public int cantidadDeEventos() {
		int contador = 0;
		for (Buceo b : bitacora) {
			contador++;
		}
		return contador;
	}

	public abstract boolean habilitado(int metros);

	
	public void agregarABitacora(Buceo buceo) {
		bitacora.add(buceo);
	}
}
