package co.edu.uco.tiendaonline.data.entity.support;

public class NombreCompletoClienteEntity {
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
	
	
	private NombreCompletoClienteEntity(final String primerNombre,final String segundoNombre, final String primerApellido,
			final String segundoApellido) {
		
		setPrimerNombre(primerNombre);
		setSegundoNombre(segundoNombre);
		setSegundoApellido(segundoApellido);
		setPrimerApellido(primerApellido);
		
	}
	
	public static final NombreCompletoClienteEntity crear(final String primerNombre,final String segundoNombre, final String primerApellido,
			final String segundoApellido) {
		return new NombreCompletoClienteEntity(primerNombre, segundoNombre, primerApellido, segundoApellido);
	}


	private final void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}


	private final void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}


	private final void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}


	private final void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
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

	
	
	
	
}