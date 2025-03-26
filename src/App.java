
import java.util.Iterator;

public class App {

    public static void main(String[] args) throws Exception {
        // Ejercicio 5 a)
        MySimpleLinkedList<Integer> miLista1D = new MySimpleLinkedList<>();
        miLista1D.insertFront(3);
        miLista1D.insertFront(1);
        miLista1D.insertFront(2);
        MySimpleLinkedList<Integer> miLista2D = new MySimpleLinkedList<>();
        miLista2D.insertFront(4);
        miLista2D.insertFront(1);
        miLista2D.insertFront(2);
        System.out.println(unirListasDesordenadas(miLista1D, miLista2D));
    }

    public static <T extends Comparable<T>> MySimpleLinkedList<T> unirListasDesordenadas(MySimpleLinkedList<T> l1,
            MySimpleLinkedList<T> l2) {
        MySimpleLinkedList<T> resultado = new MySimpleLinkedList<T>();

        Iterator<T> iter1 = l1.iterator();

        while (iter1.hasNext()) {
            T elemento = iter1.next();
            Iterator<T> iter2 = l2.iterator();
            while (iter2.hasNext()) {
                T elemento2 = iter2.next();
                if (elemento.equals(elemento2)) {
                    resultado.insertFront(elemento);
                    break;
                }
            }
        }
        resultado.sort();
        return resultado;
    }

    public static <T extends Comparable<T>> MySimpleLinkedList<T> unirListasOrdenadas(MySimpleLinkedList<T> l1,
            MySimpleLinkedList<T> l2) {
        MySimpleLinkedList<T> resultado = new MySimpleLinkedList<T>();

        Iterator<T> iter1 = l1.iterator();

        while (iter1.hasNext()) {
            T elemento = iter1.next();
            Iterator<T> iter2 = l2.iterator();
            while (iter2.hasNext()) {
                T elemento2 = iter2.next();
                if (elemento.equals(elemento2)) {
                    resultado.insertFront(elemento);
                    break;
                }
            }
        }

        return resultado;
    }
}
