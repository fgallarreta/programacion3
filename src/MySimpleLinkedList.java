import java.util.Iterator;

public class MySimpleLinkedList<T> implements Iterable<T> {

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
