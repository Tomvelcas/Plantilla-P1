package uniandes.edu.co.epsandes.modelo;
import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ServicioOrdenPK implements Serializable {
 
    @ManyToOne
    @JoinColumn(name="id_serviciodesalud", referencedColumnName="id")
    private ServicioDeSalud id_serviciodesalud;

    @ManyToOne
    @JoinColumn(name = "id_orden", referencedColumnName = "id")
    private OrdenDeServicio id_orden;


    public ServicioOrdenPK()
    {
        super();
    }

    public ServicioOrdenPK(ServicioDeSalud id_serviciodesalud, OrdenDeServicio id_orden)
    {
        super();
        this.id_serviciodesalud = id_serviciodesalud;
        this.id_orden = id_orden;
    }


    public ServicioDeSalud getId_serviciodesalud() {
        return id_serviciodesalud;
    }

    public OrdenDeServicio getId_orden() {
        return id_orden;
    }


}
