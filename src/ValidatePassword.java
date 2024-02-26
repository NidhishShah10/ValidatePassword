import java.util.Scanner;

public class ValidatePassword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a password to check if it validates:");
        String password = scanner.nextLine();
        if (isValidPassword(password)) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Password is invalid.");
        }
        scanner.close();
    }

    public static boolean isValidPassword(String password) {
        if (password.length() < 8 || password.length() > 16) {
            return false;
        }

        int categoryCount = 0;
        if (containsLowerCase(password)) categoryCount++;
        if (containsUpperCase(password)) categoryCount++;
        if (containsNumber(password)) categoryCount++;
        if (containsSpecialCharacter(password)) categoryCount++;

        return categoryCount >= 3;
    }

    private static boolean containsLowerCase(String password) {
        return password.matches(".*[a-z].*");
    }

    private static boolean containsUpperCase(String password) {
        return password.matches(".*[A-Z].*");
    }

    private static boolean containsNumber(String password) {
        return password.matches(".*\\d.*");
    }

    private static boolean containsSpecialCharacter(String password) {
        return password.matches(".*[~!@#$%^&*()\\-=_+].*");
    }
}
