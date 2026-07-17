/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import ESTRUCTURAS.ListaDoble;
import ESTRUCTURAS.NodoDoble;
import MODELO.Mascota;
import MODELO.RegistroTutor;

/**
 *
 * @author User
 */
public class MascotaController {

    private final ListaDoble<Mascota> mascotas;
    private int proximoIdMascota;

    public MascotaController() {
        mascotas = new ListaDoble<>();
        proximoIdMascota = 1;
    }

    /* Agrega una mascota a la lista doble de mascotas registradas */
    public boolean registrarMascota(Mascota mascota) {
        if (mascota == null || buscarMascotaPorId(mascota.getIdMascota()) != null) {
            return false;
        }

        mascotas.insertar(mascota);
        return true;
    }

    /**
     * Crea y registra una mascota con un identificador generado por el sistema.
     */
    public Mascota registrarMascota(RegistroTutor tutor, String nombre,
            String especie, String edad) {
        if (tutor == null || esTextoVacio(nombre) || esTextoVacio(especie)
                || esTextoVacio(edad)) {
            return null;
        }

        while (buscarMascotaPorId(proximoIdMascota) != null) {
            proximoIdMascota++;
        }

        Mascota mascota = new Mascota(proximoIdMascota, tutor, nombre.trim(),
                especie.trim(), edad.trim());
        if (registrarMascota(mascota)) {
            proximoIdMascota++;
            return mascota;
        }
        return null;
    }

    /* Busca una mascota mediante su identificador unico.*/
    public Mascota buscarMascotaPorId(int idMascota) {
        NodoDoble<Mascota> actual = mascotas.getPrimero();
        while (actual != null) {
            Mascota mascota = actual.getDato();
            if (mascota.getIdMascota() == idMascota) {
                return mascota;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    /* Busca la primera mascota que coincide por nombre y especie.*/
    public Mascota buscarMascota(String nombre, String especie) {
        if (nombre == null || especie == null) {
            return null;
        }

        NodoDoble<Mascota> actual = mascotas.getPrimero();
        while (actual != null) {
            Mascota mascota = actual.getDato();
            if (nombre.equalsIgnoreCase(mascota.getNombre())
                    && especie.equalsIgnoreCase(mascota.getEspecie())) {
                return mascota;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    /*Modifica los datos de una mascota ya buscada y localizada.*/
    public boolean modificarMascota(Mascota mascota, String nombre,
            String especie, String edad) {
        if (mascota == null) {
            return false;
        }

        mascota.setNombre(nombre);
        mascota.setEspecie(especie);
        mascota.setEdad(edad);
        return true;
    }

    public String listarMascotas() {

        StringBuilder sb = new StringBuilder();

        NodoDoble<Mascota> actual = mascotas.getPrimero();

        while (actual != null) {

            Mascota m = actual.getDato();

            sb.append("ID: ")
                    .append(m.getIdMascota())
                    .append("\nTutor: ")
                    .append(m.getTutor().getNombre())
                    .append(" ")
                    .append(m.getTutor().getApellidoPaterno())
                    .append("\nNombre: ")
                    .append(m.getNombre())
                    .append("\nEspecie: ")
                    .append(m.getEspecie())
                    .append("\nEdad: ")
                    .append(m.getEdad())
                    .append("\n---------------------------\n");

            actual = actual.getSiguiente();
        }
        if (sb.length() == 0) {
            return "No existen mascotas registradas.";
        }
        return sb.toString();
    }

    public String listarMascotasDelTutor(RegistroTutor tutor) {

        if (tutor == null) {
            return "Tutor no encontrado.";
        }

        StringBuilder sb = new StringBuilder();

        NodoDoble<Mascota> actual = mascotas.getPrimero();

        while (actual != null) {

            Mascota mascota = actual.getDato();

            if (mascota.getTutor() != null
                    && tutor.getDni().equals(mascota.getTutor().getDni())) {

                sb.append(describirMascota(mascota))
                        .append("\n\n");
            }

            actual = actual.getSiguiente();
        }

        if (sb.length() == 0) {
            return "No hay mascotas registradas para este tutor.";
        }

        return sb.toString();
    }

    public String describirMascota(Mascota mascota) {

        if (mascota == null) {
            return "Mascota no encontrada.";
        }

        return "ID: " + mascota.getIdMascota()
                + "\nNombre: " + mascota.getNombre()
                + "\nEspecie: " + mascota.getEspecie()
                + "\nEdad: " + mascota.getEdad();
    }

    public ListaDoble<Mascota> getMascotas() {
        return mascotas;
    }

    /* Elimina una mascota identificada por su codigo unico.*/
    public boolean eliminarMascota(int idMascota) {
        Mascota mascota = buscarMascotaPorId(idMascota);
        return mascota != null && mascotas.eliminar(mascota);
    }

    private boolean esTextoVacio(String texto) {
        return texto == null || texto.trim().isEmpty();
    }
}
