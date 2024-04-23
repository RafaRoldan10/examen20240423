package examen20240423.jpa.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "contrato")
public class Contrato extends Entidad{
	@Id
	private int id;
	private String descripcion;
	private float saldo;
	private float limite;
	private Date fechaFirma;
	@ManyToOne
	@JoinColumn(name="idUsuario")
	private Usuario idUsuario;
	@ManyToOne
	@JoinColumn(name="idTipoContrato")
	private TipoContrato idTipoContrato;
	public Contrato() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	public float getLimite() {
		return limite;
	}
	public void setLimite(float limite) {
		this.limite = limite;
	}
	public Date getFechaFirma() {
		return fechaFirma;
	}
	public void setFechaFirma(Date fechaFirma) {
		this.fechaFirma = fechaFirma;
	}
	public Usuario getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}
	public TipoContrato getIdTipoContrato() {
		return idTipoContrato;
	}
	public void setIdTipoContrato(TipoContrato idTipoContrato) {
		this.idTipoContrato = idTipoContrato;
	}
	
	
}
