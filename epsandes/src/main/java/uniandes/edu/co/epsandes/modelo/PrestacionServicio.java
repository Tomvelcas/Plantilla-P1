package uniandes.edu.co.epsandes.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "PrestacionServicio")
public class PrestacionServicio {

    @EmbeddedId
    private PrestacionServicioPK pk;

    private Integer citaRealizada;
    
    public PrestacionServicio() {;}

    public PrestacionServicio(Ips ips_nit, AgendarCita id_cita,Integer citaRealizada) {
        this.pk = new PrestacionServicioPK(ips_nit, id_cita);
        this.citaRealizada = citaRealizada;
    }
    
}
