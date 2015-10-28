package es.uc3m.tiw.dominios;

import java.util.ArrayList;

public class Alumno {
	Usuario username;
	Curso curso_actual;
	ArrayList<Curso> listado_cursos;
	
	public Alumno() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Alumno(Usuario username, Curso curso_actual,
			ArrayList<Curso> listado_cursos) {
		super();
		this.username = username;
		this.curso_actual = curso_actual;
		this.listado_cursos = listado_cursos;
	}

	public Usuario getUsername() {
		return username;
	}

	public void setUsername(Usuario username) {
		this.username = username;
	}

	public Curso getCurso_actual() {
		return curso_actual;
	}

	public void setCurso_actual(Curso curso_actual) {
		this.curso_actual = curso_actual;
	}

	public ArrayList<Curso> getListado_cursos() {
		return listado_cursos;
	}

	public void setListado_cursos(ArrayList<Curso> listado_cursos) {
		this.listado_cursos = listado_cursos;
	}
	
}