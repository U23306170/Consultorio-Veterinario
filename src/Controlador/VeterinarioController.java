/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import ESTRUCTURAS.ListaDoble;
import ESTRUCTURAS.NodoDoble;
import MODELO.Veterinario;

/**
 *
 * @author User
 */
public class VeterinarioController {

    private final ListaDoble<Veterinario> veterinarios;
    private int proximoIdVeterinario;

    public VeterinarioController() {
        veterinarios = new ListaDoble<>();
        proximoIdVeterinario = 1;
    }

    /*Registra un veterinario cuando su id no existe en la lista(evita redundancia de datos)*/
    /**
     * Registra un veterinario cuando su identificador no existe en la lista.
     */
    public boolean registrarVeterinario(Veterinario veterinario) {
        if (veterinario == null
                || buscarVeterinarioPorId(veterinario.getIdVeterinario()) != null
                || buscarVeterinarioPorCmpv(veterinario.getCmpv()) != null) {
            return false;
        }

        veterinarios.insertar(veterinario);
        return true;
    }

    /**
     * Crea y registra un veterinario con identificador interno automatico.
     */
    public Veterinario registrarVeterinario(String cmpv, String nombre,
            String especialidad) {
        if (esTextoVacio(cmpv) || esTextoVacio(nombre)
                || esTextoVacio(especialidad)
                || buscarVeterinarioPorCmpv(cmpv) != null) {
            return null;
        }

        while (buscarVeterinarioPorId(proximoIdVeterinario) != null) {
            proximoIdVeterinario++;
        }

        Veterinario veterinario = new Veterinario(proximoIdVeterinario,
                cmpv.trim(), nombre.trim(), especialidad.trim());
        if (registrarVeterinario(veterinario)) {
            proximoIdVeterinario++;
            return veterinario;
        }
        return null;
    }

    /* Busca un veterinario por su id */
    public Veterinario buscarVeterinarioPorId(int idVeterinario) {
        NodoDoble<Veterinario> actual = veterinarios.getPrimero();
        while (actual != null) {
            Veterinario veterinario = actual.getDato();
            if (veterinario.getIdVeterinario() == idVeterinario) {
                return veterinario;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    /**
     * Busca un veterinario por su codigo profesional CMPV.
     */
    public Veterinario buscarVeterinarioPorCmpv(String cmpv) {
        if (esTextoVacio(cmpv)) {
            return null;
        }

        NodoDoble<Veterinario> actual = veterinarios.getPrimero();
        while (actual != null) {
            Veterinario veterinario = actual.getDato();
            if (cmpv.trim().equalsIgnoreCase(veterinario.getCmpv())) {
                return veterinario;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    /* Actualiza los datos editables del veterinario indicado(boton modificar).*/
    public boolean modificarVeterinario(int idVeterinario, String cmpv,
            String nombre, String especialidad) {
        Veterinario veterinario = buscarVeterinarioPorId(idVeterinario);
        if (veterinario == null) {
            return false;
        }

        veterinario.setCmpv(cmpv);
        veterinario.setNombre(nombre);
        veterinario.setEspecialidad(especialidad);
        return true;
    }

    public boolean eliminarVeterinario(int idVeterinario) {
        Veterinario veterinario = buscarVeterinarioPorId(idVeterinario);
        return veterinario != null && veterinarios.eliminar(veterinario);
    }

    public ListaDoble<Veterinario> getVeterinarios() {
        return veterinarios;
    }

    private boolean esTextoVacio(String texto) {
        return texto == null || texto.trim().isEmpty();
    }
}
