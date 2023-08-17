package ar.edu.ort.tp1.final2.clases;

import edu.ort.tp1.u5.tda.nodos.ColaNodos;
import edu.ort.tp1.u5.tda.nodos.PilaNodos;

public class CentroBuceoAvanzado {

	private static final int MESES = Mes.values().length;
	private static final String BUCEO_INVALIDO = "Buceo Invalido";
	private static final String BUZO_INVALIDO = "Buzo Invalido";
	private static final String BUZO_NO_HABILITADO = "Buzo no habilitado por profundidad.";
	private static final int CANTIDAD_BUCEOS = 10;
	private String nombre;
	private ListaBuceosPorId buceos;
	private int[] cantidadBuceosPorMes;
	private ColaNodos<Buzo> buzosRegistrados;
	private PilaNodos<String> erroresDeReserva;

	// TODO A completar atribuos.
	// private erroresDeReserva;

	public CentroBuceoAvanzado(String nombre) {
		this.nombre = nombre;
		this.buceos = new ListaBuceosPorId();
		cantidadBuceosPorMes = new int[MESES];
		this.buzosRegistrados = new ColaNodos<>();
		this.erroresDeReserva = new PilaNodos<>();
	}

	/**
	 * Se registra un buceo para un determinado buzo. si ocurre un error se registra
	 * en el log de errores, pero no se aborta la ejecucion.
	 * 
	 * -El buzo no puede ser nulo.
	 * 
	 * -El buceo cuyo id se indica, debe estar en la coleccion de buceos
	 * disponibles.
	 * 
	 * -El buzo debe estar habilitado para realizar el buceo seleccionado.
	 * 
	 * -De poder registrar al buzo, se debe agregar el buceo a su bitacora y
	 * agregarlo a los buzos registrados, que deben estar almacenados de forma
	 * cronologica.
	 * 
	 * @param buzo    Que desea bucear.
	 * @param idBuceo Identificador del buceo que el buzo quiere hacer.
	 */
	public void registrarBuceo(Buzo buzo, Integer idBuceo) {
		if (buzo == null) {
			erroresDeReserva.push(BUZO_INVALIDO);
		}
		Buceo bAux = this.buscarBuceoPorID(idBuceo);
		if (bAux == null) {
			erroresDeReserva.push(BUCEO_INVALIDO);
		} else if (buzo.habilitado(bAux.getProfundidad()) == false) {
			erroresDeReserva.push(BUZO_NO_HABILITADO);
		} else {
			buzosRegistrados.add(buzo);
			buzo.agregarABitacora(bAux);
		}

	}

	public void agregarBuceo(Buceo buceo, Mes mes) {
		if (buceo == null) {
			throw new IllegalArgumentException(BUCEO_INVALIDO);
		} else if (this.buscarBuceoPorID(buceo.getId()) == null) {
			buceos.add(buceo);
			cantidadBuceosPorMes[mes.ordinal()]++;
		}

	}

	private Buceo buscarBuceoPorID(Integer idBuceo) {
		return buceos.search(idBuceo);
	}

	public void listarErroresCronologico() {
		System.out.println("Mostrando errores en forma cronologica");
		PilaNodos<String> pilaAux = new PilaNodos<>();
		String sAux;
		while (!erroresDeReserva.isEmpty()) {
			pilaAux.push(erroresDeReserva.pop());
		}
		while (!pilaAux.isEmpty()) {
			sAux = pilaAux.pop();
			System.out.println(sAux);
			erroresDeReserva.push(sAux);
		}

	}

	public void mostrarCantidadDeBuceosPorBuzoRegistrado() {
		System.out.println("------------------");
		System.out.println("Cantidad de buceos realizados por los buzos registrados en ORT Advanced Diving\r\n Center");
		Buzo bAux = new BuzoTecnico("romeoSantos", "Argentino", 180);
		buzosRegistrados.add(bAux);
		bAux = buzosRegistrados.remove();
		try {
			while (bAux.getEdad() != 180) {
				if (bAux != null) {
					System.out.println(bAux + " " + bAux.cantidadDeEventos());
				}
				bAux = buzosRegistrados.remove();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void mostrarCantidadDeReservasPorMes() {
		Mes[] mAux = Mes.values();
		int i = 0;
		System.out.println("------------------");
		System.out.println("Cantidad de buceos por Mes");

		for (Mes mes : mAux) {
			System.out.println(
					"El mes de " + mes.getNombre() + " tiene una cantidad de reservas de: " + cantidadBuceosPorMes[i]);
			i++;
		}
	}
}
