package co.edu.uco.tiendaonline.data.dao.base;

import java.sql.Connection;

public class SQLDAO {
	
	private Connection conexion;
	
	protected SQLDAO (final Connection conexion) {
		setConexion(conexion);
		
	}

	
	private final void setConexion(Connection conexion) {
		//todo: controlar que la conexion no sea nula, que no este cerrada o que ya no se alla confirmado una transaccion
		this.conexion = conexion;
	}

	public final Connection getConexion() {
		return conexion;
	}
	
	
	
	
	
	

}
