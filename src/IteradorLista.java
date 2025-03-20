import java.util.Iterator;

public class IteradorLista<T> implements Iterator<T> {
    private Node<T> nodoIterado;

    public IteradorLista(Node<T> nodo) {
        nodoIterado = nodo;
    }

    @Override
    public boolean hasNext() {
        return nodoIterado.getNext() != null;
    }

    @Override
    public T next() {
        T valor = nodoIterado.getInfo();
        this.nodoIterado = this.nodoIterado.getNext();
        return valor;
    }

}
