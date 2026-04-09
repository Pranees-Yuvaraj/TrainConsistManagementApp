import java.util.Scanner;

public class BogieSearchWithValidation {

    public static int linearSearch(String[] bogieIds, String key) {
        if (bogieIds.length == 0) {
            throw new IllegalStateException("No bogies available for search");
        }

        for (int i = 0; i < bogieIds.length; i++) {
            if (bogieIds[i].equals(key)) {
                return i;
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

        System.out.print("Enter bogie ID to search: ");
        String key = scanner.nextLine();

        try {
            int result = linearSearch(bogieIds, key);

            if (result != -1) {
                System.out.println("Bogie found at position: " + result);
            } else {
                System.out.println("Bogie not found");
            }

        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}