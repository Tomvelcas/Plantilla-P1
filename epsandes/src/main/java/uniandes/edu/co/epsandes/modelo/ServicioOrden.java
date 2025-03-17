package uniandes.edu.co.epsandes.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="ServicioOrden")
public class ServicioOrden {

    @EmbeddedId
    private ServicioOrdenPK pk;

    public ServicioOrden(){;}

    public ServicioOrden(ServicioDeSalud id_serviciodesalud,OrdenDeServicio id_orden)
    {
        this.pk = new ServicioOrdenPK(id_serviciodesalud, id_orden);
    }

    public ServicioOrdenPK getPk() {
        return pk;
    }   

}
