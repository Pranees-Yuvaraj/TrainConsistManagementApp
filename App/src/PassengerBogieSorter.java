import java.util.Scanner;

public class PassengerBogieSorter {

    public static void bubbleSort(int[] capacities) {
        int n = capacities.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (capacities[j] > capacities[j + 1]) {
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;
                }
            }
        }
    }

    public static void display(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of bogies: ");
        int n = scanner.nextInt();

        int[] capacities = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter capacity: ");
            capacities[i] = scanner.nextInt();
        }

        System.out.println("Before Sorting:");
        display(capacities);

        bubbleSort(capacities);

        System.out.println("After Sorting:");
        display(capacities);

        scanner.close();
    }
}