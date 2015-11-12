package es.uc3m.tiw.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class Banco implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idBanco;
	
	@Column(nullable=false)
	private String cuentaBancaria;
	
	@Column(nullable=false)
	private String titularCuenta;

	public Banco() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Banco(String cuentaBancaria, String titularCuenta) {
		super();
		this.cuentaBancaria = cuentaBancaria;
		this.titularCuenta = titularCuenta;
	}

	public Long getIdBanco() {
		return idBanco;
	}

	public void setIdBanco(Long idBanco) {
		this.idBanco = idBanco;
	}

	public String getCuentaBancaria() {
		return cuentaBancaria;
	}

	public void setCuentaBancaria(String cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}

	public String getTitularCuenta() {
		return titularCuenta;
	}

	public void setTitularCuenta(String titularCuenta) {
		this.titularCuenta = titularCuenta;
	}
	
}
