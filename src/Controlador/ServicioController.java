/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import MODELO.Servicio;

/**
 *
 * @author User
 */
public class ServicioController {

    private final Servicio[] servicios;

    public ServicioController() {
        servicios = new Servicio[]{
            new Servicio(1, "Consulta", 50.00),
            new Servicio(2, "Vacunacion", 80.00),
            new Servicio(3, "Baño", 35.00),
            new Servicio(4, "Cirugia", 450.00),
            new Servicio(5, "Desparasitacion", 40.00)
        };
    }

    /**
     * Devuelve una copia del arreglo para no exponer el catalogo interno.
     */
    public Servicio[] obtenerServicios() {
        Servicio[] copia = new Servicio[servicios.length];
        for (int i = 0; i < servicios.length; i++) {
            copia[i] = copiarServicio(servicios[i]);
        }
        return copia;
    }

    public Servicio buscarServicioPorId(int idServicio) {
        for (Servicio servicio : servicios) {
            if (servicio.getIdServicio() == idServicio) {
                return copiarServicio(servicio);
            }
        }
        return null;
    }

    private Servicio copiarServicio(Servicio servicio) {
        return new Servicio(servicio.getIdServicio(), servicio.getNombre(),
                servicio.getCosto());
    }
}
