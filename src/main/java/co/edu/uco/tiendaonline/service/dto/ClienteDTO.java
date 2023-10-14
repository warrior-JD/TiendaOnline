package co.edu.uco.tiendaonline.service.dto;

import java.sql.Date;
import java.util.UUID;

import co.edu.uco.tiendaonline.crosscutting.exception.util.Utiltexto;
import co.edu.uco.tiendaonline.data.entity.TipoIdentificacionEntity;
import co.edu.uco.tiendaonline.data.entity.support.CorreoElectronicoClienteEntity;
import co.edu.uco.tiendaonline.data.entity.support.NombreCompletoClienteEntity;
import co.edu.uco.tiendaonline.data.entity.support.NumeroTelefonoMovilClienteEntity;

public final class ClienteDTO {

	
	
	private UUID  id;
	private TipoIdentificacionEntity tipoidentificacion;
	private String identificacion;
	private NombreCompletoClienteEntity nombreCompleto ;
	private CorreoElectronicoClienteEntity correoElectronico;
	private NumeroTelefonoMovilClienteEntity numeroCompleto;
	private Date fechaNacimiento;
	
	

	private ClienteDTO() {
		super();
	
		setId(id);
		setTipoidentificacion(new TipoIdentificacionDTO());
		setIdentificacion(Utiltexto.VACIO);
		setNombreCompleto(new NombreCompletoDTO());
		setCorreoElectronico(correoElectronico);
		setNumeroCompleto(numeroCompleto);
		setFechaNacimiento(fechaNacimiento);
		
		
	}
	
	
	
	
	
	
	private ClienteDTO(final UUID id,final TipoIdentificacionEntity tipoidentificacion, final String identificacion, final NombreCompletoClienteEntity nombreCompleto , final CorreoElectronicoClienteEntity correoElectronico , final NumeroTelefonoMovilClienteEntity numeroCompleto, final Date fechaNacimiento) {
		super();
	
		setId(id);
		setTipoidentificacion(tipoidentificacion);
		setIdentificacion(identificacion);
		setNombreCompleto(nombreCompleto);
		setCorreoElectronico(correoElectronico);
		setNumeroCompleto(numeroCompleto);
		setFechaNacimiento(fechaNacimiento);
		
		
	}
	
	public static final ClienteDTO crear(final UUID id,final TipoIdentificacionEntity tipoidentificacion, final String identificacion ,final NombreCompletoClienteEntity nombreCompleto,final CorreoElectronicoClienteEntity correoElectronico, final NumeroTelefonoMovilClienteEntity numeroCompleto, final Date fechaNacimiento) {
		return new ClienteDTO(id, tipoidentificacion, identificacion,nombreCompleto ,
				 correoElectronico, numeroCompleto, fechaNacimiento);
	}
	
	
	






	public final UUID getId() {
		return id;
	}

	public final ClienteDTO setId(UUID id) {
	
		this.id = id;
		return this;
	}

	public final TipoIdentificacionEntity getTipoidentificacion() {
		return tipoidentificacion;
	}

	public final ClienteDTO setTipoidentificacion(TipoIdentificacionEntity tipoidentificacion) {
		this.tipoidentificacion = tipoidentificacion;
		return this;
	}

	public final String getIdentificacion() {
		return identificacion;
	}

	public final ClienteDTO setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
		return this;
	}

	public final NombreCompletoClienteEntity getNombreCompleto() {
		return nombreCompleto;
	}

	public final ClienteDTO setNombreCompleto(NombreCompletoClienteEntity nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
		return this;
	}

	public final CorreoElectronicoClienteEntity getCorreoElectronico() {
		return correoElectronico;
	}

	public final ClienteDTO setCorreoElectronico(CorreoElectronicoClienteEntity correoElectronico) {
		this.correoElectronico = correoElectronico;
		return this;
	}

	public final NumeroTelefonoMovilClienteEntity getNumeroCompleto() {
		return numeroCompleto;
	}

	public final ClienteDTO setNumeroCompleto(NumeroTelefonoMovilClienteEntity numeroCompleto) {
		this.numeroCompleto = numeroCompleto;
		return this;
	}

	public final Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public final ClienteDTO setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
		return this;
	}

	
	
	
}
