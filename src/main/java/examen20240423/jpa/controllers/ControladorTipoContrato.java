package examen20240423.jpa.controllers;

import examen20240423.jpa.model.TipoContrato;

public class ControladorTipoContrato extends SuperControlador{
	
private static ControladorTipoContrato instance = null;
	
	public ControladorTipoContrato() {
		super("tipocontrato",TipoContrato.class);
	}
	
	public static ControladorTipoContrato getInstance() {
		if(instance == null) {
			instance = new ControladorTipoContrato();
		}
		return instance;
	}

}
