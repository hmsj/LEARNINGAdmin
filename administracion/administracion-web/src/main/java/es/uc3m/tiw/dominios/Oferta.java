package es.uc3m.tiw.dominios;

public class Oferta {
	int idoferta;
	TipoOferta tipoOferta;
	double valor;
	String fecha_fin;
	
	public Oferta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Oferta(int idoferta, TipoOferta tipoOferta, double valor,
			String fecha_fin) {
		super();
		this.idoferta = idoferta;
		this.tipoOferta = tipoOferta;
		this.valor = valor;
		this.fecha_fin = fecha_fin;
	}

	public int getIdoferta() {
		return idoferta;
	}

	public void setIdoferta(int idoferta) {
		this.idoferta = idoferta;
	}

	public TipoOferta getTipoOferta() {
		return tipoOferta;
	}

	public void setTipoOferta(TipoOferta tipoOferta) {
		this.tipoOferta = tipoOferta;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(String fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	
}
