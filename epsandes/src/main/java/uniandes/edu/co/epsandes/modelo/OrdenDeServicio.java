package uniandes.edu.co.epsandes.modelo;
import java.sql.Time;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="OrdenDeServicio")
public class OrdenDeServicio{

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private Date fecha;

    private Time hora;

    private String estado_orden;

    private String tipo_servicio;

    public OrdenDeServicio(){;}

    public OrdenDeServicio(Date fecha, Time hora, String estado_orden, String tipo_servicio){
        this.fecha = fecha;
        this.hora = hora;
        this.estado_orden = estado_orden;
        this.tipo_servicio = tipo_servicio;
    }
    @ManyToOne
    @JoinColumn(name="medico_numerodocumento", referencedColumnName="numeroDocumento")
    private Medico medico_numerodocumento;

    @ManyToOne
    @JoinColumn(name="afiliado_numerodocumento", referencedColumnName="numeroDocumento")
    private Afiliado afiliado_numerodocumento;

   
    public Integer getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getEstado_orden() {
        return estado_orden;
    }

    public void setEstado_orden(String estado_orden) {
        this.estado_orden = estado_orden;
    }

    public String getTipo_servicio() {
        return tipo_servicio;
    }

    public void setTipo_servicio(String tipo_servicio) {
        this.tipo_servicio = tipo_servicio;
    }
}