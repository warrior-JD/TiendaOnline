package co.edu.uco.tiendaonline.data.entity;

import java.sql.Date;
import java.util.UUID;

import co.edu.uco.tiendaonline.data.entity.support.CorreoElectronicoClienteEntity;
import co.edu.uco.tiendaonline.data.entity.support.NombreCompletoClienteEntity;
import co.edu.uco.tiendaonline.data.entity.support.NumeroTelefonoMovilClienteEntity;

public class ClienteEntity {

	private UUID  id;
	private TipoIdentificacionEntity tipoidentificacion;
	private String identificacion;
	private NombreCompletoClienteEntity nombreCompleto ;
	private CorreoElectronicoClienteEntity correoElectronico;
	private NumeroTelefonoMovilClienteEntity numeroCompleto;;
	private Date fechaNacimiento;



	private ClienteEntity(final UUID id,final TipoIdentificacionEntity tipoidentificacion, final String identificacion, final NombreCompletoClienteEntity nombreCompleto , final CorreoElectronicoClienteEntity correoElectronico , final NumeroTelefonoMovilClienteEntity numeroCompleto, final Date fechaNacimiento) {
		super();
	
		setId(id);
		setTipoidentificacion(tipoidentificacion);
		setIdentificacion(identificacion);
		setNombreCompleto(nombreCompleto);
		setCorreoElectronico(correoElectronico);
		setNumeroCompleto(numeroCompleto);
		setFechaNacimiento(fechaNacimiento);
		
		
	}
	
	public static final ClienteEntity crear(final UUID id,final TipoIdentificacionEntity tipoidentificacion, final String identificacion ,final NombreCompletoClienteEntity nombreCompleto,final CorreoElectronicoClienteEntity correoElectronico, final NumeroTelefonoMovilClienteEntity numeroCompleto, final Date fechaNacimiento) {
		return new ClienteEntity(id, tipoidentificacion, identificacion,nombreCompleto ,
				 correoElectronico, numeroCompleto, fechaNacimiento);
	}



	private final void setId(UUID id) {
		this.id = id;
	}



	private final void setTipoidentificacion(TipoIdentificacionEntity tipoidentificacion) {
		this.tipoidentificacion = tipoidentificacion;
	}

	private void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}


	private final void setNombreCompleto(NombreCompletoClienteEntity nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	private final void setCorreoElectronico(CorreoElectronicoClienteEntity correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	


	private final void setNumeroCompleto(NumeroTelefonoMovilClienteEntity numeroCompleto) {
		this.numeroCompleto = numeroCompleto;
	}
	
	

	private final void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public final UUID getId() {
		return id;
	}



	public final TipoIdentificacionEntity getTipoidentificacion() {
		return tipoidentificacion;
	}


	public final NombreCompletoClienteEntity getNombreCompleto() {
		return nombreCompleto;
	}

	public final CorreoElectronicoClienteEntity getCorreoElectronico() {
		return correoElectronico;
	}

	public final NumeroTelefonoMovilClienteEntity getNumeroCompleto() {
		return numeroCompleto;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public final Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	

	

	
	
	
	
	
}
