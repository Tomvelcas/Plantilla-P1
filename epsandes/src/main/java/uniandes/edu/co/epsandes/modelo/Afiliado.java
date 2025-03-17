package uniandes.edu.co.epsandes.modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Afiliado")
public class Afiliado{
    private String tipo_documento;

    @Id
    private Integer numeroDocumento;

    private String nombre;

    private Date fecha_nacimiento;

    private String direccion;

    private Integer telefono;

    private String tipo_afiliado;

    @ManyToOne
    @JoinColumn(name = "documento_contribuyente", referencedColumnName = "numeroDocumento")
    private Afiliado contribuyente; 

    private String parentesco; 


    public Afiliado()
    {;}

    public Afiliado( String tipo_documento, Integer numero_documento, String nombre, Date fecha_nacimiento, String direccion, Integer telefono, String tipo_afiliado, Afiliado contribuyente, String parentesco)
    {
        this.tipo_documento = tipo_documento;
        this.numeroDocumento = numero_documento;
        this.nombre = nombre;
        this.fecha_nacimiento = fecha_nacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tipo_afiliado = tipo_afiliado;
        this.contribuyente = contribuyente;
        this.parentesco = parentesco;
    }

    private String getTipo_documento()
    {
        return tipo_documento;
    }

    private void setTipo_documento(String tipo_documento)
    {
        this.tipo_documento = tipo_documento;
    }

    private Integer getNumeroDocumento()
    {
        return numeroDocumento;
    }

    private String getNombre()
    {
        return nombre;
    }

    private void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    private Date getFecha_nacimiento()
    {
        return fecha_nacimiento;
    }

    private void setFecha_nacimiento(Date fecha_nacimiento)
    {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    private String getDireccion()
    {
        return direccion;
    }

    private void setDireccion(String direccion)
    {
        this.direccion = direccion;
    }

    private Integer getTelefono()
    {
        return telefono;
    }

    private void setTelefono(Integer telefono)
    {
        this.telefono = telefono;
    }

    private String getTipo_afiliado()
    {
        return tipo_afiliado;
    }

    private void setTipo_afiliado(String tipo_afiliado)
    {
        this.tipo_afiliado = tipo_afiliado;
    }

    private Afiliado getContribuyente()
    {
        return contribuyente;
    }

    private void setContribuyente(Afiliado contribuyente)
    {
        this.contribuyente = contribuyente;
    }

    private String getParentesco()
    {
        return parentesco;
    }

    private void setParentesco(String parentesco)
    {
        this.parentesco = parentesco;
    }


}

