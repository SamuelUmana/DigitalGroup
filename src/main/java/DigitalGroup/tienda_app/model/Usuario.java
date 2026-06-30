package DigitalGroup.tienda_app.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import lombok.ToString;


@Data 
@EqualsAndHashCode
@AllArgsConstructor
@ToString
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @Column(name = "id_usuario")
    private String idUsuario;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "correo")
    private String correo;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro = LocalDateTime.now();

    @Column(name = "nombreTienda")
    private String nombreTienda;

    @Column(name = "ubicacion")
    private String ubicacion;

    public Usuario(){}

    

    public Usuario(String nombre, String correo, LocalDateTime fechaRegistro, String nombreTienda, String ubicacion) {
        this.nombre = nombre;
        this.correo = correo;
        this.fechaRegistro = fechaRegistro;
        this.nombreTienda = nombreTienda;
        this.ubicacion = ubicacion;
    }



    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getNombreTienda() { return nombreTienda; }

    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    
    
    
}
