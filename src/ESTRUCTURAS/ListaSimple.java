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
public class ListaSimple<T> {

    private Nodo<T> primero;

    public ListaSimple() {
        primero = null;
    }

    public boolean estaVacia() {
        return primero == null;
    }

    public void insertar(T dato) {

        Nodo<T> nuevo = new Nodo<>(dato);

        if (estaVacia()) {

            primero = nuevo;

        } else {

            Nodo<T> aux = primero;

            while (aux.getSiguiente() != null) {

                aux = aux.getSiguiente();

            }

            aux.setSiguiente(nuevo);

        }

    }

    public Nodo<T> getPrimero() {
        return primero;
    }

}