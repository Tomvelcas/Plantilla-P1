package uniandes.edu.co.epsandes.modelo;
import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ServicioIpsPK implements Serializable {
 
    @ManyToOne
    @JoinColumn(name="ips_nit", referencedColumnName="nit")
    private Ips ips_nit;

    @ManyToOne
    @JoinColumn(name = "id_serviciodesalud", referencedColumnName = "id")
    private ServicioDeSalud id_serviciodesalud;


    public ServicioIpsPK()
    {
        super();
    }

    public ServicioIpsPK(Ips ips_nit, ServicioDeSalud id_serviciodesalud)
    {
        super();
        this.ips_nit = ips_nit;
        this.id_serviciodesalud = id_serviciodesalud;
    }


    public Ips getIps_nit() {
        return ips_nit;
    }
    public ServicioDeSalud getId_servicioDeSalud() {
        return id_serviciodesalud;
    }


}
