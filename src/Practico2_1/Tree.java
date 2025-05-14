package Practico2_1;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    private TreeNode root;

    public Tree() {
        this.root = null;
    }

    public void add(Integer value) {
        if (this.root == null)
            this.root = new TreeNode(value);
        else
            this.add(this.root, value);
    }

    private void add(TreeNode actual, Integer value) {
        if (actual.getValue() > value) {
            if (actual.getLeft() == null) {
                TreeNode temp = new TreeNode(value);
                actual.setLeft(temp);
            } else {
                add(actual.getLeft(), value);
            }
        } else if (actual.getValue() < value) {
            if (actual.getRight() == null) {
                TreeNode temp = new TreeNode(value);
                actual.setRight(temp);
            } else {
                add(actual.getRight(), value);
            }
        }
    }

    public Integer getRoot() {
        if (this.root == null)
            return null;
        else
            return this.root.getValue();

    }

    public boolean hasElem(Integer value) {
        if (this.getRoot() == null)
            return false;

        if (value < this.getRoot()) {
            TreeNode hijoIzq = this.root.getLeft();
            return buscarElemhijos(hijoIzq, value);
        } else if (value > this.getRoot()) {
            TreeNode hijoDer = this.root.getRight();
            return buscarElemhijos(hijoDer, value);
        } else {
            return true;
        }
    }

    private boolean buscarElemhijos(TreeNode hijo, Integer value) {

        if (hijo.getValue() < value) {
            TreeNode hijoDer = hijo.getRight();
            if (hijoDer != null)
                return buscarElemhijos(hijoDer, value);
            else
                return false;
        } else if (hijo.getValue() > value) {
            TreeNode hijoIzq = hijo.getLeft();
            if (hijoIzq != null)
                return buscarElemhijos(hijoIzq, value);
            else
                return false;

        } else
            return true;

    }

    public boolean isEmpty() {
        return this.getRoot() == null;

    }

    public boolean delete(Integer value) {
        if (value != null) {
            this.root = borrar(value, this.root);
            return true;
        }
        return false;
    }

    private TreeNode borrar(Integer value, TreeNode elem) {
        if (value < elem.getValue()) {
            elem.setLeft(borrar(value, elem.getLeft()));
        } else if (value > elem.getValue()) {
            elem.setRight(borrar(value, elem.getRight()));
        } else {
            if (elem.getLeft() == null) {
                return elem.getRight();
            } else if (elem.getRight() == null) {
                return elem.getLeft();
            }
            TreeNode minValorNodo = minValorNodo(elem.getRight());
            elem.setValue(minValorNodo.getValue());
            elem.setRight(borrar(minValorNodo.getValue(), elem.getRight()));
        }
        return elem;
    }

    private TreeNode minValorNodo(TreeNode nodo) {
        TreeNode current = nodo;

        while (current.getLeft() != null) {
            current = current.getLeft();
        }

        return current;
    }

    public int getHeight() {
        return getHeight(this.root);
    }

    private int getHeight(TreeNode nodo) {
        if (nodo == null) {
            return 0;
        } else {
            int leftHeight = getHeight(nodo.getLeft());
            int rightHeight = getHeight(nodo.getRight());

            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public void printPosOrder() {
        printPosOrder(this.root);
        System.out.println();
    }

    private void printPosOrder(TreeNode node) {
        if (node != null) {
            printPosOrder(node.getLeft());
            printPosOrder(node.getRight());
            System.out.print(node.getValue() + " ");
        }
    }

    public void printPreOrder() {
        printPreOrder(this.root);
        System.out.println();
    }

    private void printPreOrder(TreeNode node) {
        if (node != null) {
            System.out.print(node.getValue() + " ");
            printPreOrder(node.getLeft());
            printPreOrder(node.getRight());
        }
    }

    public void printInOrder() {
        printInOrder(this.root);
        System.out.println();
    }

    private void printInOrder(TreeNode node) {
        if (node != null) {
            printInOrder(node.getLeft());
            System.out.print(node.getValue() + " ");
            printInOrder(node.getRight());
        }
    }

    // La complejidad es O(n), ya que recorre todos los nodos del árbol.
    public List<Integer> getLongestBranch() {
        List<Integer> longestBranch = new ArrayList<>();
        List<Integer> currentBranch = new ArrayList<>();
        getLongestBranch(root, longestBranch, currentBranch, 0);
        return longestBranch;
    }

    private void getLongestBranch(TreeNode node, List<Integer> longestBranch, List<Integer> currentBranch,
            int level) {
        if (node != null) {
            currentBranch.add(node.getValue());

            if (node.getLeft() == null && node.getRight() == null) {
                if (currentBranch.size() > longestBranch.size()) {
                    longestBranch.clear();
                    longestBranch.addAll(currentBranch);
                }
            } else {
                getLongestBranch(node.getLeft(), longestBranch, currentBranch, level + 1);
                getLongestBranch(node.getRight(), longestBranch, currentBranch, level + 1);
            }

            currentBranch.remove(currentBranch.size() - 1);
        }
    }

    // La complejidad es O(n), ya que recorre todos los nodos del árbol.
    public List<Integer> getFrontera() {
        List<Integer> frontera = new ArrayList<>();
        getFrontera(this.root, frontera);
        return frontera;
    }

    private void getFrontera(TreeNode node, List<Integer> frontera) {
        if (node != null) {
            if (node.getLeft() == null && node.getRight() == null) {
                frontera.add(node.getValue());
            }

            getFrontera(node.getLeft(), frontera);
            getFrontera(node.getRight(), frontera);
        }
    }

    // La complejidad es O(h) en el peor caso, ya que desciende por la rama derecha
    // del árbol hasta
    // llegar al nodo más a la derecha.
    public Integer getMaxElem() {
        if (this.root == null) {
            return null;
        }

        TreeNode current = this.root;

        while (current.getRight() != null) {
            current = current.getRight();
        }

        return current.getValue();
    }

    // En el peor de los casos, la complejidad es O(n), ya que recorre todos los
    // nodos del árbol
    // hasta encontrar el nivel dado.
    public List<Integer> getElemAtLevel(int level) {
        List<Integer> elements = new ArrayList<>();
        getElemAtLevel(this.root, level, elements, 1);
        return elements;
    }

    private void getElemAtLevel(TreeNode node, int level, List<Integer> elements, int currentLevel) {
        if (node != null) {
            if (currentLevel == level) {
                elements.add(node.getValue());
            } else {
                getElemAtLevel(node.getLeft(), level, elements, currentLevel + 1);
                getElemAtLevel(node.getRight(), level, elements, currentLevel + 1);
            }
        }
    }

    public int getSumaNodosInternos() {
        return sumaNodosInternos(this.root);
    }

    private int sumaNodosInternos(TreeNode nodo) {
        if (nodo == null || (nodo.getLeft() == null && nodo.getRight() == null)) {
            return 0;
        }
        return nodo.getValue() + sumaNodosInternos(nodo.getLeft()) + sumaNodosInternos(nodo.getRight());
    }

    public List<Integer> getListaHojasMayor(int k) {
        return getListaHojasMayor(this.root, k);
    }

    private List<Integer> getListaHojasMayor(TreeNode nodo, int k) {
        List<Integer> hojas = new ArrayList<>();
        if (nodo.getValue() <= k || nodo.getLeft() != null || nodo.getRight() != null) {
            if (nodo.getLeft() != null) {
                hojas.addAll(getListaHojasMayor(nodo.getLeft(), k));
            }
            if (nodo.getRight() != null) {

                hojas.addAll(getListaHojasMayor(nodo.getRight(), k));
            }

        } else if (nodo.getLeft() == null && nodo.getRight() == null && nodo.getValue() > k) {
            hojas.add(nodo.getValue());
        }
        return hojas;
    }

    public void completarArbol() {
        completarArbol(this.root);
    }

    private void completarArbol(TreeNode nodo) {
        if (nodo.getValue() == null) {
            int leftValue = 0;
            int rightValue = 0;

            if (nodo.getLeft() != null) {
                completarArbol(nodo.getLeft());
                leftValue = nodo.getLeft().getValue();
            }

            if (nodo.getRight() != null) {
                completarArbol(nodo.getRight());
                rightValue = nodo.getRight().getValue();
            }

            nodo.setValue(rightValue - leftValue);
        }

    }

    public List<String> getPalabrasByVocales(int n) {
        List<String> palabras = new ArrayList<>();
        getPalabrasByVocales(this.root, "", palabras, n);
        return palabras;
    }

    private void getPalabrasByVocales(TreeNode nodo, String palabra, List<String> palabras, int n) {
        if (nodo != null) {
            String Npalabra = palabra + nodo.getValue();
            if (nodo.getLeft() == null && nodo.getRight() == null) {
                if (contarVocal(Npalabra) == n) {
                    palabras.add(Npalabra);
                }

            }
            {
                getPalabrasByVocales(nodo.getLeft(), Npalabra, palabras, n);
                getPalabrasByVocales(nodo.getRight(), Npalabra, palabras, n);
            }
        }

    }

    private boolean esVocal(char x) {
        return (x == 'A' || x == 'E' || x == 'I' || x == 'O' || x == 'U');
    }

    private int contarVocal(String palabra) {
        int i = 0;
        for (char letra : palabra.toCharArray()) {
            if (esVocal(letra)) {
                i++;
            }

        }
        return i;
    }
}
