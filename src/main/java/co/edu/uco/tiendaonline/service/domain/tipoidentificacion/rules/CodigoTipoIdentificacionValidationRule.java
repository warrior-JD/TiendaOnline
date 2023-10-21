package co.edu.uco.tiendaonline.service.domain.tipoidentificacion.rules;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.exception.util.Utiltexto;
import co.edu.uco.tiendaonline.service.domain.ValidationRule;

public final class CodigoTipoIdentificacionValidationRule implements ValidationRule<String> {
	
	public static final ValidationRule<String> instancia = new CodigoTipoIdentificacionValidationRule() {
	
		public static final void ejecutarValidacion(final String dato) {
			instancia.validar(dato);
		}
		
	}
	

	@Override
	public void validar(final String dato) {
		
		validarLongitud(dato);
		validarObligatoriedad(dato);
		validarLongitud(dato);
		
		// TODO Auto-generated method stub
		
	}
	
	private final void validarLongitud(final String dato) {
		if (!Utiltexto.longitudMaximaValida(dato, 50)) {
			var mensajeUsuario = "La longitud del codigo del tipo de identificaion no es valida. la longitud maxima debe de ser de 50";
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
		
	}
	
	private final void validarObligatoriedad(final String dato) {
		
		if (Utiltexto.estaVacio(dato)) {
			var mensajeUsuario = " el codigo del tipo de identifiacion es un dato obligatorio";
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		
			
		}
		
	}
	
	private final void validarFormato (final String dato) {
		
		if (!Utiltexto.contieneSoloLetras(dato)) {
			var mensajeUsuario = " el codigo del tipo de identifiacion solo puede contener letras";
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
			
			
	}

	
}
