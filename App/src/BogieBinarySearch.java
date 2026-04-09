import java.util.Arrays;
import java.util.Scanner;

public class BogieBinarySearch {

    public static int binarySearch(String[] bogieIds, String key) {
        int low = 0;
        int high = bogieIds.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = key.compareTo(bogieIds[mid]);

            if (cmp == 0) {
                return mid;
            } else if (cmp > 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of bogies: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        String[] bogieIds = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter bogie ID: ");
            bogieIds[i] = scanner.nextLine();
        }

        Arrays.sort(bogieIds);

        System.out.print("Enter bogie ID to search: ");
        String key = scanner.nextLine();

        int result = binarySearch(bogieIds, key);

        if (result != -1) {
            System.out.println("Bogie found at position: " + result);
        } else {
            System.out.println("Bogie not found");
        }

        scanner.close();
    }
}