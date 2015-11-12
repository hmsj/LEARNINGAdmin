package es.uc3m.tiw.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Logro  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int idLogro;
	
	@Column(nullable=true)
	private String descripcionLogro;

	public Logro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Logro(int idLogro, String descripcionLogro) {
		super();
		this.idLogro = idLogro;
		this.descripcionLogro = descripcionLogro;
	}

	public int getIdLogro() {
		return idLogro;
	}

	public void setIdLogro(int idLogro) {
		this.idLogro = idLogro;
	}

	public String getDescripcionLogro() {
		return descripcionLogro;
	}

	public void setDescripcionLogro(String descripcionLogro) {
		this.descripcionLogro = descripcionLogro;
	}

}
