package ar.edu.ort.tp1.final2.clases;

import edu.ort.tp1.u5.tda.nodos.ListaOrdenadaNodos;

//TODO A completar
public class ListaBuceosPorId extends ListaOrdenadaNodos<Integer, Buceo>{

	@Override
	public int compare(Buceo b1, Buceo b2) {
		return b1.getId() - b2.getId();
	}

	@Override
	public int compareByKey(Integer clave, Buceo elemento) {
		return clave - elemento.getId();
	}

}
