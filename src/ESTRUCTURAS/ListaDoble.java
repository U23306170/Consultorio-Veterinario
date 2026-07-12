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
    
    /**
     * Elimina la primera coincidencia del dato indicado y conserva los enlaces
     * anterior y siguiente de la lista doble.
     */
    public boolean eliminar(T dato) {
        NodoDoble<T> actual = primero;

        while (actual != null) {
            if (actual.getDato() == dato || (dato != null && dato.equals(actual.getDato()))) {
                NodoDoble<T> anterior = actual.getAnterior();
                NodoDoble<T> siguiente = actual.getSiguiente();

                if (anterior == null) {
                    primero = siguiente;
                } else {
                    anterior.setSiguiente(siguiente);
                }

                if (siguiente == null) {
                    ultimo = anterior;
                } else {
                    siguiente.setAnterior(anterior);
                }
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    public NodoDoble<T> getPrimero() {
        return primero;
    }

    public NodoDoble<T> getUltimo() {
        return ultimo;
    }

}