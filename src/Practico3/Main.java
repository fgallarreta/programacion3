package Practico3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Practico3.HashingConCrecimiento.HashTable;

public class Main {
    public static void main(String[] args) {
        int[] elementos = {
                68, 42, 47, 5, 76, 95, 23, 88, 90, 85, 31, 71, 60,
                10, 46, 61, 50, 92, 74, 6, 97, 66, 1, 56, 27, 7, 14, 92
        };

        int M = 7;
        Map<Integer, List<Integer>> tablaHash = new HashMap<>();

        for (int elem : elementos) {
            int indice = elem % M;
            tablaHash.putIfAbsent(indice, new ArrayList<>());
            tablaHash.get(indice).add(elem);
        }

        // Mostrar contenido de la tabla
        System.out.println("📋 Tabla Hash con M = 7 (HashMap<Integer, List<Integer>>):");
        for (int i = 0; i < M; i++) {
            List<Integer> lista = tablaHash.getOrDefault(i, new ArrayList<>());
            System.out.println("[" + i + "]: " + lista);
        }
        HashTable tabla = new HashTable();
        for (int x : elementos) {
            tabla.insertar(x);
        }

        tabla.mostrarTabla();
    }
}
/*
 * 1. ¿Se puede listar en orden todas las claves almacenadas en una estructura
 * de hashing?
 * Sí, se puede, pero no directamente.
 * 
 * Las estructuras de hashing como HashMap o Hashtable no mantienen orden de
 * claves.
 * Para listarlas en orden, primero hay que extraerlas y luego ordenarlas
 * manualmente. Por ejemplo:
 * 
 * List<K> clavesOrdenadas = new ArrayList<>(map.keySet());
 * Collections.sort(clavesOrdenadas);
 * ¿Es la estructura más adecuada?
 * No, si el orden es importante. En ese caso, conviene usar estructuras como:
 * 
 * TreeMap (que mantiene las claves ordenadas automáticamente)
 * 
 * Árboles binarios de búsqueda balanceados
 * 
 * 2. ¿Qué tipos de servicios resuelve un hashing? ¿Es posible responder: “La
 * lista de todos los alumnos que obtuvieron una nota mayor que x en un curso
 * dado”?
 * Hashing es ideal para:
 * 
 * Acceso rápido a datos por clave
 * 
 * Inserción, búsqueda y eliminación eficiente (tiempo promedio constante O(1))
 * 
 * Ejemplos:
 * 
 * Buscar un alumno por su DNI
 * 
 * Verificar si una clave existe
 * 
 * Acceder rápidamente a datos únicos o claves específicas
 * 
 * ¿Se puede hacer el ejemplo dado?
 * 
 * "La lista de todos los alumnos que obtuvieron una nota mayor que x"
 * 
 * Sí, es posible, pero no se aprovechan las ventajas del hashing, ya que hay
 * que recorrer todos los valores:
 * 
 * java
 * Copiar
 * Editar
 * for (Alumno a : mapa.values()) {
 * if (a.getNota() > x) {
 * // incluir en la lista
 * }
 * }
 * ¿Es la estructura más adecuada?
 * No. Para este tipo de búsquedas por condición o rango, son preferibles:
 * 
 * TreeMap (si las notas son las claves)
 * 
 * Listas ordenadas
 * 
 * Bases de datos o estructuras indexadas
 * 
 * Resumen
 * Pregunta ¿Es posible? ¿Es adecuado? Justificación breve
 * 1. Listar claves en orden Sí No Se puede ordenar manualmente, pero no es el
 * propósito del hashing.
 * 2. Filtrar por condición (nota > x) Sí No Requiere recorrer todos los
 * valores; no se aprovecha el hash.
 * 
 * 
 * Ejercicio 3
 * Se está desarrollando una aplicación que almacena los datos y el saldo de las
 * tarjetas de
 * compra de comida del comedor de una universidad. Cada cliente es identificado
 * por su
 * número de DNI, y se poseen además sus datos personales y de la carrera que
 * estudia.
 * 
 * CLIENTE: DNI, Nombre, Apellido, fecha de nacimiento, domicilio, CP ciudad de
 * origen, saldo
 * de la cuenta, nombre carrera estudia
 * 
 * Se quiere:
 * 
 * a) Dado un DNI de cliente, responder el saldo de su cuenta.
 * 
 * RTA: HashTable donde las claves sean los números de DNI de los clientes y los
 * valores sean los saldos
 * de sus cuentas.
 * 
 * b) Imprimir un listado de Nombre y Apellido de todos los clientes que tienen
 * en su saldo
 * de cuenta menos de un valor X dado.
 * 
 * RTA: Árbol de búsqueda binario.
 * 
 * c) Dado un código postal, listar todos los clientes que provengan de esa
 * ciudad.
 * 
 * RTA: HashTable donde las claves sean los códigos postales y los valores sean
 * listas enlazadas
 * de clientes que provienen de esa ciudad. Cada cliente tendría asociado su
 * nombre y apellido.
 * 
 * Ejercicio 4 (2do intento)
 * Se desea desarrollar una aplicación para mejorar la atención de una
 * biblioteca en cuanto a la
 * búsqueda de libros dentro del catálogo disponible. Cada libro estará
 * compuesto por un
 * identificador único y datos propios de los libros (título, autor, géneros,
 * año de publicación,
 * cantidad de ejemplares, etc.)
 * 
 * Se sabe, además, que los libros nuevos se agregan al catálogo en horarios
 * fuera de la
 * atención al público.
 * 
 * Se desean proveer los siguientes servicios:
 * 
 * • Obtener la cantidad de ejemplares de un libro dado su identificador único.
 * • Obtener todos los libros de un género dado.
 * • Obtener todos los libros publicados entre dos años de publicación dados.
 * 
 * Responda y justifique:
 * 
 * 1) ¿Qué estructura de datos utilizaría para almacenar todos los libros en
 * memoria dentro
 * de la aplicación?
 * 
 * Utilizaría un árbol de búsqueda binario ordenado por el identificador único
 * de los libros.
 * Esto permitiría una búsqueda rápida de libros por su identificador único y
 * también proporcionaría
 * una forma eficiente de agregar nuevos libros al catálogo.
 * 
 * 2) ¿Cómo resolvería cada uno de los servicios solicitados? ¿Utilizaría alguna
 * estructura
 * adicional de acceso para mejorar el costo de respuesta de cada servicio?
 * 
 * • Obtener la cantidad de ejemplares de un libro dado su identificador único.
 * Para este servicio, simplemente se buscaría el libro por su identificador
 * único en el árbol de búsqueda. La cantidad de ejemplares se obtendría del
 * nodo correspondiente encontrado en el árbol.
 * 
 * • Obtener todos los libros de un género dado.
 * Se podría mejorar la eficiencia de este servicio utilizando un índice
 * adicional que mapee
 * cada género a una lista de libros que pertenecen a ese género.
 * 
 * • Obtener todos los libros publicados entre dos años de publicación dados.
 * Similar al servicio 2, se podría utilizar un índice adicional que mapee los
 * años de publicación
 * a una lista de libros publicados en ese año.
 */