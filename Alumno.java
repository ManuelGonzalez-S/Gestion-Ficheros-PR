import java.time.LocalDate;

public class Alumno {
	
	private String nombre;
	
	private String grupo;
	
	private LocalDate fechaNac;
	
	public Alumno() {
		super();
	}

	public Alumno(String nombre, String grupo, LocalDate fechaNac) {
		super();
		this.nombre = nombre;
		this.grupo = grupo;
		this.fechaNac = fechaNac;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	@Override
	public String toString() {
		return nombre + ';' + grupo + ';' + fechaNac;
	}

	

}
