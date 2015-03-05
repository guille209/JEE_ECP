package models.entities;

import java.util.List;

import javax.persistence.*;

@Entity
public class Tema {

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

	public static final String VOTO_ID = "VOTO_ID";

	@OneToMany(cascade = CascadeType.ALL)
	private List<Voto> votos;

	public Tema() {

	}

	public Tema(String nombre, String pregunta, List<Voto> votos) {
		this.nombre = nombre;
		this.pregunta = pregunta;
		this.votos = votos;
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

	public List<Voto> getVotos() {
		return votos;
	}

	public void setVotos(List<Voto> votos) {
		this.votos = votos;
	}

	@Override
	public boolean equals(Object obj) {
		Tema tema = (Tema) obj;
		return this.nombre.equals(tema.getNombre())
				&& this.pregunta.equals(tema.getPregunta())
				&& this.votos.equals(tema.getVotos());
	}

	@Override
	public String toString() {
		return "Tema[id=" + id + ",pregunta=" + pregunta + ",nombre=" + nombre
				+ ",votos=" + votos + "]";
	}

	@Override
	public Tema clone() {
		return new Tema(nombre, pregunta, votos);
	}

}
