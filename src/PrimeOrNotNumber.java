import java.util.Scanner;

public class PrimeOrNotNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        if (isPrime(n)) {
            System.out.println(n + " is Prime number");
        } else {
            System.out.println(n + " is not a Prime number");
        }
    }

    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i < (number / 2); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
