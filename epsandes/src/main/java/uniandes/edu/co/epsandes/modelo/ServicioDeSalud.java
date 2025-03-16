package uniandes.edu.co.epsandes.modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ServicioDeSalud")
public class ServicioDeSalud {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nombre;

    private String descripcion;

    private String tipo;

    public ServicioDeSalud()
    {;}

    public ServicioDeSalud(String nombre, String descripcion, String tipo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public String getTipo() {
        return tipo;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
