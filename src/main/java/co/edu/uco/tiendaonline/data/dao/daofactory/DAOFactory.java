package co.edu.uco.tiendaonline.data.dao.daofactory;

import javax.management.RuntimeErrorException;

import co.edu.uco.tiendaonline.data.dao.ClienteDAO;
import co.edu.uco.tiendaonline.data.dao.TipoIdentificacionDAO;
import co.edu.uco.tiendaonline.data.dao.daofactory.concrete.SQLServerDAOFactory;

public abstract class DAOFactory {
	
	
	public static final DAOFactory obtenerDAOFactory (final TipoDAOFactory factoria) {
		
		switch (factoria) {
		
		case SQLSERVER: {
			return new SQLServerDAOFactory();
		}
		
		case MYSQL:{
			return new RuntimeErrorException("factoria no soportada");
		}
		
		case POSTGRESQL:{
			return new RuntimeErrorException("factoria no soportada");
		}
		
		case ORACLE:{
			return new RuntimeErrorException("factoria no soportada");
		}
		default:
			throw new RuntimeErrorException("factoria no soportada");
		}
	}
	
	protected abstract void abrirConexion();
	
	public abstract void cerrarConexion();
	
	public abstract void iniciarTransaccion();
	
	public abstract void confirmarTransaccion();
	
	public abstract void cancelarTransaccion();
	
	public abstract ClienteDAO  obtenerClienteDAO();
	
	public abstract TipoIdentificacionDAO obtenerTipoIdentificacionDAO();

}
