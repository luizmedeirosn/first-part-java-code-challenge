import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ClientSegundoDesafio {
    public static void main(String[] args) {
        ProcessClearTerminal process = ProcessClearTerminal.getInstanceProcessClearTerminal();
        process.clear();

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Map<Integer, Integer> withdrawMap = new TreeMap<>( Comparator.reverseOrder() );
        withdrawMap.put(10000, 0); withdrawMap.put(5000, 0);  withdrawMap.put(2000, 0);
        withdrawMap.put(1000, 0);  withdrawMap.put(500, 0);   withdrawMap.put(200, 0);
        withdrawMap.put(100, 0);   withdrawMap.put(50, 0);   withdrawMap.put(25, 0);
        withdrawMap.put(10, 0);   withdrawMap.put(5, 0);   withdrawMap.put(1, 0);

        Iterator< Map.Entry<Integer, Integer> > iterator = withdrawMap.entrySet().iterator();
        Map.Entry<Integer, Integer> entry = iterator.next();
        
        boolean keepOn = true;
        while (keepOn) {
            try {
                // trabalhando com inteiros para evitar problemas de comparação de float ou double;
                double doubleValue;
                int intValue;

                System.out.print("Entre com o valor monetário: ");
                doubleValue = sc.nextDouble();
                InvalidInputException.verify(doubleValue);

                // considerando até duas casas decimais para trabalhar na contagem do dinheiro;
                intValue = (int)(doubleValue*100);

                int valueKey;
                while ( intValue > 0 ) {
                    valueKey = (intValue / entry.getKey());
                    withdrawMap.put( entry.getKey(), valueKey );
                    intValue -= (valueKey * entry.getKey());
                    if (iterator.hasNext()) {
                        entry = iterator.next();
                    }
                }

                StringBuilder output = new StringBuilder();
                output.append( String.format("%nNOTAS:%n") );
                output.append( String.format("%d nota(s) de R$ 100.00%n", withdrawMap.get(10000)) );
                output.append( String.format("%d nota(s) de R$ 50.00%n", withdrawMap.get(5000)) );
                output.append( String.format("%d nota(s) de R$ 20.00%n", withdrawMap.get(2000)) );
                output.append( String.format("%d nota(s) de R$ 10.00%n", withdrawMap.get(1000)) );
                output.append( String.format("%d nota(s) de R$ 5.00%n", withdrawMap.get(500)) );
                output.append( String.format("%d nota(s) de R$ 2.00%n", withdrawMap.get(200)) );
                output.append( String.format("MOEDAS:%n") );
                output.append( String.format("%d moeda(s) de R$ 1.00%n", withdrawMap.get(100)) );
                output.append( String.format("%d moeda(s) de R$ 0.50%n", withdrawMap.get(50)) );
                output.append( String.format("%d moeda(s) de R$ 0.25%n", withdrawMap.get(25)) );
                output.append( String.format("%d moeda(s) de R$ 0.10%n", withdrawMap.get(10)) );
                output.append( String.format("%d moeda(s) de R$ 0.05%n", withdrawMap.get(5)) );
                output.append( String.format("%d moeda(s) de R$ 0.01%n", withdrawMap.get(1)) );

                System.out.println(output);
                keepOn = false;

            } catch (InvalidInputException e ) {
                process.clear();
                System.out.println("Informe um valor de ponto flutuante N (0 <= N <= 1000000.00)");
            } catch (InputMismatchException e) {
                sc.next();
                process.clear();
                System.out.println("Informe um valor de ponto flutuante N (0 <= N <= 1000000.00)");
            } catch (Exception e ) {
                process.clear();
                System.out.println("Ocorreu um erro inesperado, tente novamente");
            }
        }

        sc.close();
    }
}
