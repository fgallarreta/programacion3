package Practico3;

import java.util.*;

public class HashingConCrecimiento {

    static class HashTable {
        private int capacidad = 7;
        private double factorCarga = 0.9;
        private int cantidadElementos = 0;

        private Map<Integer, List<Integer>> tabla = new HashMap<>();

        public void insertar(int valor) {
            if ((cantidadElementos + 1) > capacidad * factorCarga) {
                redimensionar();
            }

            int indice = valor % capacidad;
            tabla.putIfAbsent(indice, new ArrayList<>());
            tabla.get(indice).add(valor);
            cantidadElementos++;
        }

        private void redimensionar() {
            System.out.println("🔁 Redimensionando de " + capacidad + " a " + (capacidad * 2));
            Map<Integer, List<Integer>> viejaTabla = tabla;
            capacidad *= 2;
            cantidadElementos = 0;
            tabla = new HashMap<>();

            for (List<Integer> bucket : viejaTabla.values()) {
                for (int valor : bucket) {
                    insertar(valor); // Se vuelve a insertar con nueva capacidad
                }
            }
        }

        public void mostrarTabla() {
            System.out.println("\n📋 Tabla Hash con capacidad = " + capacidad + ":");
            for (int i = 0; i < capacidad; i++) {
                List<Integer> bucket = tabla.getOrDefault(i, new ArrayList<>());
                System.out.println("[" + i + "]: " + bucket);
            }
        }
    }

}