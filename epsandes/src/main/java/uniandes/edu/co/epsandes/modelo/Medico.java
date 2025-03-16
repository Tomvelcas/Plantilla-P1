package uniandes.edu.co.epsandes.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Medico")
public class Medico {

    private String nombre;
    private String tipoDocumento;
    @Id
    private Integer numeroDocumento;
    private Integer numeroRegistroMedico;
    private String especialidad;

    public Medico() {;}

    public Medico(String nombre, String tipoDocumento, Integer numeroDocumento, Integer numeroRegistroMedico, String especialidad) {
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.especialidad = especialidad;
    }

    @ManyToOne 
    @JoinColumn(name="ips_nit", referencedColumnName="nit")
    private Ips ips_nit;

    public String getNombre() {
        return nombre;
    }
    public String getTipoDocumento() {
        return tipoDocumento;
    }
    public Integer getNumeroDocumento() {
        return numeroDocumento;
    }
    public Integer getNumeroRegistroMedico() {
        return numeroRegistroMedico;
    }
    public String getEspecialidad() {
        return especialidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
    public void setNumeroRegistroMedico(Integer numeroRegistroMedico) {
        this.numeroRegistroMedico = numeroRegistroMedico;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
}