package Practico4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class GrafoDirigido<T> implements Grafo<T> {
    private HashMap<Integer, LinkedList<Arco<T>>> vertices;

    public GrafoDirigido() {
        this.vertices = new HashMap<>();
    }

    @Override
    public void agregarVertice(int verticeId) {
        if (!vertices.containsKey(verticeId)) {
            vertices.put(verticeId, new LinkedList<Arco<T>>());
        }
    }

    @Override
    public void borrarVertice(int verticeId) {
        if (vertices.containsKey(verticeId)) {
            vertices.remove(verticeId);
        } else {
            System.out.println("El vertice " + verticeId + " no existe");
        }
    }

    @Override
    public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
        if (!vertices.containsKey(verticeId1) || !vertices.containsKey(verticeId2)) {
            System.out.println("El grafo no contiene al menos uno de los vertices");
        } else {
            vertices.get(verticeId1).add(new Arco<T>(verticeId1, verticeId2, etiqueta));
        }
    }

    @Override
    public void borrarArco(int verticeId1, int verticeId2) {
        if (!vertices.containsKey(verticeId1) || !vertices.containsKey(verticeId2)) {
            System.out.println("El grafo no contiene al menos uno de los vertices");
        } else {
            LinkedList<Arco<T>> arcos = vertices.get(verticeId1);
            arcos.removeIf(arco -> arco.getVerticeDestino() == verticeId2);
        }
    }

    @Override
    public boolean contieneVertice(int verticeId) {
        return vertices.containsKey(verticeId);
    }

    @Override
    public boolean existeArco(int verticeId1, int verticeId2) {

        if (!vertices.containsKey(verticeId1) || !vertices.containsKey(verticeId2)) {
            System.out.println("El grafo no contiene al menos uno de los vertices");
            return false;
        } else {
            LinkedList<Arco<T>> arcos = vertices.get(verticeId1);
            for (Arco<T> arco : arcos) {
                if (arco.getVerticeDestino() == verticeId2 && arco.getVerticeOrigen() == verticeId1)
                    return true;
            }
        }
        return false;
    }

    @Override
    public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
        if (!vertices.containsKey(verticeId1) || !vertices.containsKey(verticeId2)) {
            System.out.println("El grafo no contiene al menos uno de los vertices");
            return null;
        } else {
            LinkedList<Arco<T>> arcos = vertices.get(verticeId1);
            for (Arco<T> arco : arcos) {
                if (arco.getVerticeDestino() == verticeId2 && arco.getVerticeOrigen() == verticeId1)
                    return arco;
            }
        }
        return null;

    }

    @Override
    public int cantidadVertices() {
        return this.vertices.size();
    }

    @Override
    public int cantidadArcos() {
        int cantArcos = 0;
        for (LinkedList<Arco<T>> arcos : vertices.values()) {
            cantArcos += arcos.size();
        }
        return cantArcos;
    }

    @Override
    public Iterator<Integer> obtenerVertices() {
        Iterator<Integer> iterador = vertices.keySet().iterator();
        return iterador;
    }

    @Override
    public Iterator<Integer> obtenerAdyacentes(int verticeId) {
        if (!vertices.containsKey(verticeId)) {
            return null; // Manejar el caso donde el vértice no está en el grafo
        }

        LinkedList<Integer> vecinos = new LinkedList<>();

        for (Arco<T> arco : vertices.get(verticeId)) {
            vecinos.add(arco.getVerticeDestino());
        }

        return vecinos.iterator();
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos() {
        LinkedList<Arco<T>> listaArcos = new LinkedList<>();
        for (LinkedList<Arco<T>> listaAdyacente : vertices.values()) {
            listaArcos.addAll(listaAdyacente);
        }
        return listaArcos.iterator();
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos(int verticeId) {
        if (!vertices.containsKey(verticeId)) {
            return null; // Manejar el caso donde el vértice no está en el grafo
        }

        return vertices.get(verticeId).iterator();
    }

}
