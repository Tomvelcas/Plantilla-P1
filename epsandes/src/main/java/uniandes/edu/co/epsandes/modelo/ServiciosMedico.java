package uniandes.edu.co.epsandes.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="ServiciosMedico")
public class ServiciosMedico {

    @EmbeddedId
    private ServiciosMedicoPK pk;

    public ServiciosMedico(){;}

    public ServiciosMedico(Medico numeroDocumento, ServicioDeSalud id_serviciodesalud)
    {
        this.pk = new ServiciosMedicoPK(numeroDocumento, id_serviciodesalud);
    }

    public ServiciosMedicoPK getPk() {
        return pk;
    }

}
