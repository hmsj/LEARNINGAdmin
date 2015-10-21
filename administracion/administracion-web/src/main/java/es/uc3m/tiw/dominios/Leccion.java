package es.uc3m.tiw.dominios;


public class Leccion {
	int idleccion;
	String titulo;
	Curso curso;
	String descripcion;
	Seccion seccion;
	
	public Leccion() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Leccion(int idleccion, String titulo, Curso curso,
			String descripcion, Seccion seccion) {
		super();
		this.idleccion = idleccion;
		this.titulo = titulo;
		this.curso = curso;
		this.descripcion = descripcion;
		this.seccion = seccion;
	}
	public int getIdleccion() {
		return idleccion;
	}
	
	public void setIdleccion(int idleccion) {
		this.idleccion = idleccion;
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
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Seccion getSeccion() {
		return seccion;
	}
	
	public void setSeccion(Seccion seccion) {
		this.seccion = seccion;
	}
	
}
