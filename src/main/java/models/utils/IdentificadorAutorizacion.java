package models.utils;

public class IdentificadorAutorizacion {
	
	private int valor;
	
	public IdentificadorAutorizacion(int valor){
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	@Override
	public boolean equals(Object obj) {
		return (valor == ((IdentificadorAutorizacion)obj).getValor());
	}

	@Override
	public String toString() {
		return "IdentificadorAutorizacion [valor=" + valor + "]";
	}
	



	

}
