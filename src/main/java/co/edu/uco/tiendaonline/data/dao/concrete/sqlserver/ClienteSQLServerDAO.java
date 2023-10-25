package co.edu.uco.tiendaonline.data.dao.concrete.sqlserver;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.DataTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.data.dao.ClienteDAO;
import co.edu.uco.tiendaonline.data.dao.base.SQLDAO;
import co.edu.uco.tiendaonline.data.entity.ClienteEntity;

public class ClienteSQLServerDAO extends SQLDAO implements ClienteDAO {

	

	public  ClienteSQLServerDAO(final Connection conexion) {
		super(conexion);
		
	}

	@Override
	public final void crear(final ClienteEntity entity) {
final var sentencia = new StringBuilder();
		
		sentencia.append("INSERT INTO Cliente (id, TipoIdentificacion, nombreCompleto, correoElectronico, numeroTelefonoMovil) ");
		sentencia.append("VALUES( ?, ?, ?, ?, ?)");
		
		try(final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString()) ) {
			
			sentenciaPreparada.setObject(1, entity.getId());
			sentenciaPreparada.setObject(2, entity.getTipoIdentificacion());
			sentenciaPreparada.setObject(3, entity.getNombreCompleto());
			sentenciaPreparada.setObject(4, entity.getCorreoElectronico());
			sentenciaPreparada.setObject(4, entity.getNumeroTelefonoMovil());
			
			sentenciaPreparada.executeUpdate();
		}
		catch(final SQLException excepcion){
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000059);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000060);
			throw DataTiendaOnlineException.crear(excepcion,mensajeUsuario,mensajeTecnico);
		}catch(final Exception excepcion){
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000059);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000061);
			throw DataTiendaOnlineException.crear(excepcion,mensajeUsuario,mensajeTecnico);
		}
		
		
	}

	@Override
	public final void modificar(final ClienteEntity entity) {
final var sentencia = new StringBuilder();
	    
	    sentencia.append("UPDATE Cliente ");
	    sentencia.append ("SET Cliente = ?, nombreCompleto = ?, correoElectronico = ? , numeroTelefonoMovil= ? ");
	    sentencia.append ("WHERE id = ?");
	    
	    try(final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString()) ) {
	        
			sentenciaPreparada.setObject(1, entity.getTipoIdentificacion());
			sentenciaPreparada.setObject(2, entity.getNombreCompleto());
			sentenciaPreparada.setObject(3, entity.getCorreoElectronico());
			sentenciaPreparada.setObject(4, entity.getNumeroTelefonoMovil());
	        sentenciaPreparada.setObject(5, entity.getId());
	        
	        sentenciaPreparada.executeUpdate();
	    }
	    catch(final SQLException excepcion){
	        var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000062);
	        var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000063);
	        throw DataTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
	    } catch (final Exception excepcion) {
	        var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000062);
	        var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000064);
	        throw DataTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
	    }
		
	}

	@Override
	public final void eliminar(final UUID id) {
		final var sentencia = new StringBuilder();
	    sentencia.append("DELETE FROM Cliente ");
	    sentencia.append ("WHERE id = ?");
	    
	    try(final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString()) ) {
	        sentenciaPreparada.setObject(1, id);
	        sentenciaPreparada.executeUpdate();
	    } catch (final SQLException excepcion) {
	        var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000065);
	        var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000066);
	        throw DataTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
	    } catch (final Exception excepcion) {
	        var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000065);
	        var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000067);
	        throw DataTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
	    }
		
	}

	@Override
	public final Optional<ClienteEntity> consultarPorId(final UUID id) {return null;}
	/*
		final var sentencia = new StringBuilder();
		sentencia.append("SELECT Cliente, nombreCompleto, correoElectronico, numeroTelefonoMovil");
		sentencia.append("FROM Cliente ");
		sentencia.append("WHERE id= ?");
		
		Optional<TipoIdentificacionEntity> resultado = Optional.empty();
		
		try(final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())){
			
			sentenciaPreparada.setObject(1, id);
			
			resultado = ejecutarConsultaPorId(sentenciaPreparada);
			
		}catch(final DataTiendaOnlineException excepcion) {
			throw excepcion;
		}
		catch(final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000040);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000047);
			throw DataTiendaOnlineException.crear(excepcion,mensajeUsuario,mensajeTecnico);
		}
		catch(final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000040);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000048);
			throw DataTiendaOnlineException.crear(excepcion,mensajeUsuario,mensajeTecnico);
			
		}

		return resultado;
	}
	private Optional<ClienteEntity> ejecutarConsultaPorId(final PreparedStatement sentenciaPreparada){
		Optional<ClienteEntity> resultado = Optional.empty();
		try(final var resultados = sentenciaPreparada.executeQuery()){
			if(resultados.next()) {
				var clienteEntity = 
						ClienteEntity.crear(UtilUUID.convertirStringaUUID(resultados.getObject("id").toString()), resultados.getObject("tipoIdentificacion").toString(), resultados.getString(" identificacion").toString(),resultados.getObject("nombreCompleto").toString(), resultados.getObject("correoElectronico").toString(), resultados.getObject("numeroTelefonoMovil").toString());
				
				resultado= Optional.of(clientenEntity);
			}
		}catch( final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000040);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000049);
			throw DataTiendaOnlineException.crear(excepcion,mensajeUsuario,mensajeTecnico);
		}
		catch( final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000040);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000050);
			throw DataTiendaOnlineException.crear(excepcion,mensajeUsuario,mensajeTecnico);
		}
		return resultado;
	}
*/
	@Override
	public final List<ClienteEntity> consultar(final ClienteEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
