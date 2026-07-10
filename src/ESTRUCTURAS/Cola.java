/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ESTRUCTURAS;
import MODELO.Cita;
import java.util.LinkedList;
import java.util.Queue;
/**
 *
 * @author User
 */


public class Cola {

    private Queue<Cita> cola;

    public Cola() {
        cola = new LinkedList<>();
    }

    // Agrega una cita al final de la cola
    public void encolar(Cita cita) {
        cola.offer(cita);
    }

    // Atiende la primera cita
    public Cita desencolar() {
        return cola.poll();
    }

    // Muestra la siguiente cita
    public Cita frente() {
        return cola.peek();
    }

    public boolean estaVacia() {
        return cola.isEmpty();
    }

    public int tamano() {
        return cola.size();
    }

    public Queue<Cita> obtenerCola() {
        return cola;
    }
}
/*cola.offer(cita1);
cola.offer(cita2);
cola.offer(cita3);

Nodo
 │
 ▼
Nodo
 │
 ▼
Nodo*/

