/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ESTRUCTURAS;

/**
 *
 * @author User
 * @param <T>
 */

public class ListaDoble<T> {

    private NodoDoble<T> primero;
    private NodoDoble<T> ultimo;

    public ListaDoble() {
        primero = null;
        ultimo = null;

    }

    public boolean estaVacia() {
        return primero == null;
    }

    public void insertar(T dato) {

        NodoDoble<T> nuevo = new NodoDoble<>(dato);

        if (estaVacia()) {

            primero = nuevo;
            ultimo = nuevo;

        } else {

            ultimo.setSiguiente(nuevo);
            nuevo.setAnterior(ultimo);
            ultimo = nuevo;

        }

    }

    public NodoDoble<T> getPrimero() {
        return primero;
    }

    public NodoDoble<T> getUltimo() {
        return ultimo;
    }

}