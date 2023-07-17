import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class ClientTerceiroDesafio {
    public static void main(String[] args) {
        ProcessClearTerminal process = ProcessClearTerminal.getInstanceProcessClearTerminal();
        process.clear();

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        boolean keepOn = true;
        while (keepOn) {
            try {
                int n = sc.nextInt();
                int k = sc.nextInt();
                if (n < 0 || k < 0 ) {
                    throw new IllegalArgumentException();
                }

                int[] arr = new int[n];

                for (int i = 0; i < n; i++) {
                    arr[i] = sc.nextInt();
                }

                int count = 0;
                for (int i = 0; i < n-1; i++) {
                    for (int j = i + 1; j < n; j++) {
                        if (Math.abs(arr[i] - arr[j]) == k) {
                            count++;
                        }
                    }
                }

            System.out.println(count);
            keepOn = false;

            } catch ( InputMismatchException e ) {
                sc.next();
                process.clear();
                System.out.println("Entre com valores válidos. Exemplo de entrada:");
                System.out.printf("%nSTDIN%n-----%n5 2%n1 5 3 4 2%n%n");
            } catch ( IllegalArgumentException e) {
                process.clear();
                System.out.println("Entre com valores válidos. Exemplo de entrada:");
                System.out.printf("%nSTDIN%n-----%n5 2%n1 5 3 4 2%n%n");
            }
        }

        sc.close();
    }
}
