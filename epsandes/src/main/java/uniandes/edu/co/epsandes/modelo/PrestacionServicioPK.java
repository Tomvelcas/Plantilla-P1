package uniandes.edu.co.epsandes.modelo;
import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class PrestacionServicioPK implements Serializable {
 
    @ManyToOne
    @JoinColumn(name="ips_nit", referencedColumnName="nit")
    private Ips ips_nit;

    @ManyToOne
    @JoinColumn(name = "id_cita", referencedColumnName = "id")
    private AgendarCita id_cita;


    public PrestacionServicioPK()
    {
        super();
    }

    public PrestacionServicioPK( Ips ips_nit, AgendarCita id_cita)
    {
        super();
        this.ips_nit = ips_nit;
        this.id_cita = id_cita;
    }

    public Ips getIps_nit() {
        return ips_nit;
    }

    public AgendarCita getId_cita() {
        return id_cita;
    }

}
