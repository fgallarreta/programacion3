package Practico2_1;

public class App2 {
    public static void main(String[] args) {
        Tree arbol = new Tree();
        arbol.add(5);// Raiz;
        arbol.add(4);
        arbol.add(8);
        arbol.add(9);
        arbol.add(6);
        arbol.add(10);
        arbol.add(3);
        arbol.add(2);
        arbol.add(1);
        arbol.add(7);
        System.out.println(arbol.getRoot());
        System.out.println(arbol.hasElem(12));
    }
}
