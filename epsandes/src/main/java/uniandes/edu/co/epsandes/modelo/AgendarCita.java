package uniandes.edu.co.epsandes.modelo;
import java.sql.Date;
import java.sql.Time;

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

    private Date fecha;

    private Time hora;


    public AgendarCita(){;} 

    public AgendarCita(Date fecha, Time hora)
    {
        this.fecha = fecha;
        this.hora = hora;
    }
    @ManyToOne
    @JoinColumn(name="afiliado_numerodocumento", referencedColumnName="numeroDocumento")
    private Afiliado afiliado_numerodocumento;

    @ManyToOne
    @JoinColumn(name="medico_numerodocumento", referencedColumnName="numeroDocumento")
    private Medico medico_numerodocumento;

    @ManyToOne
    @JoinColumn(name="id_ordendeservicio", referencedColumnName="id")
    private OrdenDeServicio id_ordendeservicio;
    
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

    public Date getFecha() {
        return fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }


    @Override
    public String toString()
    {
        return this.fecha+"|"+this.hora+"|"+"Afiliado: "+this.afiliado_numerodocumento+"|"+"Medico: "+this.medico_numerodocumento+"|"+"Orden de servicio: "+this.id_ordendeservicio;
    }
    
}
