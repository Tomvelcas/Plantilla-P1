package uniandes.edu.co.epsandes.modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import uniandes.edu.co.epsandes.modelo.Medico;

@Entity
@Table(name="RegistroMedico")
public class RegistroMedico {
    
    private Integer numeroRegistroMedico;

    public RegistroMedico() {;}

    public RegistroMedico(Integer numeroRegistroMedico) {
        this.numeroRegistroMedico = numeroRegistroMedico;
    }
    private Medico id_medico;

}