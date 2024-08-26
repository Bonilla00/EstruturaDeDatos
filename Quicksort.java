package Algoritmoburbuja;

public class Quicksort {

    // Método para realizar Quicksort en un array
    public static void quicksort(int[] array, int low, int high) {
        if (low < high) {
            // Encuentra el índice de partición
            int pi = partition(array, low, high);

            // Ordena recursivamente los subarrays
            quicksort(array, low, pi - 1);
            quicksort(array, pi + 1, high);
        }
    }

    // Método para realizar la partición y encontrar el índice de partición
    public static int partition(int[] array, int low, int high) {
        int pivot = array[high]; // Elegimos el último elemento como pivote
        int i = low - 1; // Índice del menor elemento

        for (int j = low; j < high; j++) {
            // Si el elemento actual es menor o igual que el pivote
            if (array[j] <= pivot) {
                i++;
                // Intercambiamos array[i] con array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Intercambiamos array[i+1] con array[high] (o el pivote)
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1; // Retorna el índice de partición
    }

    // Método para imprimir el array
    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {10, 7, 8, 9, 1, 5};
        int n = array.length;

        System.out.println("Array original:");
        printArray(array);

        quicksort(array, 0, n - 1);

        System.out.println("Array ordenado:");
        printArray(array);
    }
}
