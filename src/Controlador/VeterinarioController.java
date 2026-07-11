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

    public VeterinarioController() {
        veterinarios = new ListaDoble<>();
    }

    /*Registra un veterinario cuando su id no existe en la lista(evita redundancia de datos)*/
    public boolean registrarVeterinario(Veterinario veterinario) {
        if (veterinario == null
                || buscarVeterinarioPorId(veterinario.getIdVeterinario()) != null) {
            return false;
        }

        veterinarios.insertar(veterinario);
        return true;
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

    public ListaDoble<Veterinario> getVeterinarios() {
        return veterinarios;
    }
}
