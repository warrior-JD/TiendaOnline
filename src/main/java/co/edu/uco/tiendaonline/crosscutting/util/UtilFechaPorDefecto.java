package co.edu.uco.tiendaonline.crosscutting.util;

import java.sql.Date;

public class UtilFechaPorDefecto {
	
	private UtilFechaPorDefecto() {
		super();
	}
	public static Date generarFechaInvalida() {
		Date date = new Date(100, 0, 1);
         return date;
    }

}
