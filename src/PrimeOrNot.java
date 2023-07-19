import java.util.Scanner;

public class PrimeOrNot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        if (isPrime(num)){
            System.out.println("Prime number");
        }else{
            System.out.println("Not Prime number");
        }
    }
    public static boolean isPrime(int num){
        for(int i=2;i<num;i++){
            if (num%i==0){
                return false;
            }
        }
        return true;
    }
}
