package es.uc3m.tiw.dominios;

public class Calificacion {
	Alumno alumno;
	Curso curso;
	double nota;
	TipoLogro tipoLogro;
	
	public Calificacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Calificacion(Alumno alumno, Curso curso, double nota,
			TipoLogro tipoLogro) {
		super();
		this.alumno = alumno;
		this.curso = curso;
		this.nota = nota;
		this.tipoLogro = tipoLogro;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public TipoLogro getTipoLogro() {
		return tipoLogro;
	}

	public void setTipoLogro(TipoLogro tipoLogro) {
		this.tipoLogro = tipoLogro;
	}
	
}
