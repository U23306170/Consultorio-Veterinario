/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

import java.util.Date;

/**
 *
 * @author User
 */
public class Cita {

    private int idCita;

    private RegistroTutor tutor;

    private Mascota mascota;

    private Veterinario veterinario;

    private Servicio servicio;

    private Pago pago;

    private Date fecha;

    private String hora;

    private String motivo;

    private String estado;

    public Cita(int idCita, RegistroTutor tutor, Mascota mascota, Veterinario veterinario, Servicio servicio, Pago pago, Date fecha, String hora, String motivo, String estado) {
        this.idCita = idCita;
        this.tutor = tutor;
        this.mascota = mascota;
        this.veterinario = veterinario;
        this.servicio = servicio;
        this.pago = pago;
        this.fecha = fecha;
        this.hora = hora;
        this.motivo = motivo;
        this.estado = estado;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public RegistroTutor getTutor() {
        return tutor;
    }

    public void setTutor(RegistroTutor tutor) {
        this.tutor = tutor;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}