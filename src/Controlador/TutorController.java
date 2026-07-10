/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import ESTRUCTURAS.ListaDoble;
import ESTRUCTURAS.NodoDoble;
import MODELO.RegistroTutor;

/**
 *
 * @author User
 */
public class TutorController {

    private final ListaDoble<RegistroTutor> tutores;

    public TutorController() {
        tutores = new ListaDoble<>();
    }

    /**
     * Registra un tutor si el DNI aun no pertenece a otro tutor.
     *
     * @return true cuando el registro se realiza; false si el DNI ya existe.
     */
    public boolean registrarTutor(RegistroTutor tutor) {
        if (tutor == null || buscarTutorPorDni(tutor.getDni()) != null) {
            return false;
        }

        tutores.insertar(tutor);
        return true;
    }

    /**
     * Busca un tutor recorriendo la lista doble desde el primer nodo.
     */
    public RegistroTutor buscarTutorPorDni(String dni) {
        if (dni == null) {
            return null;
        }

        NodoDoble<RegistroTutor> actual = tutores.getPrimero();
        while (actual != null) {
            RegistroTutor tutor = actual.getDato();
            if (dni.equals(tutor.getDni())) {
                return tutor;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    /**
     * Actualiza los datos editables de un tutor ya registrado.
     */
    public boolean modificarTutor(String dni, String nombre,
            String apellidoPaterno, String apellidoMaterno, String telefono) {
        RegistroTutor tutor = buscarTutorPorDni(dni);
        if (tutor == null) {
            return false;
        }

        tutor.setNombre(nombre);
        tutor.setApellidoPaterno(apellidoPaterno);
        tutor.setApellidoMaterno(apellidoMaterno);
        tutor.setTelefono(telefono);
        return true;
    }

    public ListaDoble<RegistroTutor> getTutores() {
        return tutores;
    }
}
