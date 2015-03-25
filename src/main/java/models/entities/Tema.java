package models.entities;

import javax.persistence.*;

@Entity
@Table(name = Tema.TABLE)
public class Tema {

	public static final String TABLE = "TEMA";

	public static final String ID = "ID";

	@Id
	@GeneratedValue
	@Column(name = ID)
	private Integer id;

	public static final String PREGUNTA = "PREGUNTA";

	@Column(name = PREGUNTA)
	private String pregunta;

	public static final String NOMBRE = "NOMBRE";

	@Column(name = NOMBRE)
	private String nombre;

	public Tema() {
	}

	public Tema(String nombre, String pregunta) {
		this.nombre = nombre;
		this.pregunta = pregunta;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public boolean equals(Object obj) {
		Tema tema = (Tema) obj;
		return this.nombre.equals(tema.getNombre())
				&& this.pregunta.equals(tema.getPregunta());
	}

	@Override
	public String toString() {
		return "Tema[id=" + id + ",pregunta=" + pregunta + ",nombre=" + nombre
				+ "]";
	}

	@Override
	public Tema clone() {
		return new Tema(nombre, pregunta);

	}

}
