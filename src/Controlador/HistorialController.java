/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import ESTRUCTURAS.ListaSimple;
import ESTRUCTURAS.Nodo;
import MODELO.HistorialClinicoVeterinario;
/**
 *
 * @author User
 */
public class HistorialController {

    private final ListaSimple<HistorialClinicoVeterinario> historiales;

    public HistorialController() {
        historiales = new ListaSimple<>();
    }

    /*Agrega una nueva atencion al final del historial clinico. Los historiales no se modifican ni eliminan despues de registrarse.*/
    public boolean registrarHistorial(HistorialClinicoVeterinario historial) {
        if (historial == null
                || buscarHistorialPorId(historial.getIdHistorial()) != null) {
            return false;
        }

        historiales.insertar(historial);
        return true;
    }

    /* Busca una atencion clinica por su identificador unico (idHCV)*/
    public HistorialClinicoVeterinario buscarHistorialPorId(int idHistorial) {
        Nodo<HistorialClinicoVeterinario> actual = historiales.getPrimero();
        while (actual != null) {
            HistorialClinicoVeterinario historial = actual.getDato();
            if (historial.getIdHistorial() == idHistorial) {
                return historial;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    public ListaSimple<HistorialClinicoVeterinario> getHistoriales() {
        return historiales;
    }

    public int siguienteIdHistorial() {
        int mayorId = 0;
        Nodo<HistorialClinicoVeterinario> actual = historiales.getPrimero();
        while (actual != null) {
            mayorId = Math.max(mayorId, actual.getDato().getIdHistorial());
            actual = actual.getSiguiente();
        }
        return mayorId + 1;
    }

    public HistorialClinicoVeterinario obtenerHistorialReciente() {
        Nodo<HistorialClinicoVeterinario> actual = historiales.getPrimero();
        HistorialClinicoVeterinario reciente = null;
        while (actual != null) {
            reciente = actual.getDato();
            actual = actual.getSiguiente();
        }
        return reciente;
    }
}

