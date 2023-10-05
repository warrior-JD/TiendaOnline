package co.edu.uco.tiendaonline.crosscutting.exception.util;

public final class Utiltexto {
	public static final String VACIO ="";

	private Utiltexto() {
		super();
	}
	

	
	public static final String obtenerValorDefecto(final String valor, final String valorDefecto) {
		return UtilObjeto.obtenerValorDefecto(valor, valorDefecto);
		
	}
	
	public static final String obtenerValorDefecto(final String valor) {
		return obtenerValorDefecto(valor, VACIO);
		
	}
	
	public static final String aplicarTrim(final String valor) {
		return obtenerValorDefecto(valor).trim();
	}
	
	public static final boolean igualSinTrim (final String valorUno, final String valorDos ) {
		return obtenerValorDefecto(valorUno).equals(obtenerValorDefecto(valorDos));
	}
	
	public static final boolean igualConTrim (final String valorUno, final String valorDos ) {
		return aplicarTrim(valorUno).equals(aplicarTrim(valorDos));
	}
	
	public static final boolean igualSinTrimIgnoreCase (final String valorUno, final String valorDos ) {
		return obtenerValorDefecto(valorUno).equalsIgnoreCase(obtenerValorDefecto(valorDos));
	}
	
	public static final boolean igualConTrimIgnoreCase (final String valorUno, final String valorDos ) {
		return aplicarTrim(valorUno).equalsIgnoreCase(aplicarTrim(valorDos));
	}
	
	
	
	
}
