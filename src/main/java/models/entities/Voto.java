package models.entities;

import javax.persistence.*;

import models.utils.NivelEstudios;

@Entity
public class Voto {

	public static final String ID = "ID";

	@Id
	@GeneratedValue
	@Column(name = ID)
	private Integer id;

	public static final String VALORACION = "VALORACION";

	@Column(name = VALORACION)
	private Integer valoracion;

	public static final String IP = "IP";

	@Column(name = IP)
	private String ip;

	public static final String NIVELESTUDIOS = "NIVELESTUDIOS";

	@Column(name = NIVELESTUDIOS)
	private NivelEstudios nivelEstudios;

	public Voto() {

	}

	public Voto(Integer valoracion, String ip, NivelEstudios nivelEstudios) {
		this.valoracion = valoracion;
		this.ip = ip;
		this.nivelEstudios = nivelEstudios;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getValoracion() {
		return valoracion;
	}

	public void setValoracion(Integer valoracion) {
		this.valoracion = valoracion;
	}

	public String getIp() {
		return ip;
	}
          
	public void setIp(String ip) {
		this.ip = ip;
	}

	public NivelEstudios getNivelEstudios() {
		return nivelEstudios;
	}

	public void setNivelEstudios(NivelEstudios nivelEstudios) {
		this.nivelEstudios = nivelEstudios;
	}

	@Override
	public boolean equals(Object obj) {
		Voto voto = (Voto) obj;
		return this.valoracion.equals(voto.getValoracion())
				&& this.ip.equals(voto.getIp())
				&& this.nivelEstudios.equals(voto.getNivelEstudios());
	}

	public String toString() {
		return "Voto[Valoracion" + (int) valoracion + ",ip=" + ip
				+ ",nivel de estudios=" + nivelEstudios.name();
	}
	public Voto clone(){
		return new Voto(valoracion,ip,nivelEstudios);
	}

}
