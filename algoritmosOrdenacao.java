import java.util.Arrays;
import java.util.Random;


public class Main {

    // Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (arr[i - 1] > arr[i]) {
                    // Troca os elementos
                    int temp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }

    // Selection Sort
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                // Troca os elementos
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    // Insertion Sort
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // Merge Sort
    public static void mergeSort(int[] arr) {
        if (arr.length > 1) {
            int mid = arr.length / 2;
            int[] left = Arrays.copyOfRange(arr, 0, mid);
            int[] right = Arrays.copyOfRange(arr, mid, arr.length);

            mergeSort(left);
            mergeSort(right);

            int i = 0, j = 0, k = 0;
            while (i < left.length && j < right.length) {
                if (left[i] < right[j]) {
                    arr[k++] = left[i++];
                } else {
                    arr[k++] = right[j++];
                }
            }

            while (i < left.length) {
                arr[k++] = left[i++];
            }

            while (j < right.length) {
                arr[k++] = right[j++];
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[450];
        Random random = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(450);
        }

        // Medir o tempo de execução para Bubble Sort
        int arr1[] = arr;
        long startTime = System.nanoTime();
        bubbleSort(arr1);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Bubble Sort: " + Arrays.toString(arr));
        System.out.println("Tempo de execução (nanossegundos): " + duration);

        // Reinicializar o array para testar os outros algoritmos
        int arr2[] = arr;

        // Medir o tempo de execução para Selection Sort
        startTime = System.nanoTime();
        selectionSort(arr2);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("Selection Sort: " + Arrays.toString(arr));
        System.out.println("Tempo de execução (nanossegundos): " + duration);

        // Reinicializar o array para testar os outros algoritmos
        int arr3[] = arr;

        // Medir o tempo de execução para Insertion Sort
        startTime = System.nanoTime();
        insertionSort(arr3);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("Insertion Sort: " + Arrays.toString(arr));
        System.out.println("Tempo de execução (nanossegundos): " + duration);

        // Reinicializar o array para testar os outros algoritmos
        int arr4[] = arr;

        // Medir o tempo de execução para Merge Sort
        startTime = System.nanoTime();
        mergeSort(arr4);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("Merge Sort: " + Arrays.toString(arr));
        System.out.println("Tempo de execução (nanossegundos): " + duration);
    }
}
