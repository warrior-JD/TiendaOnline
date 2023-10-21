package co.edu.uco.tiendaonline.service.mapper.entity.concrete;

import javax.swing.text.html.parser.Entity;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.exception.util.UtilObjeto;
import co.edu.uco.tiendaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.data.entity.TipoIdentificacionEntity;
import co.edu.uco.tiendaonline.service.domain.TipoIdentificacionDomain;
import co.edu.uco.tiendaonline.service.mapper.entity.EntityMapper;

public class TipoIdentificacionEntityMapper implements EntityMapper<TipoIdentificacionEntity, TipoIdentificacionDomain> {

	
	
	private static final EntityMapper<TipoIdentificacionEntity,TipoIdentificacionDomain> instancia = new TipoIdentificacionEntityMapper();
	
	private TipoIdentificacionEntityMapper() {
		super();
	}
	
	
	
	
	@Override
	public final TipoIdentificacionDomain toDomain(final TipoIdentificacionEntity entity) {
		if (UtilObjeto.esNulo(entity)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);;
			var mensajeTecnico = "se a presentado un problema en el metodo toDomain de la clase TipoIdentificacionMapper no es posible mapear un tipo de identificacion dominio a partir de una entidad de tipo identifiacion entity nula."; 
		}
	
		return TipoIdentificacionDomain.crear(entity.getId(), entity.getCodigo(), entity.getNombre(),entity.isEstado());
	}

	@Override
	public final  TipoIdentificacionDomain toEntity(final TipoIdentificacionDomain domain) {
		
		if (UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);;
			var mensajeTecnico = "se a presentado un problema en el metodo toEntity de la clase TipoIdentificacionMapper no es posible mapear un tipo de identificacion entity a partir de una entidad de tipo identifiacion domain nula."; 
			throw ServiceTiendaOnlineException.crear(mensajeTecnico, mensajeUsuario);
		}
		return TipoIdentificacionDomain.crear(domain.getId(), domain.getNombre(), domain.getCodigo(), domain.isEstado());
		
	}
	
	
	public final TipoIdentificacionDomain convertToDomain(final TipoIdentificacionEntity entity) {
		return instancia.toDomain(entity);
		
	}
	
	public final static TipoIdentificacionEntity convertToEntity(final TipoIdentificacionDomain domain) {
		return instancia.toEntity(domain);
		
	}
	
	
	
	
	

}
