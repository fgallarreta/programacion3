package Practico1;

import java.util.Iterator;

public class App {

    public static void main(String[] args) throws Exception {
        // Ejercicio 5 a)
        MySimpleLinkedList<Integer> miLista1D = new MySimpleLinkedList<>();
        miLista1D.insertFront(1);
        miLista1D.insertFront(3);
        miLista1D.insertFront(2);
        MySimpleLinkedList<Integer> miLista2D = new MySimpleLinkedList<>();
        miLista2D.insertFront(4);
        miLista2D.insertFront(1);
        miLista2D.insertFront(2);

        System.out.println(unirListasDesordenadas(miLista1D, miLista2D));
        System.out.println(listaElementosSoloEnL1(miLista1D, miLista2D));
    }

    public static <T extends Comparable<T>> MySimpleLinkedList<T> unirListasDesordenadas(MySimpleLinkedList<T> l1,
            MySimpleLinkedList<T> l2) {
        MySimpleLinkedList<T> resultado = new MySimpleLinkedList<>();
        Iterator<T> iter1 = l1.iterator();
        int i = 0;

        while (i < l1.size()) {
            T elemento = iter1.next();
            Iterator<T> iter2 = l2.iterator();

            while (iter2.hasNext()) {
                T elemento2 = iter2.next();
                if (elemento == elemento2) {
                    resultado.insertFront(elemento);
                }

            }
            if (!iter2.hasNext()) {
                T ultimoElemento = iter2.next();
                if (elemento == ultimoElemento) {
                    resultado.insertFront(elemento);
                }
            }
            i++;

        }
        resultado.sort();
        return resultado;
    }

    public static <T extends Comparable<T>> MySimpleLinkedList<T> unirListasOrdenadas(MySimpleLinkedList<T> l1,
            MySimpleLinkedList<T> l2) {
        MySimpleLinkedList<T> resultado = new MySimpleLinkedList<T>();
        Iterator<T> iter1 = l1.iterator();
        int i = 0;

        while (i < l1.size()) {
            T elemento = iter1.next();
            Iterator<T> iter2 = l2.iterator();

            while (iter2.hasNext()) {
                T elemento2 = iter2.next();
                if (elemento == elemento2) {
                    resultado.insertFront(elemento);
                }

            }
            if (!iter2.hasNext()) {
                T ultimoElemento = iter2.next();
                if (elemento == ultimoElemento) {
                    resultado.insertFront(elemento);
                }
            }
            i++;

        }

        return resultado;
    }

    // Ejercicio 6

    public static <T extends Comparable<T>> MySimpleLinkedList<T> listaElementosSoloEnL1(MySimpleLinkedList<T> l1,
            MySimpleLinkedList<T> l2) {
        MySimpleLinkedList<T> aux = new MySimpleLinkedList<>();
        Iterator<T> iter1 = l1.iterator();
        int i = 0;
        while (i < l1.size()) {
            T elemento = iter1.next();
            Iterator<T> iter2 = l2.iterator();
            boolean noRepetido = true;
            while (iter2.hasNext()) {
                T elemento2 = iter2.next();
                if (elemento == elemento2) {
                    noRepetido = false;

                }
                if (!iter2.hasNext()) {
                    T ultimoElemento = elemento2;
                    if (elemento == ultimoElemento) {
                        noRepetido = false;
                    }
                }

            }
            if (noRepetido) {
                aux.insertFront(elemento);
            }
            i++;
        }
        return aux;
    }

}
