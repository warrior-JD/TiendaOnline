package co.edu.uco.tiendaonline.crosscutting.exception;

import co.edu.uco.tiendaonline.crosscutting.exception.enumerator.LugarException;
import co.edu.uco.tiendaonline.crosscutting.exception.util.UtilObjeto;
import co.edu.uco.tiendaonline.crosscutting.exception.util.Utiltexto;

public class TiendaOnlineException extends RuntimeException {

	
	private static final long serialVersionUID = -551425372694998396L;
	private LugarException lugar;
	private Throwable exceptionRaiz;
	private String mensajeUsuario;
	private String mensajeTecnico;
	private boolean tieneExcepcionRaiz;
	
	
	
	
	
	
	protected TiendaOnlineException(final LugarException lugar, final Throwable exceptionRaiz, final String mensajeUsuario,
			final String mensajeTecnico) {
		
		setLugar(lugar);
		setExceptionRaiz(exceptionRaiz);
		setMensajeUsuario(mensajeUsuario);
		setMensajeTecnico(mensajeTecnico);
		
	}
	
	private final void setLugar(final LugarException lugar) {
		this.lugar = UtilObjeto.obtenerValorDefecto(lugar, LugarException.GENERAL);
	}
	private final void setExceptionRaiz(final Throwable exceptionRaiz) {
		this.exceptionRaiz = UtilObjeto.obtenerValorDefecto(exceptionRaiz, new Exception());
	}
	private final void setMensajeUsuario(final String mensajeUsuario) {
		this.mensajeUsuario = Utiltexto.aplicarTrim(mensajeUsuario);
	}
	private final void setMensajeTecnico(final String mensajeTecnico) {
		this.mensajeTecnico = Utiltexto.aplicarTrim(mensajeTecnico);
	}
	
	private final void setTieneExcepcionRaiz(final boolean tieneExceptionRaiz) {
		this.tieneExcepcionRaiz = tieneExceptionRaiz ;
	}

	
	
	
	public static final long getSerialversionuid() {
		return serialVersionUID;
	}
	public final LugarException getLugar() {
		return lugar;
	}
	public final Throwable getExceptionRaiz() {
		return exceptionRaiz;
	}
	public final String getMensajeUsuario() {
		return mensajeUsuario;
	}
	public final String getMensajeTecnico() {
		return mensajeTecnico;
	}

	public final boolean isTieneExcepcionRaiz() {
		return tieneExcepcionRaiz;
	}
	
	

	
	
	
	
	

}
