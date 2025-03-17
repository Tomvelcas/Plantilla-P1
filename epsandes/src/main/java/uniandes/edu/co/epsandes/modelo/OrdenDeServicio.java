package uniandes.edu.co.epsandes.modelo;
import java.sql.Timestamp;

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

    private Timestamp fecha_hora;

    private String estado_orden;

    public OrdenDeServicio(){;}

    public OrdenDeServicio(Timestamp fecha_hora, String estado_orden, Medico medico_numerodocumento, Afiliado afiliado_numerodocumento) {
        this.fecha_hora = fecha_hora;
        this.estado_orden = estado_orden;
        this.medico_numerodocumento = medico_numerodocumento;
        this.afiliado_numerodocumento = afiliado_numerodocumento;
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

    public Timestamp getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(Timestamp fecha) {
        this.fecha_hora = fecha_hora;
    }

    public String getEstado_orden() {
        return estado_orden;
    }

    public void setEstado_orden(String estado_orden) {
        this.estado_orden = estado_orden;
    }

    public Medico getMedico_numerodocumento() {
        return medico_numerodocumento;
    }

    public Afiliado getAfiliado_numerodocumento() {
        return afiliado_numerodocumento;
    }

}