package uniandes.edu.co.epsandes.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="ServiciosIps")
public class ServicioIps {

    @EmbeddedId
    private ServicioIpsPK pk;

    public ServicioIps(){;}

    public ServicioIps(Ips nit,ServicioDeSalud id_serviciodesalud)
    {
        this.pk = new ServicioIpsPK(nit, id_serviciodesalud);
    }

    public ServicioIpsPK getPk() {
        return pk;
    }   

}
