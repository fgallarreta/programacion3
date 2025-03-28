package Practico1;

import java.util.Iterator;

public class MySimpleLinkedList<T extends Comparable<T>> implements Iterable<T> {

    private Node<T> first;
    private int size;

    public MySimpleLinkedList() {
        this.first = null;
        this.size = 0;
    }

    public void insertFront(T info) {
        Node<T> tmp = new Node<T>(info, null);
        tmp.setNext(this.first);
        this.first = tmp;
        this.size++;
    }

    public T extractFront() {
        if (this.isEmpty()) {
            return null;
        }
        T prim = this.first.getInfo();
        this.first = this.first.getNext();
        this.size--;
        return prim;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public T get(int index) {
        int i = 0;
        Node<T> aux = this.first;
        if (index < this.size) {

            while (i < index) {
                if (index == 0) {
                    return aux.getInfo();
                } else {
                    aux = aux.getNext();
                }
                i++;
            }
        } else {
            return null;
        }

        return aux.getInfo();
    }

    public int size() {
        return this.size;
    }

    public int indexOf(T elemento) {
        int salida = -1;
        for (int i = 0; i < this.size; i++) {
            if (elemento == get(i))
                salida = i;
        }
        return salida;
    }

    public void sort() {
        Node<T> sorted = null; // Lista ordenada (inicialmente vacía)
        Node<T> current = this.first;

        // Recorremos la lista original
        while (current != null) {
            Node<T> next = current.getNext(); // Guardamos el siguiente nodo
            current.setNext(null); // Desconectamos el nodo para insertarlo de forma ordenada

            // Insertamos el nodo de forma ordenada en la lista 'sorted'
            if (sorted == null || sorted.getInfo().compareTo(current.getInfo()) >= 0) {
                // Si la lista ordenada está vacía o el valor es menor que el primero
                current.setNext(sorted);
                sorted = current; // El nodo se convierte en el nuevo primer nodo
            } else {
                Node<T> temp = sorted;
                while (temp.getNext() != null && temp.getNext().getInfo().compareTo(current.getInfo()) < 0) {
                    temp = temp.getNext(); // Buscamos la posición correcta
                }
                current.setNext(temp.getNext());
                temp.setNext(current); // Insertamos el nodo en la lista ordenada
            }

            current = next; // Avanzamos al siguiente nodo
        }

        this.first = sorted; // La lista original ahora apunta a la lista ordenada
    }

    @Override
    public String toString() {
        String aux = "";
        for (int i = 0; i < this.size; i++) {
            aux += " " + this.get(i);
        }
        return aux;
    }

    @Override
    public Iterator<T> iterator() {
        return new IteradorLista<>(this.first);
    }

}
