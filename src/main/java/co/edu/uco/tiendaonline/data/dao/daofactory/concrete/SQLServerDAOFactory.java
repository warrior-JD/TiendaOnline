package co.edu.uco.tiendaonline.data.dao.daofactory.concrete;

import java.sql.Connection;

import co.edu.uco.tiendaonline.data.dao.ClienteDAO;
import co.edu.uco.tiendaonline.data.dao.TipoIdentificacionDAO;
import co.edu.uco.tiendaonline.data.dao.concrete.sqlserver.ClienteSQLServerDAO;
import co.edu.uco.tiendaonline.data.dao.concrete.sqlserver.TipoIdentificacionSQLServerDAO;
import co.edu.uco.tiendaonline.data.dao.daofactory.DAOFactory;

public final class SQLServerDAOFactory extends DAOFactory {

	private Connection conexion;
	
	public  SQLServerDAOFactory() {
		abirConexion();
	}
	
	
	
	@Override
	protected final void abirConexion() {
		// TODO: your homework will be to obtain connection with SQL Server database   Auto-generated method stub
		conexion = null;
	}

	@Override
	public final void cerrarConexion() {
		// TODO your homework will be to close connection Auto-generated method stub
		
	}

	@Override
	public final void iniciarTransaccion() {
		// TODO your homework will be to init transaction Auto-generated method stub
		
	}

	@Override
	public final void confirmarTransaccion() {
		// TODO your homework will be to commit transaction Auto-generated method stub
		
	}

	@Override
	public void cancelarTransaccion() {
		// TODO your homework will be to collback transaction Auto-generated method stub
		
	}

	@Override
	public ClienteDAO obtenerClienteDAO() {
		// TODO Auto-generated method stub
		return  new ClienteSQLServerDAO(conexion);
	}

	@Override
	public TipoIdentificacionDAO obtenerTipoIdentificacionDAO() {
		// TODO Auto-generated method stub
		return new TipoIdentificacionSQLServerDAO(conexion);
	}
	
	

}
