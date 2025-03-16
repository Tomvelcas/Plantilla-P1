package uniandes.edu.co.epsandes.modelo;
import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ServiciosMedicoPK implements Serializable {
 
    @ManyToOne
    @JoinColumn(name="medico_numerodocumento", referencedColumnName="numeroDocumento")
    private Medico medico_numerodocumento;

    @ManyToOne
    @JoinColumn(name = "id_serviciodesalud", referencedColumnName = "id")
    private ServicioDeSalud id_serviciodesalud;


    public ServiciosMedicoPK()
    {
        super();
    }

    public ServiciosMedicoPK( Medico medico_numerodocumento, ServicioDeSalud id_serviciodesalud)
    {
        super();
        this.medico_numerodocumento = medico_numerodocumento;
        this.id_serviciodesalud = id_serviciodesalud;

    }

    public ServicioDeSalud getId_servicioDeSalud() {
        return id_serviciodesalud;
    }

    public Medico getnumeroDocumentoMedico() {
        return medico_numerodocumento;
    }


}
