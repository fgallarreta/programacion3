package Practico2_1;

public class App2 {
    public static void main(String[] args) {
        Tree arbol = new Tree();
        arbol.add(6);// Raiz;
        arbol.add(2);
        arbol.add(10);
        arbol.add(1);
        arbol.add(4);
        arbol.add(8);
        arbol.add(11);
        arbol.add(7);
        arbol.add(9);

        System.out.println(arbol.getRoot());
        System.out.println(arbol.hasElem(10));
        System.out.println(arbol.isEmpty());
        System.out.println(arbol.getSumaNodosInternos());
        System.out.println(arbol.getListaHojasMayor(8));
    }

}
