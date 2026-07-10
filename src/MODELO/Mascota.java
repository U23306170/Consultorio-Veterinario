/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

/**
 *
 * @author User
 */
public class Mascota {
    private final int idMascota;
    private String nombre;
    private String especie;
    private String edad;

    public Mascota(int idMascota, String nombre, String especie, String edad) {
        this.idMascota = idMascota;
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public String getEdad() {
        return edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }
    
}