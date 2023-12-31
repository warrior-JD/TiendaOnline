package co.edu.uco.tiendaonline.data.entity;

import java.util.UUID;

public final class TipoIdentificacionEntity {
	
	private UUID id;
	private String nombre;
	private String codigo;
	private boolean estado;
	
	
	private TipoIdentificacionEntity(final UUID id, final String nombre, final String codigo, final boolean estado) {
		setId(id);
		setCodigo(codigo);
		setEstado(estado);
		setNombre(nombre);
	}

	public static final TipoIdentificacionEntity crear(final UUID id, final String nombre, final String codigo, final Boolean estado) {
		return new TipoIdentificacionEntity(id,codigo,nombre,estado);
	}

	
	
	private final void setId(UUID id) {
		this.id = id;
	}


	private final void setNombre(final String nombre) {
		this.nombre = nombre;
	}


	private final void setCodigo(final String codigo) {
		this.codigo = codigo;
	}


	private final void setEstado(final boolean estado) {
		this.estado = estado;
	}


	public final UUID getId() {
		return id;
	}


	public final String getNombre() {
		return nombre;
	}


	public final String getCodigo() {
		return codigo;
	}


	public final boolean isEstado() {
		return estado;
	}
	
	
	
	
	
	
	

}
