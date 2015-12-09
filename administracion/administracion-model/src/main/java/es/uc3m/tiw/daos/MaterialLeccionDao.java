package es.uc3m.tiw.daos;

import java.util.List;

import es.uc3m.tiw.model.MaterialLeccion;

public interface MaterialLeccionDao {

	public abstract MaterialLeccion createMaterialLeccion(MaterialLeccion materialLeccionNuevo) throws Exception;

	public abstract void removeMaterial (MaterialLeccion material) throws Exception;

	public abstract List<MaterialLeccion> findAll() throws Exception;
	
	public abstract MaterialLeccion findById(Long idMaterial) throws Exception;
	
	public abstract List<MaterialLeccion> listadoMaterialesLeccion (Long idLeccion) throws Exception;
	
	public abstract List<MaterialLeccion> listadoMaterialesCurso (Long idCurso) throws Exception;

}
