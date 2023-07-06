package musicpro.Commons;

public class ErrorDTO {

	private String mensaje;

	public ErrorDTO(String mensaje) {
		super();
		this.mensaje = mensaje;
	}

	public ErrorDTO() {
		super();
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	@Override
	public String toString() {
		return "ErrorDTO [mensaje=" + mensaje + "]";
	}

}
