package examen20240423.jpa.controllers;

import examen20240423.jpa.model.Contrato;

public class ControladorContrato extends SuperControlador{
	
private static ControladorContrato instance = null;
	
	public ControladorContrato() {
		super("contrato",Contrato.class);
	}
	
	public static ControladorContrato getInstance() {
		if(instance == null) {
			instance = new ControladorContrato();
		}
		return instance;
	}

}
