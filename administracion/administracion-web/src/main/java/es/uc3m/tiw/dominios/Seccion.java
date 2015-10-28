package es.uc3m.tiw.dominios;

import java.io.Serializable;


public class Seccion implements Serializable{
	int idseccion;
	String titulo;
	Curso curso;
	
	public Seccion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Seccion(int idseccion, String titulo, Curso curso) {
		super();
		this.idseccion = idseccion;
		this.titulo = titulo;
		this.curso = curso;
	}

	public int getIdseccion() {
		return idseccion;
	}

	public void setIdseccion(int idseccion) {
		this.idseccion = idseccion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
}
