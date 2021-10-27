package gt.com.edu.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
@Data
@Entity
@Table(name="roles")
public class Rol implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	@Column(unique=true, length = 20)
	public String nombre_rol;
	
	  //relación entre roles y usuarios
	  // @JsonIgnoreProperties({"rol","hibernateLazyInitializer","handler"})
	  //@ManyToMany(fetch = FetchType.LAZY, mappedBy = "rol", cascade = CascadeType.ALL)
	  //private List<Usuario>usuarios;

}
