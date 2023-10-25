package co.edu.uco.tiendaonline.data.dao.daofactory;

import javax.management.RuntimeErrorException;

import co.edu.uco.tiendaonline.data.dao.ClienteDAO;
import co.edu.uco.tiendaonline.data.dao.TipoIdentificacionDAO;
import co.edu.uco.tiendaonline.data.dao.daofactory.concrete.SQLServerDAOFactory;

public abstract class DAOFactory {
	
	
	public static final DAOFactory obtenerDAOFactory (final TipoDAOFactory factoria) {
		switch (factoria) {
		case SQLSERVER:{
			return new SQLServerDAOFactory(); 
		}
		case POSTGRESQL:{
			throw new RuntimeException("Factoria no soportada"); 
		}
		case MYSQL:{
			throw new RuntimeException("Factoria no soportada"); 
		}
		case ORACLE:{
			throw new RuntimeException("Factoria no soportada"); 
		}
		default:
			throw new  RuntimeException("Factoria no soportada");
		}
	}
	
	public abstract void abrirConexion();
	
	public abstract void cerrarConexion();
	
	public abstract void iniciarTransaccion();
	
	public abstract void confirmarTransaccion();
	
	public abstract void cancelarTransaccion(); 
	
	public abstract ClienteDAO obtenerClienteDAO();
	
	public abstract TipoIdentificacionDAO obtenerTipoIdentificacionDAO ();


}
