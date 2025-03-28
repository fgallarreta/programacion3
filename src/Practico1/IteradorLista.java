package Practico1;

import java.util.Iterator;

public class IteradorLista<T> implements Iterator<T> {

    private Node<T> nodoActual;

    public IteradorLista(Node<T> first) {
        nodoActual = first;
    }

    @Override
    public boolean hasNext() {
        return nodoActual != null;
    }

    @Override
    public T next() {
        T valor = nodoActual.getInfo();
        nodoActual.getNext();
        return valor;
    }
}
