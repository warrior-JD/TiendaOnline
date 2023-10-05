package co.edu.uco.tiendaonline.crosscutting.exception.util;

import java.sql.Connection;
import java.sql.SQLException;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.CrossCuttingTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;

public final class UtilSQL {
	
	private UtilSQL() {
		super();
	}

	public static final boolean conexionAbierta(final Connection conexion) {
		
if (UtilObjeto.esNulo(conexion)) {
			
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M000004);
			var mensajeTecnico = "No es posible validar si una conexion que esta abierta cuando es nula...";
			throw CrossCuttingTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		try {
			return !conexion.isClosed() ;
		} catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M000005);
			throw CrossCuttingTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
			
		}
		catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M000006);
			throw CrossCuttingTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
			
		}
		
	}
	
	public static final void cerrarConexion (final Connection conexion) {
		if (UtilObjeto.esNulo(conexion)) {
			
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M000004);
			var mensajeTecnico = "No es posible cerrar una conexion que esta nula...";
			throw CrossCuttingTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
	
		try {
			if (!conexionAbierta(conexion)) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M000004);
				var mensajeTecnico = "No es posible cerrar una conexion que esta cerrada...";
				throw CrossCuttingTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
				
			}
			conexion.close();
			
		} catch (final CrossCuttingTiendaOnlineException excepcion ) {
			throw excepcion
		}
	}
	
}
