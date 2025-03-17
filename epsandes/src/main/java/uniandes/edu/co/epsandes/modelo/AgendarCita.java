package uniandes.edu.co.epsandes.modelo;
import java.security.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="AgendarCita")
public class AgendarCita {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private Timestamp fecha_hora;

    @ManyToOne
    @JoinColumn(name="afiliado_numerodocumento", referencedColumnName="numeroDocumento")
    private Afiliado afiliado_numerodocumento;

    @ManyToOne
    @JoinColumn(name="medico_numerodocumento", referencedColumnName="numeroDocumento")
    private Medico medico_numerodocumento;

    @ManyToOne
    @JoinColumn(name="id_ordendeservicio", referencedColumnName="id")
    private OrdenDeServicio id_ordendeservicio;

    @ManyToOne
    @JoinColumn(name="id_serviciodesalud", referencedColumnName="id")
    private ServicioDeSalud id_serviciodesalud;


    public AgendarCita(){;} 

    public AgendarCita(Timestamp fecha_hora, Afiliado afiliado_numerodocumento, Medico medico_numerodocumento, OrdenDeServicio id_ordendeservicio, ServicioDeSalud id_serviciodesalud) {
        this.fecha_hora = fecha_hora;
        this.afiliado_numerodocumento = afiliado_numerodocumento;
        this.medico_numerodocumento = medico_numerodocumento;
        this.id_ordendeservicio = id_ordendeservicio;
        this.id_serviciodesalud = id_serviciodesalud;
    }
    
    
    public Integer getId() {
        return id;
    }

    public Afiliado getAfiliado_numerodocumento() {
        return afiliado_numerodocumento;
    }

    public Medico getMedico_numerodocumento() {
        return medico_numerodocumento;
    }

    public OrdenDeServicio getId_ordendeservicio() {
        return id_ordendeservicio;
    }

    public Timestamp getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha(Timestamp fecha_hora) {
        this.fecha_hora = fecha_hora;
    }


    public ServicioDeSalud getId_serviciodesalud() {
        return id_serviciodesalud;
    }




    @Override
    public String toString()
    {
        return this.fecha_hora+"|"+"Afiliado: "+this.afiliado_numerodocumento+"|"+"Medico: "+this.medico_numerodocumento+"|"+"Orden de servicio: "+this.id_ordendeservicio;
    }
    
}
