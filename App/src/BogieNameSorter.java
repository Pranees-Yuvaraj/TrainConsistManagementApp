import java.util.Arrays;
import java.util.Scanner;

public class BogieNameSorter {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of bogies: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        String[] bogieNames = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter bogie name: ");
            bogieNames[i] = scanner.nextLine();
        }

        Arrays.sort(bogieNames);

        System.out.println("Sorted Bogie Names:");
        System.out.println(Arrays.toString(bogieNames));

        scanner.close();
    }
}