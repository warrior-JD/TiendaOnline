package co.edu.uco.tiendaonline.data.dao.daofactory.concrete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import co.edu.uco.tiendaonline.data.dao.ClienteDAO;
import co.edu.uco.tiendaonline.data.dao.TipoIdentificacionDAO;
import co.edu.uco.tiendaonline.data.dao.concrete.sqlserver.ClienteSQLServerDAO;
import co.edu.uco.tiendaonline.data.dao.concrete.sqlserver.TipoIdentificacionSQLServerDAO;
import co.edu.uco.tiendaonline.data.dao.daofactory.DAOFactory;

public final class SQLServerDAOFactory extends DAOFactory {

	private Connection conexion;
	private static final String URL = "jdbc:mysql://localhost:3306/prueba";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	private boolean enTransaccion;
	
	public  SQLServerDAOFactory() {
		abrirConexion();
	}
	
	
	
	@Override
	public final  void abrirConexion() {
		// TODO: your homework will be to obtain connection with SQL Server database   Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conexion= DriverManager.getConnection(URL,USERNAME, PASSWORD);
			conexion.setAutoCommit(false);
			JOptionPane.showMessageDialog(null, "conexion exitosa");
			
			
		} catch (Exception e) {
			
			System.out.println(e);
		}
	}

	@Override
	public final void cerrarConexion() {
		// TODO your homework will be to close connection Auto-generated method stub
		try {
			if (conexion!= null && !conexion.isClosed()) {
				conexion.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public final void iniciarTransaccion() {
		// TODO your homework will be to init transaction Auto-generated method stub
		
		//final String PERSONA = "INSERT INTO personas(id, nombre, identificacion) VALUES(?,?,?)";
		//PreparedStatement personas ;
		//try {
			//personas = conexion.prepareStatement(PERSONA);
			//personas.setInt(1,100);
			//personas.setString(2, "Juan");
			//personas.setInt(3, 1130704003 );
			//personas.executeUpdate();
		//} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			//e.printStackTrace();
		//}
		
		
		if (!enTransaccion) {
			try {
				conexion.setAutoCommit(false);
				enTransaccion = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}	
	}
	

	
	@Override
	public final void confirmarTransaccion() {
		// TODO your homework will be to commit transaction Auto-generated method stub
		if (enTransaccion) {
			try {
				conexion.commit();
				conexion.setAutoCommit(true);
				enTransaccion = false;
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			
		}
		
            		
            
		
	}

	@Override
	public void cancelarTransaccion() {
		// TODO your homework will be to collback transaction Auto-generated method stub
		if (enTransaccion) {
			try {
				conexion.rollback();
				conexion.setAutoCommit(true);
				enTransaccion = false;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
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
