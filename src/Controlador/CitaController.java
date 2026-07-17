/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import ESTRUCTURAS.Cola;
import ESTRUCTURAS.ListaDoble;
import ESTRUCTURAS.NodoDoble;
import MODELO.Cita;
import MODELO.HistorialClinicoVeterinario;
import MODELO.Pago;
import MODELO.Servicio;
import MODELO.Tratamiento;
import MODELO.Veterinario;
import MODELO.RegistroTutor;
import MODELO.Mascota;
import java.util.Date;

/**
 *
 * @author User
 */
public class CitaController {

    private final ListaDoble<Cita> citas;
    private final Cola colaAtencion;
    private final HistorialController historialController;
    private int proximoIdCita = 1;
    private int proximoIdPago = 1;

    public CitaController(HistorialController historialController) {
        this.citas = new ListaDoble<>();
        this.colaAtencion = new Cola();
        this.historialController = historialController;
    }

    /*Registra una cita y conserva en su pago el costo vigente del servicio que se ingresara en el JcomboBox de la vista.*/
    public boolean registrarCita(Cita cita) {
        if (cita == null || cita.getTutor() == null || cita.getMascota() == null
                || cita.getVeterinario() == null || cita.getServicio() == null
                || cita.getPago() == null
                || buscarCitaPorId(cita.getIdCita()) != null) {
            return false;
        }

        cita.getPago().setMonto(cita.getServicio().getCosto());
        cita.setEstado("REGISTRADA");
        citas.insertar(cita);
        return true;
    }

    /*Crea, registra y encola una cita con IDs internos automaticos*/
    public Cita registrarNuevaCita(RegistroTutor tutor, Mascota mascota,
            Veterinario veterinario, Servicio servicio, Date fecha, String hora,
            String motivo, String estadoPago, String metodoPago) {
        if (tutor == null || mascota == null || veterinario == null
                || servicio == null || fecha == null || esVacio(hora)
                || esVacio(motivo)) {
            return null;
        }
        while (buscarCitaPorId(proximoIdCita) != null) {
            proximoIdCita++;
        }
        Pago pago = new Pago(proximoIdPago++, servicio.getCosto(), estadoPago,
                metodoPago);
        Cita cita = new Cita(proximoIdCita++, tutor, mascota, veterinario,
                servicio, pago, fecha, hora.trim(), motivo.trim(), "REGISTRADA");
        if (!registrarCita(cita) || !encolarCita(cita.getIdCita())) {
            return null;
        }
        return cita;
    }

    public Cita buscarCitaPorId(int idCita) {
        NodoDoble<Cita> actual = citas.getPrimero();
        while (actual != null) {
            Cita cita = actual.getDato();
            if (cita.getIdCita() == idCita) {
                return cita;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    public Cita buscarCitaPorDniTutor(String dni) {
        NodoDoble<Cita> actual = citas.getPrimero();
        while (actual != null) {
            Cita cita = actual.getDato();
            if (cita.getTutor().getDni().equals(dni)) {
                return cita;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    /* Modifica los datos de una cita que aun no ha sido atendida por veterinario en el boton de Citas*/
    public boolean modificarCita(int idCita, Veterinario veterinario,
            Servicio servicio, Pago pago, Date fecha, String hora, String motivo) {
        Cita cita = buscarCitaPorId(idCita);
        if (cita == null || "ATENDIDA".equals(cita.getEstado())
                || veterinario == null || servicio == null || pago == null) {
            return false;
        }

        cita.setVeterinario(veterinario);
        cita.setServicio(servicio);
        cita.setPago(pago);
        cita.getPago().setMonto(servicio.getCosto());
        cita.setFecha(fecha);
        cita.setHora(hora);
        cita.setMotivo(motivo);
        return true;
    }

    /*encolar coolocar una cita registrada al final de la cola de atencion para simular una atencion n el consultorio. */
    public boolean encolarCita(int idCita) {
        Cita cita = buscarCitaPorId(idCita);
        if (cita == null || "ATENDIDA".equals(cita.getEstado())
                || estaEnCola(idCita)) {
            return false;
        }

        colaAtencion.encolar(cita);
        cita.setEstado("EN COLA");
        return true;
    }

    /*atiende la primera cita de la cola y registra su historial clinico.*/
    public boolean atenderSiguienteCita(int idHistorial, String diagnostico,
            String observaciones, Tratamiento tratamiento) {
        if (historialController == null
                || historialController.buscarHistorialPorId(idHistorial) != null) {
            return false;
        }

        Cita cita = colaAtencion.frente();
        if (cita == null) {
            return false;
        }

        HistorialClinicoVeterinario historial
                = new HistorialClinicoVeterinario(idHistorial, cita.getMascota(),
                        cita.getVeterinario(), new Date(), diagnostico,
                        observaciones, tratamiento);

        if (!historialController.registrarHistorial(historial)) {
            return false;
        }

        colaAtencion.desencolar();
        cita.setEstado("ATENDIDA");
        return true;
    }

    public boolean atenderSiguienteCita(String diagnostico, String observaciones,
            Tratamiento tratamiento) {
        return atenderSiguienteCita(historialController.siguienteIdHistorial(),
                diagnostico, observaciones, tratamiento);
    }

    /* Elimina la cita del registro y, si existe, de la cola de atencion*/
    public boolean eliminarCita(int idCita) {
        Cita cita = buscarCitaPorId(idCita);
        if (cita == null) {
            return false;
        }
        colaAtencion.eliminarPorIdCita(idCita);
        return citas.eliminar(cita);
    }

    public Cita obtenerSiguienteCita() {
        return colaAtencion.frente();
    }

    private boolean estaEnCola(int idCita) {
        for (Cita cita : colaAtencion.obtenerCola()) {
            if (cita.getIdCita() == idCita) {
                return true;
            }
        }
        return false;
    }

    public ListaDoble<Cita> getCitas() {
        return citas;
    }

    public Cola getColaAtencion() {
        return colaAtencion;
    }

    private boolean esVacio(String texto) {
        return texto == null || texto.trim().isEmpty();
    }
}
