package uniandes.edu.co.epsandes.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Ips")
public class Ips {

    @Id
    private Integer nit;
    private String nombre;
    private String direccion;
    private Integer telefono;
    
    public Ips() {;}

    public Ips(Integer nit, String nombre, String direccion, Integer telefono) {
        this.nit = nit;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Integer getNit() {
        return nit;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public Integer getTelefono() {
        return telefono;
    
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }
    
}
