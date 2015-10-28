package es.uc3m.tiw.dominios;

import java.io.Serializable;

public class Usuario implements Serializable{
	String username;
	String nombre;
	String apellidos;
	String email;
	String password;
	String imagen;
	String telefono;
	String descripcion;
	String intereses;
	int edad;
	TipoUsuario tipoUsuario;
	Direccion direccion;
	DatosBancarios banco;
	
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(String username, String nombre, String apellidos,
			String email, String password, String imagen, String telefono,
			String descripcion, String intereses, int edad,
			TipoUsuario tipoUsuario, Direccion direccion, DatosBancarios banco) {
		super();
		this.username = username;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.password = password;
		this.imagen = imagen;
		this.telefono = telefono;
		this.descripcion = descripcion;
		this.intereses = intereses;
		this.edad = edad;
		this.tipoUsuario = tipoUsuario;
		this.direccion = direccion;
		this.banco = banco;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getIntereses() {
		return intereses;
	}

	public void setIntereses(String intereses) {
		this.intereses = intereses;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public DatosBancarios getBanco() {
		return banco;
	}

	public void setBanco(DatosBancarios banco) {
		this.banco = banco;
	}
	
}
