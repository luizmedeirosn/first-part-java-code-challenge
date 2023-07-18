import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class ClientQuartoDesafio {
    public static void main(String[] args) {
        ProcessClearTerminal process = ProcessClearTerminal.getInstanceProcessClearTerminal();
        process.clear();

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        boolean keepOn = true;
        while (keepOn) {
            try {
                int n = sc.nextInt();
                sc.nextLine();

                StringBuilder output = new StringBuilder();
                String phrase;
                int mid;

                for (int i = 0; i < n; i++) {
                    phrase = sc.nextLine();
                    InvalidPhraseException.verifyPhraseLimits(phrase);
                    InvalidPhraseException.verifyPhrase(phrase.toCharArray(), 0, phrase.length());

                    mid = (phrase.length()) / 2;
                    output.append( new StringBuilder(phrase.substring(0, mid)).reverse() );
                    output.append( new StringBuilder(phrase.substring(mid, phrase.length())).reverse() + "\n" );
                }

                System.out.println();
                System.out.print(output);
                keepOn = false;
        
        } catch (InvalidPhraseException e) {
            process.clear();
            System.out.println("Entre com os dados novamente:");
            System.out.println(e.getMessage());

        } catch(InputMismatchException e) {
            sc.next();
            process.clear();
            System.out.println("A primeira linha de entrada contém um inteiro N que indica a quantidade de casos de teste");
            System.out.println("Entre com os dados novamente:");

        } catch (Exception e ) {
            sc.next();
            process.clear();
            System.out.println("Erro inesperado");
            System.out.println("Entre com os dados novamente:");
        }

        }
                
        sc.close();
    }
}
