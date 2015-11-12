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
	
}
