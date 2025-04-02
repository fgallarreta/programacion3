package Practico2_1;

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
        return this.root.getValue();
    }

    public boolean hasElem(Integer value) {
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

}
