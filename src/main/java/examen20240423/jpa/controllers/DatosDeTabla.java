package examen20240423.jpa.controllers;

import java.text.SimpleDateFormat;
import java.util.List;

import examen20240423.jpa.model.Contrato;



public class DatosDeTabla {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public static String[] getTitulosColumnas() {
		return new String[] {"id", "descripcion", "saldo", "limite", "fechafirma", "tipoContrato", "Usuario"};
	}
	
	public static Object[][] getDatosDeTabla() {
		// Obtengo todas las personas
		@SuppressWarnings("unchecked")
		List<Contrato> estudiantes =(List<Contrato>) ControladorContrato.getInstance().findAll();
		// Preparo una estructura para pasar al constructor de la JTable
		Object[][] datos = new Object[estudiantes.size()][10];
		// Cargo los datos de la lista de personas en la matriz de los datos
		for (int i = 0; i < estudiantes.size(); i++) {
			Contrato persona = estudiantes.get(i);
			datos[i][0] = persona.getId();
			datos[i][1] = persona.getDescripcion();
			datos[i][2] = persona.getSaldo();
			datos[i][3] = persona.getLimite();
			datos[i][4] = sdf.format(persona.getFechaFirma());
			datos[i][5] = persona.getIdTipoContrato();
			datos[i][6] = persona.getIdUsuario();
			
		}
		
		return datos;
	}

}
