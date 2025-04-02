package Practico2;

public class App1 {

    // Declaramos la variable estática memo fuera de cualquier método
    static String[] memo = new String[100];

    public static void main(String[] args) {
        // int[] ordenado = { 1, 2, 3, 4, 5, 6 };
        // System.out.println(BinariaRecursiva(ordenado, 7, 0, 5));
        // System.out.println(transformarDecimal(26));
        // System.out.println(fibonacci(5)); // Esto devolverá la secuencia de Fibonacci
        // hasta el 5
        int[] ordenadoEj5 = { -3, -1, 0, 2, 4, 6, 10 };
        System.out.println(buscarNroIgualPos(ordenadoEj5, 0, 05));
    }

    public static int BinariaRecursiva(int[] A, int X, int inicio, int fin) {
        int medio;
        if (inicio > fin)
            return -1; // sucederá si no se encuentra el elemento
        else {
            medio = (inicio + fin) / 2; // al ser medio un int, se realiza un truncado (pierde la parte decimal)
            if (X > A[medio])
                return BinariaRecursiva(A, X, medio + 1, fin);
            else if (X < A[medio])
                return BinariaRecursiva(A, X, inicio, medio - 1);
            else
                return medio;
        }
    }

    public static String transformarDecimal(int nro) {
        if (nro == 0) {
            return "0";
        }
        if (nro == 1) {
            return "1";
        }
        return transformarDecimal(nro / 2) + (nro % 2);
    }

    public static String fibonacci(int n) {
        // Casos base
        if (n == 0) {
            return "0";
        }
        if (n == 1) {
            return "0, 1";
        }

        // Comprobamos si ya hemos calculado fibonacci(n)
        if (memo[n] != null) {
            return memo[n]; // Retorna el valor calculado previamente si está en el memo
        }

        // Calcular la secuencia hasta n
        StringBuilder result = new StringBuilder("0, 1"); // Iniciar la secuencia con los dos primeros números
        int a = 0, b = 1;

        for (int i = 2; i <= n; i++) {
            int next = a + b;
            result.append(", ").append(next); // Añadir el siguiente número en la secuencia
            a = b;
            b = next;
        }

        // Guardar el resultado en el memo
        memo[n] = result.toString();
        return memo[n];
    }

    public static boolean buscarNroIgualPos(int[] nums, int inicio, int fin) {
        boolean hayNumero = false;
        int medio = (inicio + fin) / 2;
        if (inicio > fin) {
            return hayNumero;
        } else {
            if (medio == nums[medio]) {
                hayNumero = true;
                return hayNumero;
            } else {
                if (medio > nums[medio]) {

                    return buscarNroIgualPos(nums, medio + 1, fin);
                } else if (medio < nums[medio]) {

                    return buscarNroIgualPos(nums, inicio, medio - 1);
                }
            }
        }
        return hayNumero;
    }
}
