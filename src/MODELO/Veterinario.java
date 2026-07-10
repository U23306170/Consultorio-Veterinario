/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

/**
 *
 * @author User
 */
public class Veterinario {

    private int idVeterinario;
    private String cmpv;
    private String nombre;
    private String especialidad;

    public Veterinario(int idVeterinario, String cmpv, String nombre, String especialidad) {
        this.idVeterinario = idVeterinario;
        this.cmpv = cmpv;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public int getIdVeterinario() {
        return idVeterinario;
    }

    public void setIdVeterinario(int idVeterinario) {
        this.idVeterinario = idVeterinario;
    }

    public String getCmpv() {
        return cmpv;
    }

    public void setCmpv(String cmpv) {
        this.cmpv = cmpv;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
/*Simplemente cuando crees un historial utilizarás el veterinario de la cita.
    HistorialClinicoVeterinario h =
    new HistorialClinicoVeterinario(
        id,
        cita.getMascota(),
        cita.getVeterinario(),
        new Date(),
        diagnostico,
        observaciones,
        tratamiento
    );*/
}
