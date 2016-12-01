package es.uc3m.tiw.dominios;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="USUARIOS")
public class Cliente implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Column(length = 30, nullable = false)
	private String nombre;
	@Column(length = 30, nullable = false)
	private String apellidos;
	@Column(length = 30, nullable = false)
	private String contrasena;
	@Column(length = 30, nullable = false, unique = true)
	private String correo;
	@Column(length = 30, nullable = false)
	private String provincia;
	@Column(nullable = false)
	private boolean esAdmin;
	//private Set<Producto> productos;
	
	public Cliente() {
		super();
	}
	
	public Cliente(long id, String nombre, String apellidos, String contrasena, String correo, String provincia,
			boolean esAdmin) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.contrasena = contrasena;
		this.correo = correo;
		this.provincia = provincia;
		this.esAdmin = esAdmin;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public boolean isEsAdmin() {
		return esAdmin;
	}
	public void setEsAdmin(boolean esAdmin) {
		this.esAdmin = esAdmin;
	}

}
