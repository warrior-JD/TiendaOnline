package co.edu.uco.tiendaonline.data.dao.concrete.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.swing.text.html.parser.Entity;

import com.mysql.cj.protocol.Resultset;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.CrossCuttingTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.exception.concrete.DataTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.exception.util.UtilObjeto;
import co.edu.uco.tiendaonline.crosscutting.exception.util.Utiltexto;
import co.edu.uco.tiendaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.data.dao.TipoIdentificacionDAO;
import co.edu.uco.tiendaonline.data.dao.base.SQLDAO;
import co.edu.uco.tiendaonline.data.dao.daofactory.TipoDAOFactory;
import co.edu.uco.tiendaonline.data.dao.daofactory.concrete.SQLServerDAOFactory;
import co.edu.uco.tiendaonline.data.entity.TipoIdentificacionEntity;

public final class TipoIdentificacionSQLServerDAO extends SQLDAO implements TipoIdentificacionDAO {

	public TipoIdentificacionSQLServerDAO(Connection conexion) {
		super(conexion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void crear(final TipoIdentificacionEntity entity) {
		// TODO Auto-generated method stub
		final var sentencia = new StringBuilder();
		
		sentencia.append("INSERT INTO TipoIdentificacion (id, codigo, nombre, estado)");
		sentencia.append("VALUES (?,?,?,?)");
		
		
		
		try (final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())) {
			
			sentenciaPreparada.setObject(1, entity.getId());
			sentenciaPreparada.setString(2, entity.getCodigo());
			sentenciaPreparada.setString(3, entity.getNombre());
			sentenciaPreparada.setBoolean(4, entity.isEstado());
			
			sentenciaPreparada.executeUpdate();
			
		} catch ( final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000036);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000037);
			throw DataTiendaOnlineException.crear( excepcion, mensajeTecnico,mensajeUsuario);
			
		} catch (final Exception excepcion) {
			
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000038);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000039);
			throw DataTiendaOnlineException.crear( excepcion, mensajeTecnico,mensajeUsuario);
		}
		
		
		
		
		
		
		
	}

	@Override
	public void modificar(TipoIdentificacionEntity entity) {
		SQLServerDAOFactory.obtenerDAOFactory(TipoDAOFactory.SQLSERVER).abrirConexion();
		
		final var sentencia = new StringBuilder();
		
		sentencia.append("UPDATE TipoIdentificacion SET codigo=?, nombre=?, estado=?");
		sentencia.append("WHERE (id=?)");
		
		
		

		
		
		try (final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())) {
			
			
			sentenciaPreparada.setString(2, "");
			sentenciaPreparada.setString(3, "");
			sentenciaPreparada.setBoolean(4, false);
			
			sentenciaPreparada.executeUpdate();
			
		} catch ( final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000044);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000045);
			throw DataTiendaOnlineException.crear( excepcion, mensajeTecnico,mensajeUsuario);
			
		} catch (final Exception excepcion) {
			
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000046);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000047);
			throw DataTiendaOnlineException.crear( excepcion, mensajeTecnico,mensajeUsuario);
		}
		
		
		SQLServerDAOFactory.obtenerDAOFactory(TipoDAOFactory.SQLSERVER).cerrarConexion();
		
	}
	
	


	@Override
	public void eliminar(UUID id) {
		SQLServerDAOFactory.obtenerDAOFactory(TipoDAOFactory.SQLSERVER).abrirConexion();
		
		final var sentencia = new StringBuilder();
		
		sentencia.append("DELETE FROM TipoIdentificacion ");
		sentencia.append("WHERE (id=)");
		
		
		

		
		
		try (final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())) {
			
			
			sentenciaPreparada.setString(2, "");
			sentenciaPreparada.setString(3, "");
			sentenciaPreparada.setBoolean(4, false);
			
			sentenciaPreparada.executeUpdate();
			
		} catch ( final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000048);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000049);
			throw DataTiendaOnlineException.crear( excepcion, mensajeTecnico,mensajeUsuario);
			
		} catch (final Exception excepcion) {
			
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000050);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000051);
			throw DataTiendaOnlineException.crear( excepcion, mensajeTecnico,mensajeUsuario);
		}
		
		
		SQLServerDAOFactory.obtenerDAOFactory(TipoDAOFactory.SQLSERVER).cerrarConexion();
		
	}

	@Override
	public Optional<TipoIdentificacionEntity> consultarPorId(UUID id) {
		// TODO Auto-generated method stub
		final var sentencia = new StringBuilder();
		sentencia.append("SELECT id, codigo, nombre, estado ");
		sentencia.append("FROM TipoIdentifiacion ");
		sentencia.append("WHERE id = ? ");
		
		Optional<TipoIdentificacionEntity> resultado =  Optional.empty();
		
		try (final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())){
			sentenciaPreparada.setObject(1, id);
			
			try (final var resultados = sentenciaPreparada.executeQuery()) {
				
				if (resultados.next()) {
					var tipoIdentificacionEntity = TipoIdentificacionEntity.crear(
							UUID.fromString(resultados.getObject("id").toString()),
							resultados.getString("codigo"),
							resultados.getString("nombre"),
							resultados.getBoolean("estado"));
					
					resultado = Optional.of(tipoIdentificacionEntity);
					}
				
				} catch (final SQLException excepcion) {
				// TODO: handle exception
				var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000040);
				var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000041);
				throw DataTiendaOnlineException.crear( excepcion, mensajeTecnico,mensajeUsuario);
				
			}
			
			
		} catch (final DataTiendaOnlineException excepcion ) {
			throw excepcion;
			
		}catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000040);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000042);
			throw DataTiendaOnlineException.crear( excepcion, mensajeTecnico,mensajeUsuario); 
			
		}catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000040);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000043);
			throw DataTiendaOnlineException.crear( excepcion, mensajeTecnico,mensajeUsuario); 
		}
		
		return resultado;
	}

	@Override
	public List<TipoIdentificacionEntity> consultar(final TipoIdentificacionEntity entity) {
		
		final var parametros = new ArrayList<Object>();
		
		//1. formar la sentencia sql
		final String sentencia = formarSentenciaConsulta(entity, parametros);
		//2. preparar la sentencia sql
		
		
	
		
		
		return prepararEjecutarSentenciaConsulta(sentencia ,parametros);
	}
	
	
	
	
	
	
	private final String formarSentenciaConsulta(final TipoIdentificacionEntity entity, final List<Object> parametros) {
		final StringBuilder sentencia = new StringBuilder();
		String operadorCondicional = "WHERE";
	
		sentencia.append("SELECT id, codigo, nombre,estado");
		sentencia.append("FROM TipoIdentificacion");
		
		if (!UtilObjeto.esNulo(entity)) {
			
			if (UtilObjeto.esNulo(entity.getId())) {
				sentencia.append(operadorCondicional).append(" id = ? ");
				operadorCondicional = "AND";
				parametros.add(entity.getId());
			}
			
			if (!Utiltexto.estaVacio(entity.getCodigo())) {
				sentencia.append(operadorCondicional).append(" id = ? ");
				operadorCondicional = "AND";
				parametros.add(entity.getCodigo());
			}
			
			if (!Utiltexto.estaVacio(entity.getNombre())) {
				sentencia.append(operadorCondicional).append(" nombre = ? ");
				operadorCondicional = "AND";
				parametros.add(entity.getNombre());
			}
			
			if (!UtilObjeto.esNulo(entity.isEstado())) {
				sentencia.append(operadorCondicional).append(" estado = ? ");
				//operadorCondicional = "AND";
				parametros.add(entity.isEstado());
			}
		}
		
		sentencia.append("ORDER BY codigo ASC");
		return sentencia.toString();
		
	}
	
	private final DataTiendaOnlineException prepararEjecutarSentenciaConsulta(final String sentencia, final List<Object> parametros) {
		try(final var sentenciaPreparada = getConexion().prepareStatement(sentencia)){
			//3. colocar los parametros
			
			colocarParametrosConsulta(sentenciaPreparada, parametros);
			return ejecutarConsulta(sentenciaPreparada);
			
		}catch (final DataTiendaOnlineException excepcion) {
			throw excepcion;
		
		
		} catch (final SQLException excepcion) {
			// TODO Auto-generated catch block
			var mensajeUsuario = "Se a presentado un problema tratando de llevar a cabo la consulta de los Tipos de Identificacion";
			var mensajeTecnico = "Se a presentado un problema en el metodo  colocarParaemtroConsulta de la clase TipoIdentificacionSQLDao ";
			throw DataTiendaOnlineException.crear( excepcion, mensajeTecnico,mensajeUsuario); 
			
			
		} catch (Exception excepcion) {
			// TODO: handle exception
			var mensajeUsuario = "Se a presentado un problema tratando de llevar a cabo la consulta de los Tipos de Identificacion";
			var mensajeTecnico = "Se a presentado un problema en el metodo  colocarParaemtroConsulta de la clase TipoIdentificacionSQLDao ";
			throw DataTiendaOnlineException.crear( excepcion, mensajeTecnico,mensajeUsuario); 
		}
		
	}

	private final void colocarParametrosConsulta (final PreparedStatement sentenciaPreparada, final List<Object> parametros ) {
		try {
			for (int indice = 0; indice <parametros.size(); indice++) {
				sentenciaPreparada.setObject(indice +1, parametros.get(indice));
			}
		} catch (SQLException excepcion) {
			// TODO: handle exception
			var mensajeUsuario = "Se a presentado un problema tratando de llevar a cabo la consulta de los Tipos de Identificacion";
			var mensajeTecnico = "Se a presentado un problema en el metodo  colocarParaemtroConsulta de la clase TipoIdentificacionSQLDao ");
			throw DataTiendaOnlineException.crear( excepcion, mensajeTecnico,mensajeUsuario); 
			
		}catch (final Exception excepcion) {
			// TODO: handle exception
			var mensajeUsuario = "Se a presentado un problema tratando de llevar a cabo la consulta de los Tipos de Identificacion";
			var mensajeTecnico = "Se a presentado un problema en el metodo  colocarParaemtroConsulta de la clase TipoIdentificacionSQLDao ");
			throw DataTiendaOnlineException.crear( excepcion, mensajeTecnico,mensajeUsuario); 
		}
	}
	
	
	private final List<TipoIdentificacionEntity> ejecutarConsulta(final PreparedStatement sentenciaPreparada){
		return null;
	}
}
