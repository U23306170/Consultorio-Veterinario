/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import ESTRUCTURAS.ListaDoble;
import ESTRUCTURAS.NodoDoble;
import MODELO.Mascota;
/**
 *
 * @author User
 */
public class MascotaController {

    private final ListaDoble<Mascota> mascotas;

    public MascotaController() {
        mascotas = new ListaDoble<>();
    }

    /**
     * Agrega una mascota a la lista doble de mascotas registradas.
     */
    public boolean registrarMascota(Mascota mascota) {
        if (mascota == null || buscarMascotaPorId(mascota.getIdMascota()) != null) {
            return false;
        }

        mascotas.insertar(mascota);
        return true;
    }

    /**
     * Busca una mascota mediante su identificador unico.
     */
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

    /**
     * Busca la primera mascota que coincide por nombre y especie.
     */
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

    /**
     * Modifica los datos de una mascota ya localizada.
     */
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

    public ListaDoble<Mascota> getMascotas() {
        return mascotas;
    }
}
