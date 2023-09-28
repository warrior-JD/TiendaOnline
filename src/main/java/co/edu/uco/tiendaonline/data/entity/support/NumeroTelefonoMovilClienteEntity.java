package co.edu.uco.tiendaonline.data.entity.support;

public class NumeroTelefonoMovilClienteEntity {
	private String numeroTelefonoMovil;
	private boolean numeroTelefonoMovilConfirmado;
	
	
	
	
	private NumeroTelefonoMovilClienteEntity(final String numeroTelefonoMovil, final boolean numeroTelefonoMovilConfirmado) {
		setNumeroTelefonoMovil(numeroTelefonoMovil);
		setNumeroTelefonoMovilConfirmado(numeroTelefonoMovilConfirmado);
		}


	public static final NumeroTelefonoMovilClienteEntity crear(final String numeroTelefonoMovil, final boolean numeroTelefonoMovilConfirmado) {
		return new NumeroTelefonoMovilClienteEntity(numeroTelefonoMovil, numeroTelefonoMovilConfirmado);
	}


	private final void setNumeroTelefonoMovil(String numeroTelefonoMovil) {
		this.numeroTelefonoMovil = numeroTelefonoMovil;
	}




	private final void setNumeroTelefonoMovilConfirmado(boolean numeroTelefonoMovilConfirmado) {
		this.numeroTelefonoMovilConfirmado = numeroTelefonoMovilConfirmado;
	}




	public final String getNumeroTelefonoMovil() {
		return numeroTelefonoMovil;
	}




	public final boolean isNumeroTelefonoMovilConfirmado() {
		return numeroTelefonoMovilConfirmado;
	}
	
	
	

	
	
}