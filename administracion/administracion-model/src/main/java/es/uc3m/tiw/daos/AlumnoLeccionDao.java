package es.uc3m.tiw.daos;

import java.util.List;

import es.uc3m.tiw.model.AlumnoLeccion;

public interface AlumnoLeccionDao {

	public abstract AlumnoLeccion createAlumnoLeccion(AlumnoLeccion alumnoLeccionNuevo) throws Exception;

	public abstract void removeAlumnoLeccion (AlumnoLeccion alumnoLeccion) throws Exception;

	public abstract AlumnoLeccion modifyAlumnoLeccion(AlumnoLeccion alumnoLeccion) throws Exception;

	public abstract List<AlumnoLeccion> findAll() throws Exception;
	
	public abstract AlumnoLeccion findByUsername(String alumnoLeccionUsername) throws Exception;

	
}
