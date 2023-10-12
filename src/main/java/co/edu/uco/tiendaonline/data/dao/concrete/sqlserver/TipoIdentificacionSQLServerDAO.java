package co.edu.uco.tiendaonline.data.dao.concrete.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.mysql.cj.protocol.Resultset;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.CrossCuttingTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.exception.concrete.DataTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.data.dao.TipoIdentificacionDAO;
import co.edu.uco.tiendaonline.data.dao.base.SQLDAO;
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
			var mensajeUsuario = "Se a presentado un problema tratando de registrar la informacion del nuevo Tipo de Identificacion....";
			var mensajeTecnico = "se a presentado un problema de SQL excepcion en el metodo crear de la clase TipoIdentifiacion   la traza completa del problema presentado para asi poder ";
			throw DataTiendaOnlineException.crear(mensajeTecnico,mensajeUsuario);
			
		} catch (final Exception exception) {
			
			var mensajeUsuario = "Se a presentado un problema tratando de registrar la informacion del nuevo Tipo de Identificacion....";
			var mensajeTecnico = "se a presentado un problema inesperado de SQL excepcion en el metodo crear de la clase TipoIdentifiacion   la traza completa del problema presentado para asi poder identificar que sucedio  ";
			throw DataTiendaOnlineException.crear(exception,mensajeTecnico,mensajeUsuario);
		}
		
		
		
		
		
		
		
	}

	@Override
	public void modificar(TipoIdentificacionEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(UUID id) {
		// TODO Auto-generated method stub
		
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
				
				
				
			} catch (final SQLException exception) {
				// TODO: handle exception
				var mensajeUsuario = "Se a presentado un problema tratanod de consultar la informacion del  tipo de identificacion por el identificador deseado";
				var mensajeTecnico = "se a presentado un tipo de problema de tipo SQLexeception en el metodo ";
				throw DataTiendaOnlineException.crear(exception, mensajeTecnico,mensajeUsuario);
				
			}
			
			
		} catch (final SQLException exception) {
			
		}catch (final Exception exception) {
			
		}
		
		return resultado;
	}

	@Override
	public List<TipoIdentificacionEntity> consultar(TipoIdentificacionEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
