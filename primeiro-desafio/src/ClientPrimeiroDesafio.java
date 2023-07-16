import java.util.AbstractQueue;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ClientPrimeiroDesafio {
    public static void main(String[] args) {
        ProcessClearTerminal process = ProcessClearTerminal.getInstanceProcessClearTerminal();
        process.clear();
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        AbstractQueue<Integer> evenNumbersInOrder = new PriorityQueue<>( Comparator.naturalOrder() );
        AbstractQueue<Integer> oddNumbersInOrder = new PriorityQueue<>( Comparator.reverseOrder() );
        
        boolean keepOn = true;
        while (keepOn) {
            try {
                System.out.print("Entre com o valor de N: ");
                int n = sc.nextInt();
                if (n <= 1 || n > Math.pow(10, 5)) {
                    throw new InvalidIntegerException("A entrada deve ser um único inteiro positivo N (1 < N <= 10^5)");
                }
                for (int i = 1; i <= n; i++) {
                    System.out.print("Entre com o " + i + "º inteiro: ");
                    int num = sc.nextInt();
                    if (num < 0) throw new InvalidIntegerException("Digite valores inteiros não negativos");
                    
                    if (num % 2 == 0) {
                        evenNumbersInOrder.add(num);
                    } else {
                        oddNumbersInOrder.add(num);
                    }
                }
                keepOn = false;

            } catch (InvalidIntegerException e) {
                evenNumbersInOrder.clear();
                oddNumbersInOrder.clear();
                process.clear();
                System.out.println(e.getMessage());

            } catch (InputMismatchException e ) {
                evenNumbersInOrder.clear();
                oddNumbersInOrder.clear();
                sc.next();
                process.clear();
                System.out.println("Digite valores inteiros válidos");
            }
        }

        StringBuilder evenNumbersOutput = new StringBuilder();
        StringBuilder oddNumbersOutput = new StringBuilder();

        while ( !evenNumbersInOrder.isEmpty() ) {
            evenNumbersOutput.append( String.format("%d%n", evenNumbersInOrder.poll()) );
        }
        while ( !oddNumbersInOrder.isEmpty() ) {
            oddNumbersOutput.append( String.format("%d%n", oddNumbersInOrder.poll()) );
        }

        System.out.print(evenNumbersOutput);
        System.out.print(oddNumbersOutput);

        sc.close();
    }
}