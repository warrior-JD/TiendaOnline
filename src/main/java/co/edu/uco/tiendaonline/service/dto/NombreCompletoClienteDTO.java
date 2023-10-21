package co.edu.uco.tiendaonline.service.dto;

import co.edu.uco.tiendaonline.crosscutting.exception.util.Utiltexto;


public class NombreCompletoClienteDTO {

	
	
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
	
	
	

	public NombreCompletoClienteDTO() {
		setPrimerApellido(Utiltexto.VACIO);
		setSegundoApellido(Utiltexto.VACIO);
		setPrimerNombre(Utiltexto.VACIO);
		setSegundoNombre(Utiltexto.VACIO);
		
	}
	
	
	
	
	public NombreCompletoClienteDTO(final String primerNombre,final String segundoNombre,final String primerApellido,
			final String segundoApellido) {
		setPrimerApellido(primerApellido);
		setPrimerNombre(primerNombre);
		setSegundoApellido(segundoApellido);
		setSegundoNombre(segundoNombre);
	}
	
	
	
	
	
	public final String getPrimerNombre() {
		return primerNombre;
	}
	public final String getSegundoNombre() {
		return segundoNombre;
	}
	public final String getPrimerApellido() {
		return primerApellido;
	}
	public final String getSegundoApellido() {
		return segundoApellido;
	
	}
	
	
	
	
	
	
	public final NombreCompletoClienteDTO setPrimerNombre(final String primerNombre) {
		this.primerNombre = primerNombre;
		return this;
	}
	
	
	public final NombreCompletoClienteDTO setSegundoNombre(final String segundoNombre) {
		this.segundoNombre = segundoNombre;
		return this;
	}
	
	
	public final NombreCompletoClienteDTO setPrimerApellido(final String primerApellido) {
		this.primerApellido = primerApellido;
		return this;
	}
	
	public final NombreCompletoClienteDTO setSegundoApellido(final String segundoApellido) {
		this.segundoApellido = segundoApellido;
		return this;
	}
	
	
	
	
}
