package co.edu.uco.tiendaonline.service.bussineslogic.concrete.tipoidentificacion;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.exception.util.UtilObjeto;
import co.edu.uco.tiendaonline.data.dao.TipoIdentificacionDAO;
import co.edu.uco.tiendaonline.data.dao.daofactory.DAOFactory;
import co.edu.uco.tiendaonline.data.entity.TipoIdentificacionEntity;
import co.edu.uco.tiendaonline.service.bussineslogic.UseCase;
import co.edu.uco.tiendaonline.service.domain.TipoIdentificacionDomain;
import co.edu.uco.tiendaonline.service.mapper.entity.concrete.TipoIdentificacionEntityMapper;

public class RegistrarTipoIdentifiacionUseCase  implements UseCase<TipoIdentificacionDomain>{
	
	
	private final DAOFactory factoria;
	
	
	
	
	

	public RegistrarTipoIdentifiacionUseCase(final DAOFactory factoria) {
		
		setFactoria(factoria);
		
	}





	@Override
	public void execute(final TipoIdentificacionDomain domain) {
		// 1. validar integridad de datos (tipo dato, longitud, obligatoriedad, formato, etc)
		//como lo hago	
		
		

		// 2. no debe de existir otro tipo de identificacion con el mismo identificador
		domain = obtenerIdentificadorTipoIdentifiacion(domain);
		
		// 3. no debe de existir otro tipo de identificacion con el mismo codigo
		validarNoExistenciaTipoIdentifiacionConMismoCodigo(domain.getCodigo());
		
		// 4. no debe de existir otro tipo de identificacion con el mismo nombre
		validarNoExistenciaTipoIdentifiacionConMismoNombre(domain.getNombre());
		
		// 5. no debe de existir otro tipo de identificacion con el mismo identificador
				domain = obtenerIdentificadorTipoIdentifiacion(domain);
		
		// 6. registrar el nuevo tipo de identificacion
	}
	
	private final void registrarNuevoTipoIdentifiacion(final TipoIdentificacionDomain domain) {
		var entity = TipoIdentificacionEntityMapper.convertToEntity(domain);
				
	
		getTipoIdentificacionDAO().crear(entity);
	}
	
	
	
	
	
	private final void validarNoExistenciaTipoIdentifiacionConMismoNombre(final String nombre) {
		//todo : como lograr que eso no quede tan feo 
		
		var domain = TipoIdentificacionDomain.crear(null, null, nombre, false);
		var entity = TipoIdentificacionEntityMapper.convertToEntity(domain);
		var resultados = getTipoIdentificacionDAO().consultar(entity);
		
		if (!resultados.isEmpty()) {
			var mensajeUsuario =  "ya existe un tipo de identificacion con el nombre" + nombre;
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
		
	}
	
	private final void validarNoExistenciaTipoIdentifiacionConMismoCodigo(final String codigo) {
		//todo : como lograr que eso no quede tan feo 
		
		var domain = TipoIdentificacionDomain.crear(null, null, codigo, false);
		var entity = TipoIdentificacionEntityMapper.convertToEntity(domain);
		var resultados = getTipoIdentificacionDAO().consultar(entity);
		
		if (!resultados.isEmpty()) {
			var mensajeUsuario =  "ya existe un tipo de identificacion con el mismo codigo" + codigo;
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
	}
	
	
	private final void validarNoExistenciaTipoIdentifiacionConMismoID(final UUID id) {
		//todo : como lograr que eso no quede tan feo 
		
		var domain = TipoIdentificacionDomain.crear(id, null, null, false);
		
		var entity = TipoIdentificacionEntityMapper.convertToEntity(domain);
		var resultados = getTipoIdentificacionDAO().consultar(entity);
		
		if (!resultados.isEmpty()) {
			var mensajeUsuario =  "ya existe un tipo de identificacion con el mismo id" + id;
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
	}
		
	
	
	private final TipoIdentificacionDomain obtenerIdentificadorTipoIdentifiacion(TipoIdentificacionDomain domain) {
		Optional<TipoIdentificacionEntity> optional;
		UUID uuid;
		do {
			 uuid = UUID.randomUUID();
			optional = getTipoIdentificacionDAO().consultarPorId(uuid);
		}while(optional.isPresent());
		
		domain = TipoIdentificacionDomain.crear(uuid, domain.getCodigo(),
				domain.getNombre(),domain.isEstado());
		
	
	}
	
	
	
	
		
		
	
	
	
		
	
	
	
	
	





	private final DAOFactory getFactoria() {
		return factoria;
	}





	private final TipoIdentificacionDAO getTipoIdentificacionDAO() {
		return getFactoria().obtenerTipoIdentificacionDAO();
	}
	
	
	private final void setFactoria (final DAOFactory factoria) {
		
		if (UtilObjeto.esNulo(factoria)) {
			var mensajeUsuario = "tratando de llevar a cabo el registro de la informacion del nuevo tipo de identificacion";
			var mensajeTecnico = "";
			throw ServiceTiendaOnlineException.crear(mensajeTecnico,mensajeUsuario);
		}
		this.factoria = factoria;
	
	}
	
	
	
	
	
}


