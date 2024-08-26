package Algoritmoburbuja;

public class CountingSort {

    // Método para obtener el valor máximo en el array
    public static int getMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    // Método para realizar el Counting Sort
    public static void countingSort(int[] array) {
        int max = getMax(array);
        int[] count = new int[max + 1];
        int[] output = new int[array.length];

        // Inicializar el array count con ceros
        for (int i = 0; i <= max; i++) {
            count[i] = 0;
        }

        // Contar la frecuencia de cada elemento
        for (int i = 0; i < array.length; i++) {
            count[array[i]]++;
        }

        // Calcular la frecuencia acumulada
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        // Construir el array de salida
        for (int i = array.length - 1; i >= 0; i--) {
            output[count[array[i]] - 1] = array[i];
            count[array[i]]--;
        }

        // Copiar el array de salida al array original
        for (int i = 0; i < array.length; i++) {
            array[i] = output[i];
        }
    }

    // Método para imprimir el array
    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    // Método principal
    public static void main(String[] args) {
        int[] array = { 11, 30, 24, 7, 31, 16 };

        System.out.println("Before sorting array elements are:");
        printArray(array);

        countingSort(array);

        System.out.println("After sorting array elements are:");
        printArray(array);
    }
}
